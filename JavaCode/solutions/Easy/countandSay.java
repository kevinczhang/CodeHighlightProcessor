public class Solution {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder prev = curr;
            curr = new StringBuilder();
            int count = 1;
            char say = prev.charAt(0);

            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
}