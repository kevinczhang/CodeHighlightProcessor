public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length==0) return new ArrayList<int[]>();
        return divide(buildings, 0, buildings.length-1);
    }

    public List<int[]> divide(int[][] buildings,int i,int j){
        if(i == j){
            List<int[]> tmp=new ArrayList<>();
            tmp.add(new int[]{buildings[i][0], buildings[i][2]});
            tmp.add(new int[]{buildings[i][1], 0});
            return tmp;
        }
        List<int[]> left = divide(buildings, i, i+(j-i)/2);
        List<int[]> right = divide(buildings, i+(j-i)/2+1, j);
        return merge(left,right);
    }

    public List<int[]> merge(List<int[]> left,List<int[]> right){
        List<int[]> ans = new ArrayList<>();
        int l1 = 0, l2 = 0, curh1 = 0, curh2 = 0, curlocation = 0, skyline = 0;
        while(l1 < left.size() && l2 < right.size()){
            int[] cur1 = left.get(l1);
            int[] cur2 = right.get(l2);

            // Compare x to see which line to be cur
            if(cur1[0] < cur2[0]){
                curh1 = cur1[1];
                curlocation = cur1[0];
                l1++;
            } else if(cur1[0] > cur2[0]){
                curh2 = cur2[1];
                curlocation = cur2[0];
                l2++;
            } else {
                curh1 = cur1[1];
                curh2 = cur2[1];
                curlocation = cur1[0];
                l1++;
                l2++;
            }

            // If max same as skyline no need to add new point
            // Keep track of pre skyline
            if(skyline != Math.max(curh1, curh2)){
                skyline = Math.max(curh1, curh2);
                ans.add(new int[]{curlocation, skyline});
            }
        }
        // Add those points left out
        for(int i = l1; i < left.size(); i++) ans.add(left.get(i));
        for(int i = l2; i < right.size(); i++) ans.add(right.get(i));
        return ans;
    }
}