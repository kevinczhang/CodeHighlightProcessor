public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int i = 0, count = 0, len = 0;
        while (i < words.length) {
            len += words[i].length() + 1;
            if (len - 1 <= maxWidth) {
                i++;
                count++;
                continue;
            }
            fillString(words, res, count, i - count, maxWidth);
            len = 0;
            count = 0;
        }
        fillString(words, res, count, i - count, maxWidth);
        return res;
    }

    void fillString(String[] words, List<String> res, int count, int start, int maxWidth) {
        StringBuilder sb = new StringBuilder(maxWidth);
        int totalspace = maxWidth;
        for (int i = start; i < start + count; i++)
            totalspace -= words[i].length();

        // Only one word in this line or last line
        if (count == 1 || start + count == words.length) {
            for (int i = start; i < start + count; i++) {
                sb.append(words[i]);
                if (totalspace > 0) {
                    sb.append(" ");
                    totalspace--;
                }
            }
            while (totalspace > 0) {
                sb.append(" ");
                totalspace--;
            }
            res.add(sb.toString());
            return;
        }

        int extraspacelen = totalspace % (count - 1);
        StringBuilder evenSpaces = new StringBuilder(totalspace / (count - 1));
        for (int i = 0; i < totalspace / (count - 1); i++)
            evenSpaces.append(" ");
        for (int i = start; i < start + count - 1; i++) {
            sb.append(words[i]);
            sb.append(evenSpaces);
            if (extraspacelen > 0) {
                sb.append(" ");
                extraspacelen--;
            }
        }
        sb.append(words[start + count - 1]);
        res.add(sb.toString());
    }
}
