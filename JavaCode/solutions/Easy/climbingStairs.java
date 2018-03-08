public class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;

        steps[1] = 1;
        steps[2] = 2;
        int i = 3;

        while(i <= n){
            steps[i] = steps[i-1] + steps[i-2];
            i++;
        }

        return steps[n];
    }
}