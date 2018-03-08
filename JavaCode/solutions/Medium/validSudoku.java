public class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashMap<Character, ArrayList<Integer>> numHashset = new HashMap<Character, ArrayList<Integer>>();
        ArrayList<Integer> coords = new ArrayList<Integer>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.')
                    continue;
                coords = new ArrayList<Integer>();
                if (numHashset.containsKey(board[row][col])) {
                    coords = numHashset.get(board[row][col]);
                    if (!isValid(coords, row, col)) {
                        return false;
                    }
                }
                coords.add(row);
                coords.add(col);
                numHashset.put(board[row][col], coords);
            }
        }
        return true;
    }

    private boolean isValid(ArrayList<Integer> coords, int row, int col) {
        for (int i = 0; i < coords.size(); i += 2) {
            if (coords.get(i) == row || coords.get(i + 1) == col)
                return false;

            int dx = coords.get(i) / 3;
            int dy = coords.get(i + 1) / 3;
            for (int j = dx * 3; j < dx * 3 + 3; j++) {
                for (int k = dy * 3; k < dy * 3 + 3; k++)
                    if (j == row && k == col)
                        return false;
            }
        }

        return true;
    }
}