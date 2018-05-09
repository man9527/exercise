package leecode;

public class MaxIncreaseKeepCitySkyline {
    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        
        System.out.println(new MaxIncreaseKeepCitySkyline().maxIncreaseKeepingSkyline(grid));
    }
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        if (grid.length<1) {
            return 0;
        }
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]>rowMax[i]) {
                    rowMax[i]=grid[i][j];
                }

                if (grid[i][j]>colMax[j]) {
                    colMax[j]=grid[i][j];
                }
            }
        }

        int totalcost = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int max = Math.min(rowMax[i], colMax[j]);
                totalcost += max - grid[i][j];
            }
        }


        return totalcost;

    }
    
}
