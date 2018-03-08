public class NumArray {
    
    // http://www.cnblogs.com/grandyang/p/4985506.html
    int[] num;
    int[] bit;

    public NumArray(int[] nums) {
        num = new int[nums.length + 1];
        bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - num[i + 1];
        for (int j = i + 1; j < num.length; j += (j&-j)) {
            bit[j] += diff;
        }
        num[i + 1] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
    
    int getSum(int i) {
        int res = 0;
        for (int j = i; j > 0; j -= (j&-j)) {
            res += bit[j];
        }
        return res;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);