package leecode;

/**
 * Print 10 digitals permutation
 */

public class Premuation {

    public static void main(String[] args){
        Premuation p = new Premuation();
        p.tailRec(10,"");
    }
    public void tailRec(int remain,String curr){
        if(remain == 0) {
            System.out.println(curr);
            return ;
        }
        for(int i = 0; i < 10; i++) {
            tailRec(remain - 1, i + curr);
        }
    }

}
