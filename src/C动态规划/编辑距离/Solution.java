package C动态规划.编辑距离;
public class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int l1 = w1.length;
        int l2 = w2.length;


        /*
        要求对w2操作，使其等于w1，结果求得的次数是一样的，
        dp[i+1][j+1]表示使得w1.substring(0,i+1)与w2.substring(0,j+1)相等最少的操作次数。
        对于w1[i]和w2[j]：
         如果相等，dp[i+1][j+1]=dp[i][j]
         否则，dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i][j+1], dp[i+1][j])) + 1;
         1，dp[i][j+1]：w2[j]后插入w1[i]
         2，dp[i+1][j]；w2[j]变成w1[i]
         3，dp[i][j]：w2[j]变成w1[i]，

         （w1:*** ba
         w2:*** a
         w2中的a不是变成b而是在a前面插入一个b可以么？不可以，那样的话不是求dp[i+1][j+1]，而是
         dp[i+1][j]，操作不要影响剩下字符的位置和值）。
        */
        int[] dp = new int[l2 + 1];
        for (int i = 1; i < l2 + 1; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < l1; i++) {
            dp[0] = i + 1;
            int leftUp = i;
            for (int j = 0; j < l2; j++) {
                int up = dp[j + 1];
                if (w1[i] == w2[j]) {
                    dp[j + 1] = leftUp;
                } else {
                    dp[j + 1] = Math.min(leftUp, Math.min(up, dp[j])) + 1;
                }
                leftUp = up;
            }
        }
        return dp[l2];
    }
}