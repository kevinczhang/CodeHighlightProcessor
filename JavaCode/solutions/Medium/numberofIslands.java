public class Solution {
    class Point{
        int row;
        int col;
        public Point(int x, int y){
            this.row = x;
            this.col = y;
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;

        int res = 0;
        for(int row = 0; row < rowNum; row++){
            for(int col = 0; col < colNum; col++){
                if(grid[row][col] != '1')
                    continue;
                res++;
                Deque<Point> queue = new ArrayDeque<Point>();
                grid[row][col] = 'x';
                queue.offerFirst(new Point(row, col));
                while(!queue.isEmpty()){
                    Point top = queue.pollLast();
                    // go top, down, left, right
                    if(top.row - 1 >= 0 && grid[top.row - 1][top.col] == '1'){
                        grid[top.row - 1][top.col] = 'x';
                        queue.offerFirst(new Point(top.row - 1, top.col));
                    }
                    if(top.row + 1 < rowNum && grid[top.row + 1][top.col] == '1'){
                        grid[top.row + 1][top.col] = 'x';
                        queue.offerFirst(new Point(top.row + 1, top.col));
                    }
                    if(top.col - 1 >= 0 && grid[top.row][top.col - 1] == '1'){
                        grid[top.row][top.col - 1] = 'x';
                        queue.offerFirst(new Point(top.row, top.col - 1));
                    }
                    if(top.col + 1 < colNum && grid[top.row][top.col + 1] == '1'){
                        grid[top.row][top.col + 1] = 'x';
                        queue.offerFirst(new Point(top.row, top.col + 1));
                    }
                }
            }
        }
        return res;
    }
}