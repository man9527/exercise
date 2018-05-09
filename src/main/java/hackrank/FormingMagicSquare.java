package hackrank;

import java.util.Scanner;

public class FormingMagicSquare {


    static int formingMagicSquare(int[][] s) {
        // Complete this function

        int[] rowsum = new int[3];
        int[] colsum = new int[3];
        int[] diasum = new int[2];

        int total = 0;

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                rowsum[i]+=s[i][j];
                colsum[j]+=s[i][j];
                if (i==j) {
                    diasum[0]+=s[i][j];
                } else if (i+j==2) {
                    diasum[1]+=s[i][j];
                }

                total+=s[i][j];
            }
        }

        int avg = total%8==0?total/8:total/8+1;

        for (int i = 0; i < rowsum.length; i++) {
            if (rowsum[i]!=avg) {
                    
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }

    
}
