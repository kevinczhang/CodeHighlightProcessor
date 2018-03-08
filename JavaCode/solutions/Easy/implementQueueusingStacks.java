class MyQueue {
    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> assistStack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        assistStack.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        if(mainStack.isEmpty()){
            while(!assistStack.isEmpty()){
                mainStack.push(assistStack.pop());
            }
        }
        return mainStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(mainStack.isEmpty()){
            while(!assistStack.isEmpty()){
                mainStack.push(assistStack.pop());
            }
        }
        return mainStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return mainStack.isEmpty() && assistStack.isEmpty();
    }
}