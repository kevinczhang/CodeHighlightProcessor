public class Solution {
    public int nthUglyNumber(int n) {
        if(n == 0 || n == 1) return n;
        
        int h = 1;
        Deque<Integer> d2 = new ArrayDeque<Integer>();
        Deque<Integer> d3 = new ArrayDeque<Integer>();
        Deque<Integer> d5 = new ArrayDeque<Integer>();
        
        for(int i=0; i<n-1; i++){
            d2.offer(2 * h);
            d3.offer(3 * h);
            d5.offer(5 * h);
            h = Math.min(Math.min(d2.peek(), d3.peek()), d5.peek());
            if(h == d2.peek())
                d2.poll();
            if(h == d3.peek())
                d3.poll();
            if(h == d5.peek())
                d5.poll();
        }
        return h;
    }
}