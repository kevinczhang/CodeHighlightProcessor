import sqlite3

from pygments.formatters.html import HtmlFormatter


class DBInitialization(object):
    def run(self):

        conn = sqlite3.connect('../JavaCode/leetcode_problems.db')
        print("Opened database successfully");

        conn.execute('''CREATE TABLE PROBLEMS
                 (ID INT PRIMARY KEY    NOT NULL,
                    NUMBER INT  NOT NULL,
                    TITLE  TEXT NOT NULL,
                    DIFFICULTY  CHAR(10) NOT NULL,
                    DESCRIPTION    TEXT NOT NULL,
                    SOLUTION TEXT NOT NULL,
                    TAGS    TEXT NOT NULL,
                    COMPANIES TEXT,
                    RELATED TEXT);''')

        conn.commit()
        print("Problems Table created successfully");
        conn.close()

if __name__ == '__main__':
    DBInitialization().run()