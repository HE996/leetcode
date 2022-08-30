package A每日打卡.分割斐波那契数列;

import java.util.*;

class Solution {

    int tol=0;
    //l表示从s串第几个字母开始；
    // res存储结果；
    // 用整数n表示res中结果的个数就没必要改变res的长度；
    // s表示字符串的字符数组。
    public boolean backtrack(int l,int[] res,int n,char[] s){
        if (l==res.length) {
            tol = n;//回溯法返回的boolean值，只好用全局变量存储res中的结果个数。
            return n>2;
        }
        long num = 0;  //num存储res下标为n的数字。也能用int，不过越界后是负数，要修改后面的代码。
        for (int i = l; i < res.length; i++) {//循环判断s串中，l位置开始所有满足规则的情况。
            num = num*10+(s[i]-'0');
            if(num==0&&i>l) break;
            if (num>=Integer.MAX_VALUE) return false;
            if(n>1){//如果num不是前两个数，找到一个num等于前两数之和
                if(res[n-2]+res[n-1]>num) continue;
                if(res[n-2]+res[n-1]<num) return false;
            }
            res[n]=(int)num;//走到这里num要么是前两个数，要么等于前两数之和。
            if(backtrack(i+1,res,n+1,s)) return true;//回溯判断s中剩下的数字。
            //证明num不满足，增加num的长度，num为0，或者num不为前两个数num不能随意增加num的长度
            if(n>1||num==0)return false;
        }
        return false;
    }
    public List<Integer> splitIntoFibonacci(String S) {
        int[] res = new int[S.length()];
        char[] s = S.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        if (backtrack(0,res,0,s))for (int i=0;i<tol;i++) list.add(res[i]);
        return list;
    }

    public static void main(String[] args) {

//        Solution a = new Solution();
//        System.out.println(a.splitIntoFibonacci("0123"));
        System.out.println(Integer.parseInt("-122"));
    }
}
