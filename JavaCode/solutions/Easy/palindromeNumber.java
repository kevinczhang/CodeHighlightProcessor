public class Solution {
    public boolean isPalindrome(int x) {
        //negative numbers are not palindrome
        if (x < 0) return false;

        // find the most siginificant digit
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        // stop till x is 0
        while (x != 0) {
            int left = x / div; // left digit
            int right = x % 10; // right digit

            if (left != right)	return false;
            // remove first and last digit
            x = (x % div) / 10;
            // reduce dividor
            div /= 100;
        }
        return true;
    }
}