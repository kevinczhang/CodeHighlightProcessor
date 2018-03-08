public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // check if [s1. ∞] obtains s2
        if (!ableToObtain(s1, s2))
            return 0;
        int cnt = 0, k = -1;
        String s = s1;
        // record 'remain string'
        StringBuilder remainBuilder;
        // record all the 'remain string'
        List<String> stringList = new ArrayList<>();
        // record matching count from start to the current remain string
        List<Integer> countList = new ArrayList<>();
        stringList.add(""); // record empty string
        countList.add(0);
        for (int i = 0; i <= n1; i++) {
            remainBuilder = new StringBuilder();
            // get the next remain string, returns the count of matching
            cnt += getRemain(s, s2, remainBuilder);
            String remain = remainBuilder.toString();
            // if there is a loop, break
            if ((k = stringList.indexOf(remain)) != -1)
                break;
            stringList.add(remain); // record the remain string into arraylist
            countList.add(cnt);
            s = remain + s1; // append s1 to make a new string
        }
        // here, k is the beginning of the loop
        if (k == -1)
            return cnt / n2; // if there is no loop
        // get matching count in the loop, and loop length
        int countOfLoop = cnt - countList.get(k);
        int loopLength = stringList.size() - k;
        cnt = countList.get(k) + countOfLoop * ((n1 - k) / loopLength);
        n1 = (n1 - k) % loopLength;
        cnt += countList.get(k + n1) - countList.get(k);
        return cnt / n2;
    }

    private boolean ableToObtain(String s1, String s2) {
        boolean[] cnt = new boolean[26];
        for (char c : s1.toCharArray())
            cnt[c - 'a'] = true;
        for (char c : s2.toCharArray()) {
            if (!cnt[c - 'a'])
                return false;
        }
        return true;
    }

    private int getRemain(String s1, String s2, StringBuilder remain) {
        int cnt = 0, lastMatch = -1, p2 = 0;
        for (int p1 = 0; p1 < s1.length(); p1++) {
            if (s1.charAt(p1) != s2.charAt(p2)) continue;
            if (++p2 == s2.length()) {
                p2 = 0;
                cnt++;
                lastMatch = p1;
            }
        }
        remain.append(s1.substring(lastMatch + 1));
        return cnt;
    }
}