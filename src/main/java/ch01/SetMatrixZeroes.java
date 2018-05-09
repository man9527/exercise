package ch01;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] m = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        new SetMatrixZeroes().setZeroes(m);

        System.out.println("Done");
    }
    public void setZeroes(int[][] matrix) {

        boolean hasZeroOnRow0=false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i]==0) {
                hasZeroOnRow0=true;
                break;
            }
        }

        boolean hasZeroOnColumn0=false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0) {
                hasZeroOnColumn0=true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i]==0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0]==0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }

        if (hasZeroOnRow0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }

        if (hasZeroOnColumn0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }

    }
    
}
