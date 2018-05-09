package leetcode6;

public class MaskPII {

    public static void main(String[] args) {
        System.out.println(new MaskPII().maskPII("+(501321)-50-23431"));
    }

    public String maskPII(String S) {
        int at = S.indexOf("@");
        if (at>-1) {
            String name1 = S.substring(0, at);
            String name2 = S.substring(at);
            return (name1.charAt(0) + "*****" + name1.charAt(name1.length()-1) + name2).toLowerCase();
        } else {
            int digits = 0;
            int as = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = S.length()-1; i>=0; i--) {
                if (S.charAt(i)-'0'<0 || S.charAt(i)-'0'>9) {
                    continue;
                }

                digits++;

                if (digits<=4) {
                    sb.insert(0, S.charAt(i));
                } else {
                    if (as%3==0) {
                        sb.insert(0, "-");
                    }
                    as++;
                    sb.insert(0, "*");
                }
            }

            if (digits>10) {
                sb.insert(0, "+");
            }

            return sb.toString();


        }

    }

}
