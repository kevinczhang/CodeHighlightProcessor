public class Solution {
    public String getPermutation(int n, int k) {
        int t = 1; // n! to each i
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            t = t * i;
            numbers.add(i);
        }
        t /= n; // (n - 1)!
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 1; i--) {
            int p = k / t; // find which number to use
            int np = numbers.get(p); // get the number to use
            sb.append(String.valueOf(np));
            numbers.remove(p); // remove used number
            k %= t; // what left for k
            t /= i; //(n - i)!
        }
        // append the last number
        sb.append(String.valueOf(numbers.get(0)));
        return sb.toString();
    }
}