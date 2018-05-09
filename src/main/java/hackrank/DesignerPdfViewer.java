package hackrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 */
public class DesignerPdfViewer {

    static int designerPdfViewer(int[] h, String word) {
        // Complete this function

        int width = word.length();
        int height = 0;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (h[c-'a']>height) {
                height = h[c-'a'];
            }
        }

        return width*height;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i = 0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }

}
