public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        Map<Integer, List<Integer>> toMatch = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int toMatchInt = target - nums[i] - nums[j];
                List<Integer> tmpList = new LinkedList<Integer>();
                if (toMatch.containsKey(toMatchInt)) {
                    tmpList = toMatch.get(toMatchInt);
                }

                tmpList.add(i);
                tmpList.add(j);
                toMatch.put(toMatchInt, tmpList);
            }
        }

        int firstValue = Integer.MAX_VALUE;
        for (int firstIndex = 0; firstIndex < nums.length - 3; firstIndex++) {
            if (nums[firstIndex] == firstValue) {
                continue; // Skip first duplicate
            }
            firstValue = nums[firstIndex];
            int secondIndex = firstIndex + 1;
            while (secondIndex < nums.length - 2) {
                int secondValue = nums[secondIndex];
                int tempSum = nums[firstIndex] + nums[secondIndex];
                if (toMatch.containsKey(tempSum)) {
                    List<Integer> matchList = toMatch.get(tempSum);
                    int count = Integer.MAX_VALUE;
                    for (int i = 0; i < matchList.size() - 1; i += 2) {
                        // If 3rd element Ind not greater then 2nd ind
                        // or duplicate pair found
                        if (matchList.get(i) <= secondIndex ||
                                (i > count && nums[matchList.get(i - 2)] == nums[matchList.get(i)]
                                        && nums[matchList.get(i - 1)] == nums[matchList.get(i + 1)])) {
                            continue;
                        }
                        List<Integer> tmpList = new LinkedList<Integer>();
                        tmpList.add(nums[firstIndex]);
                        tmpList.add(nums[secondIndex]);
                        tmpList.add(nums[matchList.get(i)]);
                        tmpList.add(nums[matchList.get(i + 1)]);
                        result.add(tmpList);
                        count = i;
                    }
                }
                while (++secondIndex < nums.length - 2 && nums[secondIndex] == secondValue) ;
            }
        }
        return result;
    }
}