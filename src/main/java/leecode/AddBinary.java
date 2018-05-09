package leecode;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {

        String big = a.length()>b.length()?a:b;
        String small = a.length()<=b.length()?a:b;

        for (int i = small.length(); i < big.length(); i++) {
            small = "0" + small;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = big.length()-1; 0<=i ; i--) {
            int cb = big.charAt(i)-'0';
            int cs = small.charAt(i) - '0';

            if (cb+cs+carry==3) {
                result.insert(0,"1");
                carry=1;
            } else if (cb+cs+carry==2) {
                result.insert(0,"0");
                carry=1;
            } else if (cb+cs+carry==1) {
                result.insert(0,"1");
                carry=0;
            } else if (cb+cs+carry==0) {
                result.insert(0,"0");
                carry=0;
            }
        }

        if (carry==1) {
            result.insert(0, "1");
        }

        return result.toString();
    }
    
}
