package leetcode3;

public class LargestTriangleArea {

    public static void main(String[] args) {
        // int[][] p = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        int[][] p = {{1,0},{0,0},{0,1}};
        // System.out.println(new LargestTriangleArea().largestTriangleArea(p));

        // System.out.println(new LargestTriangleArea().area(p1, p2, p3));
    }

    public double largestTriangleArea(int[][] points) {

        double maxArea = area(points[0], points[1], points[2]);

        for (int i = 3; i < points.length; i++) {

        }

        return maxArea;
    }

    private double area( int[] p1, int[] p2, int[] p3) {
        return Math.abs(p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1] - p1[1]*p2[0] - p2[1]*p3[0] - p3[1]*p1[0]) / 2.0;
    }
    
}
