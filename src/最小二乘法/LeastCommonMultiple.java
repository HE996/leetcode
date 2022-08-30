package 最小二乘法;

import java.io.IOException;
import java.util.Scanner;

public class LeastCommonMultiple {
    public static int gcd(int a,int b){
        if (a==b)return b;
        if ((a&1)==1&&(b&1)==1)return a-b>b? gcd(a-b,b):gcd(b,a-b);
        if ((a&1)==0&&(b&1)==0)return 2*gcd(a>>1,b>>1);
        if ((a&1)==0)return a>>1>b?gcd(a>>1,b):gcd(b,a>>1);
        else return gcd(a,b>>1);
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.print(a*b/(a>b ? gcd(a,b):gcd(b,a)));
    }
}
