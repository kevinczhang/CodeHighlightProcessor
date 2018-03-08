public class Solution {
    // Solution with Stack
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> indexStack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !indexStack.isEmpty() &&
                    s.charAt(indexStack.peek()) == '(') {
                indexStack.pop();
                if (indexStack.isEmpty())
                    res = i + 1;
                else
                    res = Math.max(res, i - indexStack.peek());
            } else {
                indexStack.push(i);
            }
        }
        return res;
    }

    Solution without stack
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}