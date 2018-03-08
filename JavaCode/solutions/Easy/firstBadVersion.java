/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1) return 1;
        int startIndex = 1, endIndex = n;
        while(startIndex < endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if(isBadVersion(midIndex)){
                endIndex = midIndex;
            }
            else{
                startIndex = midIndex+1;
            }
        }
        return endIndex;
    }
}