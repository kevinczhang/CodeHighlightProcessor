public class NumArray {
    int[] sums;
    int arrayLen;

    public NumArray(int[] nums) {
        this.arrayLen = nums.length;
        this.sums = new int[this.arrayLen];
        
        if(this.arrayLen > 0){
            this.sums[0] = nums[0];
            if(this.arrayLen > 1){
                for(int i = 1; i< nums.length; i++){
                    this.sums[i] = sums[i-1]+nums[i];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i < 0 || j > arrayLen-1) return 0;
        return this.sums[j]-(i <= 0 ? 0 : this.sums[i-1]);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);