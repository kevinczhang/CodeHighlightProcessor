public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        int len = s.length();
        boolean[][] palindromeTable = new boolean[len][len];

        // build palindrome dp table
        for (int i = 0; i < len; i++) {
            palindromeTable[i][i] = true;

            int l = i, r = i + 1;
            while (l >= 0 && r <= len - 1 && s.charAt(l) == s.charAt(r)) {
                palindromeTable[l--][r++] = true;
            }

            l = i - 1;
            r = i + 1;
            while (l >= 0 && r <= len - 1 && s.charAt(l) == s.charAt(r)) {
                palindromeTable[l--][r++] = true;
            }
        }
        List<String> partition = new ArrayList<String>();
        addPalindrome(s, 0, partition, res, palindromeTable);

        return res;
    }

    private void addPalindrome(String s, int start, List<String> partition,
                               List<List<String>> result, boolean[][] palindromeTable) {
        // stop condition
        if (start == s.length()) {
            List<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (palindromeTable[start][i]) {
                String str = s.substring(start, i + 1);
                partition.add(str);
                addPalindrome(s, i + 1, partition, result, palindromeTable);
                partition.remove(partition.size() - 1);
            }
        }
    }
}