public class Solution {
    public String intToRoman(int num) {
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC","C", "CD", "D", "CM","M"};
        int[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder res = new StringBuilder();

        int index = numbers.length - 1;
        while(num != 0 && index >= 0){
            if((num - numbers[index]) >= 0){
                num -= numbers[index];
                res.append(romans[index]);
            }else{
                index--;
            }
        }

        return res.toString();
    }
}