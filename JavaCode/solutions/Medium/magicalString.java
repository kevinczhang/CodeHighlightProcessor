public class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        // Create an int array a and initialize the first 3 elements
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        // head is the index to generate new numbers
        int head = 2;
        // tail is the index to put the new number
        int tail = 3;
        int num = 1; // current number
        int result = 1;

        while (tail < n) {
            // Generate number with count of a[head]
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1 && tail < n)
                    result++;
                tail++;
            }
            // flip number back and forth between 1 and 2
            num = num ^ 3;
            head++;
        }

        return result;
    }
}