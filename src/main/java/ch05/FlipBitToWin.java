package ch05;

public class FlipBitToWin {

    public static void main(String[] args) {
        int n=1775;
        
        int start=0;
        int move = 0;
        boolean hitFirstZero = false;
        int currentMax = 0;

        while(n>0) {
            if (n%2==1) {
                move++;
            } else {
                if (hitFirstZero) {
                    if (move>currentMax) {
                        currentMax=move;
                    }
                    move=0;
                    hitFirstZero=false;
                } else {
                    hitFirstZero=true;
                    move++;
                }

            }

            n=n>>1;
        }

        System.out.println(currentMax);
    }
}
