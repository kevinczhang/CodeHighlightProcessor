public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // If top left or bottom right element is 1
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dpTable = new int[m][n];
        dpTable[0][0] = 1;
        // First row
        for(int i = 1; i < n; i++){
            dpTable[0][i] = (obstacleGrid[0][i] == 1 ||
                    dpTable[0][i - 1] == 0) ? 0 : 1;
        }
        // First col
        for(int i = 1; i < m; i++){
            dpTable[i][0] = (obstacleGrid[i][0] == 1 ||
                    dpTable[i - 1][0] == 0) ? 0 : 1;
        }
        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                // If has obstacle
                if(obstacleGrid[row][col] == 1){
                    dpTable[row][col] = 0;
                } else {
                    // update ways to current grid to be sum of
                    // ways to get top or left grid
                    dpTable[row][col] = dpTable[row-1][col] + dpTable[row][col-1];
                }
            }
        }
        return dpTable[m - 1][n - 1];
    }
}