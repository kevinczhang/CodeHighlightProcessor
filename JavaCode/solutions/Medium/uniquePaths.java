public class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 1 || n <= 1) return 1;
        int[][] dpTable = new int[m][n];

        // Only one way for first column or row
        for(int i = 0; i < n; i++){
            dpTable[0][i] = 1;
        }
        for(int i = 0; i < m; i++){
            dpTable[i][0] = 1;
        }
        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                // Ways to get current grid =
                // ways to get top of left grid
                dpTable[row][col] = dpTable[row-1][col] + dpTable[row][col-1];
            }
        }
        return dpTable[m-1][n-1];
    }
}