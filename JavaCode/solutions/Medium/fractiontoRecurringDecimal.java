public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        // Negative result
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0)
            res.append("-");
        // Integer part
        long num = numeratorL / denominatorL;
        res.append(num);
        numeratorL = (numeratorL % denominatorL) * 10;
        if (numeratorL > 0) res.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        // Decimal part
        while (numeratorL > 0) {
            num = numeratorL / denominatorL;
            if (map.containsKey(numeratorL)) {
                res.insert(map.get(numeratorL).intValue(), "(");
                res.append(")");
                break;
            }
            map.put(numeratorL, res.length());
            numeratorL = (numeratorL % denominatorL) * 10;
            res.append(num);
        }
        return res.toString();
    }
}