public class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0)
            return 0;

        List<Character> romans = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');
        int[] numbers = {1, 5, 10, 50, 100, 500, 1000};

        if (s.length() == 1)
            return numbers[romans.indexOf(s.charAt(0))];

        int index = 0, result = 0;
        while (index < s.length() - 1) {
            // If cur char smaller than next
            if (romans.indexOf(s.charAt(index)) >= romans.indexOf(s.charAt(index + 1))) {
                result += numbers[romans.indexOf(s.charAt(index))];
                index++;
            } else {
                result += numbers[romans.indexOf(s.charAt(index + 1))]
                        - numbers[romans.indexOf(s.charAt(index))];
                index += 2;
            }
        }
        // Deal with the last char. Need to check since we have index += 2
        if (index == s.length() - 1)
            result += numbers[romans.indexOf(s.charAt(index))];

        return result;
    }
}