package leecode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   3,  5,  7},
        {10, 11, 16, 20},
            {23, 30, 34, 50}
            };

        System.out.println(new Search2DMatrix().searchMatrix(matrix, 4));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix==null || matrix.length==0) {
            return false;
        }
        int row = findRow(matrix, 0, matrix.length-1, target);

        if (row>=0) {
            return findColumn(matrix, row, 0, matrix[row].length, target);
        } else {
            return false;
        }

    }

    private boolean findColumn(int[][] matrix, int row, int begin, int end, int target) {

        if (begin>end) {
            return false;
        }

        int mid = (end+begin)/2;

        if (matrix[row][mid]==target) {
            return true;
        }

        if (target<matrix[row][mid]) {
            return findColumn(matrix, row, begin, mid-1, target);
        } else {
            return findColumn(matrix, row, mid+1, end, target);
        }
    }

    private int findRow(int[][] matrix, int begin, int end, int target) {

        if (begin>end) {
            return -1;
        }

        int mid = (end+begin)/2;

        if (matrix[mid].length==0) {
            return -1;
        }
        if (matrix[mid][0]<=target && target<=matrix[mid][matrix[mid].length-1]) {
            return mid;
        }

        if (matrix[mid][0]>target) {
            return findRow(matrix, begin, mid-1, target);
        } else {
            return findRow(matrix, mid+1, end, target);
        }
    }

}
