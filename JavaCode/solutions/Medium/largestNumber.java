public class Solution {
    public String largestNumber(int[] nums) {
        String[] numNew = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            numNew[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numNew, NumberComparator);
        StringBuffer strBuf = new StringBuffer();
        // Use larger number first
        for (int i = nums.length-1; i >= 0; i--) {
            strBuf.append(numNew[i]);
        }
        // Check if it is 0
        return strBuf.charAt(0) == '0' ? "0" : strBuf.toString();
    }
    // Comparator to sort number in ascending order
    static final Comparator<String> NumberComparator = new Comparator<String>(){
        public int compare(String i1, String i2) {
            int i = 0;
            while (i < i1.length() && i < i2.length()) {
                if (i1.charAt(i) != i2.charAt(i))
                    return i1.charAt(i) - i2.charAt(i);
                i++;
            }
            if (i < i1.length())
                return compare(i1.substring(i), i2);
            if (i < i2.length())
                return compare(i1, i2.substring(i));
            return 0;
        }
    };
}