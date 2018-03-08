public class Solution {
    private int count = 0;
    private Map<Character, Character> map = new HashMap<>();

    public int strobogrammaticInRange(String low, String high) {
        if (low == null || low.length() == 0 || high == null || high.length() == 0) {
            return 0;
        }

        fillMap();

        for (int n = low.length(); n <= high.length(); n++) {
            char[] arr = new char[n];
            getStrobogrammaticNumbers(arr, 0, n - 1, low, high);
        }

        return count;
    }

    private void getStrobogrammaticNumbers(char[] arr, int start, int end, String low, String high) {
        if (start > end) {
            String s = new String(arr);
            if ((s.length() == 1 || s.charAt(0) != '0') && compare(low, s) && compare(s, high)) {
                count++;
            }
            return;
        }

        for (char c : map.keySet()) {
            arr[start] = c;
            arr[end] = map.get(c);

            if ((start < end) || (start == end && map.get(c) == c)) {
                getStrobogrammaticNumbers(arr, start + 1, end - 1, low, high);
            }
        }
    }

    // Return true if s1 <= s2
    private boolean compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            if (s1.compareTo(s2) <= 0) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }

    private void fillMap() {
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
    }
}