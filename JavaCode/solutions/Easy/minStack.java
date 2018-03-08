class MinStack {
    Deque<Integer> stackContent = new ArrayDeque<Integer>();
    Deque<Integer> stackMinVal = new ArrayDeque<Integer>();

    public void push(int x) {
        this.stackContent.push(x);
        if (this.stackMinVal.isEmpty() || x <= this.stackMinVal.peek()) {
            this.stackMinVal.push(x);
        }
    }

    public void pop() {
        if (this.stackContent.isEmpty()) return;
        if (this.stackContent.peek().equals(this.stackMinVal.peek())) {
            this.stackMinVal.pop();
        }
        this.stackContent.pop();
    }

    public int top() throws IndexOutOfBoundsException {
        if (this.stackContent.isEmpty())
            throw new IndexOutOfBoundsException();
        return this.stackContent.peek();
    }

    public int getMin() {
        if (this.stackMinVal.isEmpty())
            return -1;
        return this.stackMinVal.peek();
    }
}
