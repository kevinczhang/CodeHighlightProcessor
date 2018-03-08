public class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if(rows == 0)
            return 0;
        int cols = grid[0].length;

        int sum = 0;
        int[][] path = new int[rows][cols];
        path[0][0] = grid[0][0];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0 && j > 0){
                    path[i][j] = path[i][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0){
                    path[i][j] = path[i - 1][j] + grid[i][j];
                } else {
                    path[i][j] = Math.min(path[i][j - 1], path[i - 1][j]) + grid[i][j];
                }
            }
        }
        return path[rows-1][cols-1];
    }
}