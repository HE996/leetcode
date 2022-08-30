package F栈和队列.每日温度;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(T[0]);
        for (int i=0;i<T.length;i++) {
            while(!stack.isEmpty()&&stack.getLast()<T[i]){
                stack.removeLast();
                int p = stack.pollLast();
                T[p]=i-p;
            }
            stack.offerLast(i);
            stack.offerLast(T[i]);
        }
        while(!stack.isEmpty()){
            stack.removeLast();
            T[stack.pollLast()]=0;
        }
        return T;
    }

/*    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] dp = new int[length];
        dp[length-1] = 0 ;
        for (int i=length-2 ; i>=0 ; i--){
            for (int j = i+1 ; j<length ; j+=dp[j]){
                if (T[i]<T[j]){
                    dp[i] = j-i;
                    break;
                } else if (dp[j]==0) {
                    dp[i] = 0;
                    break;
                }
            }
        }
        return dp;
    }*/
}
