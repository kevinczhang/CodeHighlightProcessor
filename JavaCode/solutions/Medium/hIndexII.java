public class Solution {
    public int hIndex(int[] citations) {
        int res = 0, len = citations.length;
		if(len == 0 || citations[len-1] == 0) return res;
		if(len == 1) return 1;
		
		int start = 0, end = len-1, mid = (end-start)/2 + start;				
		while(start <= end){
			if(citations[mid] == len - mid)	return citations[mid];
			
			if(citations[mid] < len - mid)
				start = mid+1;
			else
				end = mid-1;
			mid = (end-start)/2 + start;
		}				
		return len - end -1;
    }
}