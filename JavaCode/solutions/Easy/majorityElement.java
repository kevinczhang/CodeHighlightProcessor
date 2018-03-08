public class Solution {
    public int majorityElement(int[] num) {
        int majorityElement = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == majorityElement)
                count++;
            else {
                count--;
                if (count == 0) {
                    majorityElement = num[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int i = 0; i < num.length; i++)
            if (num[i] == majorityElement) count++;
        return (count > num.length / 2) ? majorityElement : -1;
    }
}