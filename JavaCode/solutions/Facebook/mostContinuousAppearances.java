public class Solution {
    /**
     * Solution 1 use dp table to track max
     * Get result in second scan
     */
    public static List<Character> mostContinuous(String s) {
        List<Character> list = new ArrayList<>();
        if (s == null || s.trim().isEmpty())
            return list;

        s = s.trim().replaceAll(" ", "");
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = s.charAt(i) == s.charAt(i - 1) ? dp[i - 1] + 1 : 1;
            max = Math.max(max, dp[i]);
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                list.add(s.charAt(i));
            }
        }
        return list;
    }

    /***
     * Solution2:  Keep track of max, one sacn
     * @param str
     */
    public void continuousChar(String str) {
        str = str.trim();
        if (str == null || str.length() == 0)
            return;

        char[] arr = str.toCharArray();
        int max = 1;
        int count = 1;
        char prev = arr[0];
        ArrayList<Character> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ' ')
                continue;
            if (arr[i] == prev) {
                count++;
            } else {
                if (count > max) {
                    result.clear();
                    result.add(prev);
                    max = count;
                } else if (count == max) {
                    result.add(prev);
                }
                prev = arr[i];
                count = 1;
            }
        }

        System.out.println(Arrays.toString(result.toArray()));
    }
}