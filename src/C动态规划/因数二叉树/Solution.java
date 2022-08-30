package C动态规划.因数二叉树;

import java.util.Arrays;

public class Solution {
    /**
     * @param A:
     * @return: nothing
     */
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        int [] dp = new int [A[A.length-1]+1];
        int cnt = 0;
        for (int i : A) dp[i]=1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i+1; j++) {
                if(dp[A[i]*A[j]]>0){
                    dp[A[i]*A[j]] += dp[A[i]]*dp[A[j]];
                }
            }
            cnt+=dp[A[i]];
        }
        return cnt;
    }
}
