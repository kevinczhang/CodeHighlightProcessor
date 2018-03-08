public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> wordMap = new HashSet<Integer>();
        while(n != 1 && !wordMap.contains(n)){
            wordMap.add(n);
            int temp = n;
            n = 0;
            while(temp >= 1){
                n += (temp%10)*(temp%10);
                temp /= 10;
            }
        }
        return n == 1;
    }
}