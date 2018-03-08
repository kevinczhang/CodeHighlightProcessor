public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(') ||
                    s.charAt(i) == '}' &&(stack.isEmpty() || stack.pop() != '{') ||
                    s.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')){
                return false;
            }
            i++;
        }
        return stack.isEmpty();
    }
}