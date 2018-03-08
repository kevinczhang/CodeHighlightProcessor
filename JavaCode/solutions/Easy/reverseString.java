public class Solution {
    public String reverseString(String s) {
        char[] stringChars = s.toCharArray();
        int start = 0;
        int end = stringChars.length - 1;
        while(start < end){
            char temp = stringChars[start];
            stringChars[start] = stringChars[end];
            stringChars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(stringChars);
    }
}