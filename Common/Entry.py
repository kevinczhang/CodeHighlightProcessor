import os
import sqlite3

from pygments import highlight
from pygments.formatters.html import HtmlFormatter
from pygments.lexers.jvm import JavaLexer
from pygments.lexers.python import PythonLexer


class JavaProcessor(object):
    def run(self, inputDir, outputDir):

        conn = sqlite3.connect('leetcode_problems.db')
        print("Opened database successfully");

        files = os.listdir(inputDir)

        for file in files:
            print(file)
            code = open(file, 'r').read()
            formatter = HtmlFormatter()
            formatter.noclasses = True
            highlightedCode = highlight(code, JavaLexer(), formatter)
            styleCode = HtmlFormatter().get_style_defs('.highlight')
            filename = file.split('.')[0]

            text_file = open(outputDir + '/' + filename + '.html', "w")
            text_file.write('<!DOCTYPE html>')
            text_file.write('<html>')
            text_file.write('<head>')
            text_file.write('<style>')
            text_file.write(styleCode)
            text_file.write('</style>')
            text_file.write('</head>')
            text_file.write('<body>')
            text_file.write(highlightedCode)
            text_file.write('</body>')
            text_file.write('</html>')
            text_file.close()

            formattedText = '<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">'
            formattedText += '<html>'
            formattedText += '<head>'
            formattedText += '<style>'
            formattedText += styleCode
            formattedText += '</style>'
            formattedText += '</head>'
            formattedText += '<body>'
            formattedText += highlightedCode
            formattedText += '</body>'
            formattedText += '</html>'

            conn.execute("INSERT INTO Problems (ID, Number, Title, Difficulty, Description, Solution) \
            VALUES (?, ?, ?, ?, ?, ?)", (9, '9', 'Two Sum', 'Easy', 'Problem description', formattedText));

        conn.commit()
        print("Records created successfully");
        conn.close()

if __name__ == '__main__':
    print(JavaProcessor().run('./inputs', './outputs'))
