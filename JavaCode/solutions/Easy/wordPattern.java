public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        Map<Character, String> pMaptos = new HashMap<>();
        Map<String, Character> sMaptop = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            if(pMaptos.containsKey(pattern.charAt(i))){
                if(!pMaptos.get(pattern.charAt(i)).equals(strs[i])) 
                    return false;
            } else {
                pMaptos.put(pattern.charAt(i), strs[i]);   
            }
            
            if(sMaptop.containsKey(strs[i])){
                if(!sMaptop.get(strs[i]).equals(pattern.charAt(i)))
                    return false;
            } else {
                sMaptop.put(strs[i], pattern.charAt(i));   
            }
        }
        return true;
    }
}