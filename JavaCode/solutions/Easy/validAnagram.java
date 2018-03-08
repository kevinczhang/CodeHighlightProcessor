public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return true;
        
        int[] sAlphCounts = new int[26];
        int[] tAlphCounts = new int[26];
        for(int i=0; i<s.length(); i++){
            sAlphCounts[s.charAt(i)-'a']++;
            tAlphCounts[t.charAt(i)-'a']++;
        }
        
        for(int i=0; i<26; i++){
            if(sAlphCounts[i] != tAlphCounts[i]) return false;
        }
        return true;
    }
}