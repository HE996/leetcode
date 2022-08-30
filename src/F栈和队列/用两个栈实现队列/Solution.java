package F栈和队列.用两个栈实现队列;

import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        if (s.equals("")) return 0;
        char [] cs = s.toCharArray();
        int res = 1;
        for (char c : cs) {
            res  = Math.max(res,c);
        }
        System.out.println(res);
        int [] map= new int[95];
        int [] dp= new int[cs.length];
        dp[0] = -1;
        map[cs[0]-' ']=1;
        for (int i=1;i<cs.length;i++){
            dp[i]=Math.max(map[cs[i]-' '],dp[i-1]);
            res = Math.max(res,i-dp[i]);
            map[cs[i]-' ']=i;
        }
        return res;
    }
    public static void main(String[] args) {

        System.out.println(new Solution().lengthOfLongestSubstring(""));
    }
}
class CQueue {

    Stack<Integer> A = new Stack<Integer>();
    Stack<Integer> B = new Stack<Integer>();

    public CQueue() {
    }

    public void appendTail(int value) {
        B.push(value);
    }

    public int deleteHead() {
        if(!A.isEmpty())return A.pop();
        if(B.isEmpty()) return -1;
        while(!B.isEmpty())A.push(B.pop());
        return deleteHead();
    }
}
