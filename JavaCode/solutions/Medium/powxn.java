public class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;
        if(n==2) return x*x;

        double temp = myPow(x, n / 2);
        if (n % 2 == 0)
            return temp*temp;
        else {
            if (n > 0)
                return x * temp*temp;
            else
                return 1 / x * temp*temp;
        }
    }
}