package 字符串解码;

public class Solution {
    public String decodeString(String s) {
        return decode(s,s.length());
    }

    public String decode(String str,int s) {
        s = str.lastIndexOf("[",s);
        if(s!=-1){
            int e = str.indexOf("]",s);
            int n = 0;
            int p = s-1;
            int x = 1;
            while(p>-1){
                char c = str.charAt(p);
                if(c<48||c>57)break;
                n+=(c-48)*x;
                x*=10;
                p--;
            }
            StringBuilder ss = new StringBuilder(str.length()+(n-1) * (e - s - 1));
            ss.append(str, 0, p+1);
            System.out.println(str);
            while(n-->0)ss.append(str, s+1, e);
            ss.append(str,e+1,str.length());
            return decode(ss.toString(),p);
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("100[leetcode]"));
    }
}
