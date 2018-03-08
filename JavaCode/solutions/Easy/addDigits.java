public class Solution {
    // Observe the pattern of num % 9
    public int addDigits(int num) {
        if(num == 0) return num;
        return num % 9 == 0 ? 9 : num % 9;
    }

    /***
     * Traditional solution
     *
     * res = 0
     * digitCount = digit count of num
     * mostSig = 10^(digitCount - 1)
     *
     * while(num > 9){
     *  digitCount = digit count of num
     *  mostSig = 10^(digitCount - 1)
     *  int temp = 0
     *  while(mostSig > 0){
     *      temp += num / mostSig
     *      num %= mostSig
     *      mostSig /= 10
     *  }
     *  num = temp
     * }
     *
     */
    public int addDigits(int num) {
        if(num == 0) return num;
        while(num > 9){
            int digitCount = String.valueOf(num).length();
            int mostSig = (int)Math.pow(10, digitCount-1);
            int temp = 0;
            while(mostSig > 0){
                temp += num / mostSig;
                num %= mostSig;
                mostSig /= 10;
            }
            num = temp;
        }
        return num;
    }
}

