public class Solution {
    public int lengthLongestPath(String input) {
        if(input.indexOf(".") == -1) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            // number of "\t"
            int lev = s.lastIndexOf("\t")+1;
            // find parent
            while(lev+1<stack.size()) stack.pop();
            // remove "/t", add"/"
            int len = stack.peek()+s.length()-lev+1;
            stack.push(len);
            // check if it is file
            if(s.contains("."))
                maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;
    }
}