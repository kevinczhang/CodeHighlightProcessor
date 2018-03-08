class MyStack {

	Deque<Integer> queue1 = null, queue2 = null;

	public MyStack(){
		this.queue1 = new ArrayDeque<Integer>();
		this.queue2 = new ArrayDeque<Integer>();
	}

	// Push element x onto stack.
    public void push(int x) {
    	this.queue1.offer(x);
        this.queue2.offer(x);
    }

    // Removes the element on top of the stack.
    public int pop() {
        int topElem = -1;
    	this.queue2.clear();
    	while(!this.queue1.isEmpty()){
    		topElem = this.queue1.poll();
    		if(!this.queue1.isEmpty())
    			this.queue2.offer(topElem);
        }
    	this.queue1 = new ArrayDeque<Integer>(this.queue2);
    	return topElem;
    }

    // Get the top element.
    public int top() {
    	while(!this.queue1.isEmpty()){
        	int res = this.queue1.poll();
        	if(this.queue1.isEmpty()){
            	this.queue1 = new ArrayDeque<Integer>(this.queue2);
            	return res;
        	}
        }
    	return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return this.queue2.isEmpty();
    }
}