public class Solution {
    public int countPrimes(int n) {
        int res = 0;
        if (n <= 2)  return res; // A prime number must be >= 2.
        boolean[] flags = new boolean[n+1];

        int rootN = (int)Math.sqrt(n);
        for (int i=2; i<=rootN; ++i) {  // [1]
            // flags[i]==true means it has been marked before and
            // thus all its multiples can be skipped
            if (!flags[i]) {
                // Note: if we get here, i itself is a prime number

                // mark its multiples
                for (int j=i*i; j<=n; j+=i) {  // [2]
                    flags[j] = true;
                }
            }
        }

        for (int i=2; i<n; ++i) {
            if (!flags[i]) res++;
        }
        return res;
    }
}