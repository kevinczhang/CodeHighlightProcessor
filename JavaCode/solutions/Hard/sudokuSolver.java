public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        //all cells satisfy the constraints and valid, board is full
        if (row == 9) {
            return true;
        }

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;
        //already filled, fill rest of board and return truw if sol exists
        if (board[row][col] != '.'){
            return solve(board, nextRow, nextCol);
        }

        //if cur char is '.', try diff numbers and see if sol possible, if doesnt, backtrack
        for (int i = 1; i <= 9; i++) {
            board[row][col] = (char) ('0' + i);
            if (isValid(board, row, col) && solve(board, nextRow, nextCol)) {
                return true;
            }
        }
        //none of the above solutions fitted, so set to its initital value
        board[row][col] = '.';
        return false;
    }

    // Method to validate current board
    public boolean isValid(char[][] board, int row, int col) {
        char cur = board[row][col];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == cur && i != col || board[i][col] == cur && i != row)
                return false;
        }

        int bx = row / 3;
        int by = col / 3;
        for (int i = bx * 3; i < bx * 3 + 3; i++){
            for (int j = by * 3; j < by * 3 + 3; j++) {
                if (board[i][j] == cur && !(i == row && j == col))
                    return false;
            }
        }
        return true;
    }
}