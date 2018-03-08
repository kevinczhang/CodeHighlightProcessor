public class Solution {
    // rowMid = (rowLeft + rowRight)/2, columnMid = (columnUp + columnDown)/2
    // 1, First use columnMid index to search line number.
    // 2, Second use rowMid to search for the element.
    public boolean searchMatrix(int[][] matrix, int target) {
        // Special cases
        if (matrix == null || matrix.length == 0  || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length - 1;
        int colNum = matrix[0].length - 1;
        if (target < matrix[0][0] || target > matrix[rowNum][colNum]) {
            return false;
        }

        //1. Binary search for column first
        int start = 0;
        int end = rowNum;
        int mid = (end - start) / 2 + start;
        while (start < end){
            if (target == matrix[mid][0]) { return true; }
            if (target < matrix[mid][0]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (end - start) / 2 + start;
        }
        int rowToSearch = target < matrix[start][0] ? start-1: start;
        //2. Binary search in the row
        start = 0;
        end = colNum;
        mid = (end - start) / 2 + start;
        while (start < end) {
            if (target == matrix[rowToSearch][mid]) { return true; }
            if (target < matrix[rowToSearch][mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (end - start) / 2 + start;
        }
        return target == matrix[rowToSearch][start];
    }
}