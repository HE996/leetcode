package 位运算.两数相除;

import java.util.ArrayList;

class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==1)return dividend;

        if(dividend==-2147483648&&divisor==-1)return 2147483647;
        if(divisor==-1) return -dividend;
        boolean a = false;
        if(dividend<0){
            a = true;
            dividend = -dividend;
        }
        if(divisor<0){
            a = !a;
            divisor = -divisor;
        }

        int res = 0;
        int i = 0;
        int tmp = divisor;
        while(dividend>=divisor){
            if (tmp==dividend)return (a?-res-(1<<i):res+(1<<i));
            else if(tmp > dividend||tmp<0){
                dividend-=tmp>>1;
                res+=1<<(i-1);
                tmp = divisor;
                i = 0;
            }
            else{
                tmp<<=1;
                i+=1;
            }
        }

        return a?-res:res;
    }

    public static void main(String[] args) {
        System.out.println(1<<30);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(arr.toString());
        Solution solution = new Solution();
        System.out.println(solution.divide(2147483647,2));
    }
}