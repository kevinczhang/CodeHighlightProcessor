public class Solution {
    public int evalRPN(String[] tokens) {
        //Start 10:10
        // 1, Push all tokens into stack.
        // 2, Pop one entry each time,
        // 2.1 If it is an operand then push into second stack
        // 2.2 If it is an operator, then pop out two entries from second stack.
        // Evaluate the result and push the result back into the second stack.
        // 3, Stop when the stack is empty.
        // 4, Return the value in the second stack as result.

        Stack<Integer> valueStack = new Stack<Integer>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int firstValue = valueStack.pop();
                int secondValue = valueStack.pop();
                switch (s) {
                    case "+":
                        valueStack.push(firstValue + secondValue);
                        break;
                    case "-":
                        valueStack.push(secondValue - firstValue);
                        break;
                    case "*":
                        valueStack.push(firstValue * secondValue);
                        break;
                    case "/":
                        valueStack.push(secondValue / firstValue);
                        break;
                }
            } else {
                valueStack.push(Integer.parseInt(s));
            }
        }

        return valueStack.pop();
    }
}