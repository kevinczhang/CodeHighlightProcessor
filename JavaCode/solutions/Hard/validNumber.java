public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0) return false;

        boolean hasdot = false;
        boolean hase = false;
        boolean hasnum = false;
        int i = 0;

        // deal with "+" and "-"
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
            i++;
        else if(s.charAt(0) == 'e')
            return false;

        // start validation
        while(i < len){
            // deal with '.'
            if(s.charAt(i) == '.'){
                if(hasdot)
                    return false;
                hasdot = true;
            } else if (s.charAt(i) == 'e'){
                //different invalid casse: e34, 34ee, 34e+
                if(!hasnum || hase || i == len - 1 ||
                        (i == len - 2 && (s.charAt(i+1)=='+' || s.charAt(i+1)=='-'))){
                    return false;
                }
                if(s.charAt(i+1) == '-' || s.charAt(i+1) == '+')
                    i++;
                hase = true;
                hasdot = true; // after "e" we cannot have any "."
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                hasnum = true;
            } else {
                return false;
            }
            i++;
        }
        return hasnum;
    }
}