public class Solution {
    public int rowWithMax1s(int[][] mat){
        // Initialize first row as row with max 1s
        int max_row_index = 0;

        // The function first() returns index of first 1 in row 0.
        // Use this index to initialize the index of leftmost 1 seen so far
        int j = 0;
        while(j < mat[0].length && mat[0][j] == 0){
            j++;
        }

        j = j == mat[0].length ? j - 1 : j;
        for (int i = 1; i < mat.length; i++){
            // Move left until a 0 is found
            while (j >= 0 && mat[i][j] == 1){
                j--;  // Update the index of leftmost 1 seen so far
                max_row_index = i;  // Update max_row_index
            }
        }
        return max_row_index;
    }
}