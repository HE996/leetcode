package C动态规划.两个字符串的删除操作;

public class Solution {

    public int minDistance(String word1, String word2) {
        // write your code here
        char [] w1 = word1.toCharArray();
        char [] w2 = word2.toCharArray();
        int l1 = w1.length;
        int l2 = w2.length;
        int [][]dp = new int[l1+1][l2+1];
        for(int i = 1;i<l2+1;i++){
            dp[0][i] = i;
        }

        for (int i = 0; i < l1; i++) {
            dp[i+1][0]=i+1;
            for (int j = 0; j < l2; j++) {
                if(w1[i] == w2[j]){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j])+1;
                }
            }
        }
        return dp[l1][l2];
    }
}