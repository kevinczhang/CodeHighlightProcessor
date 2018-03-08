class MedianFinder {
    // minHeap
    Queue<Integer> largePQ = new PriorityQueue<>();  
    // max Heap
    Queue<Integer> smallPQ = new PriorityQueue<>(10, revComp); 

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(smallPQ.size() <= largePQ.size()){
            if(largePQ.isEmpty() || num <= largePQ.peek())
                smallPQ.offer(num);
            else{
                smallPQ.offer(largePQ.poll());
                largePQ.offer(num);
            }
        } else {
            if(num < smallPQ.peek()){
                largePQ.offer(smallPQ.poll());
                smallPQ.offer(num);
            } else {
                largePQ.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(smallPQ.size() == largePQ.size())
            return (smallPQ.peek() + largePQ.peek())/2.0;
        return smallPQ.peek();
    }
    
    static final Comparator<Integer> revComp = new Comparator<Integer>(){
        @Override
        public int compare(Integer left, Integer right){
            return right - left;
        }
    };
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();