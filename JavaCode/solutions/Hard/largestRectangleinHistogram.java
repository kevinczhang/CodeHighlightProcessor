public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0, i = 0;

        while (i < heights.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else { //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                max = Math.max(max, heights[p]*(stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            max = Math.max(max, heights[p]*(stack.isEmpty() ? i : i - stack.peek() - 1));
        }
        return max;
    }
}