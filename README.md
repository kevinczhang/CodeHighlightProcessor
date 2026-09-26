# CodeHighlightProcessor

A small Python utility that turns a collection of Java LeetCode solutions and HTML problem
descriptions into a queryable SQLite database. Each solution is syntax highlighted with
[Pygments](https://pygments.org/) and stored as self-contained HTML alongside its problem
metadata (number, title, difficulty, tags, companies, special tags) in `leetcode_problems.db`.

## Repository structure

```
CodeHighlightProcessor/
├── Common/
│   ├── DBSInitialization.py    # Creates the PROBLEMS table (run first)
│   └── Entry.py                # Earlier prototype processor (superseded)
├── JavaCode/
│   ├── javaProcessor.py        # Main processor: reads files, highlights, inserts rows
│   ├── Constants.java          # tags / companies / specialTags vocabularies
│   ├── descriptions/           # HTML problem descriptions, by category
│   │   ├── Easy/  Medium/  Hard/  Facebook/  CodeSnippets/
│   ├── solutions/              # Java solutions, by category
│   │   ├── Easy/  Medium/  Hard/  Facebook/  CodeSnippets/
│   ├── outputs/                # Generated standalone HTML output
│   └── leetcode_problems.db    # SQLite database produced by the pipeline
└── requirements.txt
```

- **`Common/DBSInitialization.py`** — creates the `PROBLEMS` table. Run this first to
  initialize the database; it writes to `../JavaCode/leetcode_problems.db`.
- **`Common/Entry.py`** — an earlier prototype processor that highlights a directory of files
  and writes HTML output. It is superseded by `JavaCode/javaProcessor.py`.
- **`JavaCode/javaProcessor.py`** — the main processor. `processEasyProblems` builds the
  hard-coded `entries` list, buckets each entry by problem number range and difficulty
  (`10000 < number <= 11000` → Facebook, `11000 < number <= 12000` → CodeSnippets, otherwise
  Easy/Medium/Hard), and calls `saveToDB` per bucket. `saveToDB` reads the matching
  `solutions/<Category>/<fileName>.java` and `descriptions/<Category>/<fileName>.html` files,
  highlights the Java source with Pygments' `JavaLexer` and inline-styled `HtmlFormatter`, and
  inserts one row per problem.
- **`JavaCode/Constants.java`** — defines the `tags`, `companies`, and `specialTags` string
  arrays. Entries in `javaProcessor.py` reference these arrays by comma-separated numeric
  indices (e.g. `tags = '0, 1'` means `Array, Hash Table`; `companies = '0'` means `Facebook`;
  `specialTags = '1'` means `CodeSnippet`).

## Prerequisites

- Python 3 (required — the processor opens files with `encoding="utf8"`)
- The `pygments` package

## Setup

```bash
pip install -r requirements.txt
# or simply
pip install pygments
```

## Usage

The pipeline is two steps.

1. Initialize the database schema:

   ```bash
   cd Common
   python DBSInitialization.py
   ```

   This creates the `PROBLEMS` table in `../JavaCode/leetcode_problems.db`.

2. Run the processor:

   ```bash
   cd JavaCode
   python javaProcessor.py
   ```

   The entry point calls `JavaProcessor().processEasyProblems('./solutions/', './descriptions/')`,
   so it must be run from inside `JavaCode/` — the paths `./solutions/` and `./descriptions/`
   and the database name `leetcode_problems.db` are all relative to the working directory.

## Data model

### `PROBLEMS` table

| Column        | Type       | Notes                                              |
| ------------- | ---------- | -------------------------------------------------- |
| `ID`          | INT        | Primary key; sequential index assigned at insert    |
| `NUMBER`      | INT        | LeetCode problem number (or internal ID ≥ 10001)    |
| `TITLE`       | TEXT       | Problem title                                       |
| `DIFFICULTY`  | CHAR(10)   | `Easy`, `Medium`, or `Hard`                         |
| `DESCRIPTION` | TEXT       | Raw HTML read from `descriptions/`                  |
| `SOLUTION`    | TEXT       | Syntax-highlighted HTML document of the Java source |
| `TAGS`        | TEXT       | Comma-separated indices into `Constants.tags`       |
| `COMPANIES`   | TEXT       | Comma-separated indices into `Constants.companies`  |
| `RELATED`     | TEXT       | Comma-separated indices into `Constants.specialTags`|

### Entry tuple format

Each item of the `entries` list in `processEasyProblems` is:

```python
(number, title, difficulty, fileName, tags, companies, specialTags)
```

`fileName` is the base name shared by the solution (`.java`) and description (`.html`) files.

```python
entries.append(('1', 'Two Sum', 'Easy', 'twoSum', '0, 1', '', ''))
```

## Known issues

- **Column-name mismatch.** `Common/DBSInitialization.py` creates the last column as `RELATED`,
  but `saveToDB` in `JavaCode/javaProcessor.py` inserts into a column named `SpecialTags`:

  ```python
  "INSERT INTO Problems (ID, Number, Title, Difficulty, Description, Solution, Tags, Companies, SpecialTags) ..."
  ```

  Running the pipeline against a freshly initialized schema will therefore fail with
  `sqlite3.OperationalError: table Problems has no column named SpecialTags`. The two names
  need to be aligned (rename the column in the schema, or the column in the `INSERT`) before
  the pipeline works end to end.
- The `entries` list is hard-coded in `javaProcessor.py`; adding a problem means editing the
  source and dropping the corresponding `.java` / `.html` files into the right category folders.
- `javaProcessor.py` always inserts and never upserts, so re-running it against a populated
  database raises a primary key conflict. Delete/recreate the database between runs.
