public class Solution {
    public int rob(int[] num) {
        // Algorithm
        // case 1: current house is not robbed:
        //      Max. amount is Max(Max Amount When last house is robbed,
        //             Max Amount when last house is not robbed)
        // case 2: current house is robbed:
        //   Max. amount is Max Amount when last house is not robbed + current house's value
        // repeat this from first two until the last
        // Compare case 1 and case 2 to return the Max
        if(num.length == 0) return 0;
        if(num.length == 1) return num[0];
        if(num.length == 2) return Math.max(num[0], num[1]);

        // start from index = 2
        int lastNotRobbed = Math.max(num[0], num[1]);
        int lastRobbed = num[0] + num[2];
        int index = 3;

        while(index <= num.length-1){
            int tempLastNotRobbed = Math.max(lastNotRobbed, lastRobbed);
            lastRobbed = lastNotRobbed + num[index++];
            lastNotRobbed = tempLastNotRobbed;
        }

        return Math.max(lastRobbed, lastNotRobbed);
    }
}