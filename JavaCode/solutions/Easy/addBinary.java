public class Solution {
    public String addBinary(String a, String b) {
        int aInd = a.length() - 1;
        int bInd = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(aInd >= 0 || bInd >= 0){
            int sum = carry;
            if(aInd >= 0 && a.charAt(aInd) == '1')
                sum += 1;
            if(bInd >= 0 && b.charAt(bInd) == '1')
                sum += 1;
            res.insert(0, sum % 2);
            carry = sum / 2;
            aInd--;
            bInd--;
        }
        if(carry > 0)
            res.insert(0, '1');
        return res.toString();
    }
}