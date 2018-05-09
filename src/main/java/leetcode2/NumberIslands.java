package leetcode2;

public class NumberIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        System.out.println(new NumberIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length==0) {
            return 0;
        }
        int count = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j]=='1' && !visited[i][j] && numIslandsRec(grid, i, j, 0,visited)) {
                    count++;
                }
            }
        }

        return count;

    }


    public boolean numIslandsRec(char[][] grid, int x, int y, int direction, boolean[][] visited) {
        if (x>=grid.length || x<0 || y>=grid[x].length || y<0 || grid[x][y]=='0' || visited[x][y]) {
            return true;
        }

        visited[x][y] = true;

        return numIslandsRec(grid, x, y-1, 0, visited) &&
                numIslandsRec(grid, x+1, y, 1, visited)
                    && numIslandsRec(grid, x, y+1, 2, visited) &&
                numIslandsRec(grid, x-1, y, 3, visited);
    }
}
