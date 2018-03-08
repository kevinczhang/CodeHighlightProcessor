public class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (s.length() == 0 || t.length() == 0) {
            return result;
        }

        int[] map = new int[256];
        int[] window = new int[256];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int minLength = Integer.MAX_VALUE;
        int letterCounter = 0;
        for (int slow = 0, fast = 0; fast < s.length(); fast++) {
            if (map[s.charAt(fast)] > 0) {
                window[s.charAt(fast)]++;
                if (window[s.charAt(fast)] <= map[s.charAt(fast)]) {
                    letterCounter++;
                }
            }

            if (letterCounter >= t.length()) {
                while (map[s.charAt(slow)] == 0 || window[s.charAt(slow)] > map[s.charAt(slow)]) {
                    window[s.charAt(slow)]--;
                    slow++;
                }
                if (fast - slow + 1 < minLength) {
                    minLength = fast - slow + 1;
                    result = s.substring(slow, slow + minLength);
                }
            }
        }
        return result;
    }
}