public class Solution {
    public int numSquares(int n) {
        if(n <= 1) return 1;
        int[] dpArray = new int[n+1];
        dpArray[1] = 1;
        for(int i=2; i<n+1; i++){
            int sqareRoot = (int)Math.sqrt(i);
            if(sqareRoot*sqareRoot == i){
                dpArray[i] = 1;
                continue;
            }
                
            int minNumSquares = Integer.MAX_VALUE;
            int scanTo = (i % 2) == 0 ? i/2 : i/2 +1;
            for(int j=1; j<scanTo+1; j++){
                minNumSquares = (dpArray[i-j] + dpArray[j]) < minNumSquares ? 
                    (dpArray[i-j] + dpArray[j]) : minNumSquares;
            }
            dpArray[i] = minNumSquares;
        }
        return dpArray[n];
    }
}