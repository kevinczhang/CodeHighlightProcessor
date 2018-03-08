public class Solution {
    private void add(int[] bit, int i, int val) {
        for (; i < bit.length; i += i&(-i)) bit[i] += val;
    }

    private int query(int[] bit, int i) {
        int ans = 0;
        for (; i > 0; i -= i&(-i)) ans += bit[i];
        return ans;
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int[] indexes = new int[nums.length];
        for (int i = 0; i < indexes.length; i++)
            indexes[i] = Arrays.binarySearch(tmp, nums[i]);
        int[] bit = new int[indexes.length];
        int[] ans = new int[indexes.length];
        for (int i = indexes.length - 1; i >= 0; i--) {
            ans[i] = query(bit, indexes[i]);
            add(bit, indexes[i]+1, 1);
        }
        List<Integer> res = new ArrayList();
        for(int n : ans)
            res.add(n);
        return res;
    }
}