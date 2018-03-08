public class Solution {

    public Map<Integer, Integer> getCount(int[] arr) {
        Map<Integer, Integer> res = new HashMap<>();
        if (arr == null || arr.length == 0) {
            return res;
        }

        int start = 0;
        while (start < arr.length) {
            int end = findLast(start, arr);
            res.put(arr[start], end - start + 1);
            start = end + 1;
        }
        return res;
    }

    private int findLast(int start, int[] arr) {
        int c = arr[start];
        int diff = 1;
        while (start + diff < arr.length && arr[start + diff] == c) {
            diff <<= 1;
        }
        if (start + diff >= arr.length) {
            return arr.length - 1;
        }

        // Binary Search for end
        int end = start + diff;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (arr[mid] == c) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return arr[end] == c ? end : start;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
        Practice d = new Practice();
        Map<Integer, Integer> res = d.getCount(arr);
        for (Entry<Integer, Integer> entry : res.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
