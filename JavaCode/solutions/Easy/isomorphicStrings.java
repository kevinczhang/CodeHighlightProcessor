public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1)
            return true;
        Map<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a) && !map.get(a).equals(b) ||
                    !map.containsKey(a) && map.containsValue(b))
                return false;
            map.put(a,b);
        }
        return true;
    }
}