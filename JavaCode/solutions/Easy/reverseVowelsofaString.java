public class Solution {
    public String reverseVowels(String s) {
        if(s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while(start < end){
            while(start < end && !isVowel(chars[start])) start++;
            while(start < end && !isVowel(chars[end])) end--;
            if(start == end) return new String(chars);
            char temp  = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
    
    boolean isVowel(char c){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char vowel : vowels){
            if(vowel == c) return true;
        }
        return false;
    }
}