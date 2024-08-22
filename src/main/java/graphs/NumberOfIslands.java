package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumberOfIslands {
    /**
     * 200. Number of Islands
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * Output: 1
     * Example 2:
     *
     * Input: grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * Output: 3
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] is '0' or '1'.
     */

    public static int numIslands(char grid[][]) {
        int countOfIslands = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean visited [][] = new boolean[m][n];

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false){
                    bfs( grid, visited, i,j);
                    countOfIslands++;
                }
            }

        }

        return countOfIslands;

    }

    private static void bfs(char[][] grid, boolean[][] visited, int row, int column) {

        // Queue
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row,column});

        while (!queue.isEmpty()){
            var temp = queue.remove();
            var r = temp[0];
            var c = temp[1];
            if(visited[r][c] == true){
                continue;
            }
            // 1. add to visited
            visited[r][c] = true;

            // 2. add neighbours to the queue is they are 1
            int [] rowDelta = {-1,0,1,0 };
            int [] columnDelta = {0,1,0,-1};
            for (int i = 0; i < 4; i++) {
                int evaluatedRow = r+rowDelta[i];
                int evaluatedColumn = c+columnDelta[i];
                    if (evaluatedRow >= 0 && evaluatedRow < grid.length
                            && evaluatedColumn >=0 && evaluatedColumn < grid[0].length
                            && grid[evaluatedRow][evaluatedColumn]=='1'){
                        queue.add(new int []{evaluatedRow,evaluatedColumn});
                }
            }
        }
    }


    private static void dfs(char[][] grid, int r, int c) {
        // If not in bounds and current char is not 1 -> return
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }

        // Mark current char as seen by changing it to '#'
        grid[r][c] = '#';

        // Call dfs on its neighbors
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }


    public static void main(String[] args) {
        // create a grid
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }


}
