public class Solution {
    // We can always find a and b to satisfy ax + bx = d where d = gcd(x, y)
    // So, everything is clear, if z % d == 0, 
    // then we have (a*z/d)*x + (b*z/d)*y = z, which means m and n exist.
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (long)x + y >= z && z % gcd(x, y) == 0;
    }
    
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}