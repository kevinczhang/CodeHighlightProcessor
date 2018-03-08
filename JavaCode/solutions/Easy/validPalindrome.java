public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        // Replace char that is not in the list
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(s.length() == 0) return true;
        // Compare char from both ends
        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}