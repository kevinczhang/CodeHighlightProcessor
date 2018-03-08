public class Solution {
    public int countBattleships(char[][] board) {
        if(board.length == 0) return 0;
        int totalCount = 0;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                // Case 1: it is a .
                if(board[row][col] == '.') continue;
                // Case 2: it is invalid
                if(row - 1 >= 0 && board[row-1][col] == 'X' &&
                    col - 1 >= 0 && board[row][col-1] == 'X')
                    return -1;
                // Case 3: adjacent to X
                if(row - 1 >= 0 && board[row-1][col] == 'X' ||
                    col - 1 >= 0 && board[row][col-1] == 'X')
                    continue;
                // Case 4: a new ship
                totalCount++;
            }
        }
        return totalCount;
    }
}