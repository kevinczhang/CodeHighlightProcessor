public class Solution {
    private int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x % y);
    }

    public String fractionAddition(String expression) {
        StringBuilder res = new StringBuilder();
        // Split the expression to get fracs
        if(expression.charAt(0) != '-' && expression.charAt(0) != '+')
            expression = '+' + expression;
        String[] fracs = expression.split("[+-]");
        // Get signs of each fracs
        int[] signs = new int[fracs.length];
        int signInd = 0;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-')
                signs[signInd++] = expression.charAt(i) == '+' ? 1 : -1;
        }
        // x is sum of nomerator and y is total denominator
        // starts with x/y = 0/1
        int x = 0, y = 1;
        for(int i = 1; i < fracs.length; i++){
            String f = fracs[i];
            String[] ft = f.split("/");
            // numerator
            int a = Integer.valueOf(ft[0])*signs[i-1];
            // denominator
            int b = Integer.valueOf(ft[1]);
            x = x*b + a*y;
            y *= b;
        }
        // If x <= 0
        if(x == 0){
            y = 1;
        } else if (x < 0){
            res.append('-');
            x *= -1;
        }
        // x and y > 0
        if (x > 0 && y > 0){
            int g = gcd(x, y);
            x /= g;
            y /= g;
        }
        res.append(String.valueOf(x) + '/' + String.valueOf(y));
        return res.toString();
    }
}