package ch01;

public class OneAway {

    public static void main(String[] args) {

    }

    public boolean oneAway(String s1, String s2) {

        if (Math.abs(s1.length()-s2.length())>1) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0, j=0; i < s1.length() && j < s2.length(); ) {
            if (s1.charAt(i)!=s2.charAt(j)) {
                    
            }
        }
        return false;
    }
}
