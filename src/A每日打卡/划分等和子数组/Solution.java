package A每日打卡.划分等和子数组;

class Solution{
    public boolean canPartition(int[] nums) {
        if (nums.length==1)return false;
        int sum=0;
        for (int num : nums)sum += num;
        if ((sum & 1)== 1) return false;
        sum>>=1;
        boolean [] dp = new boolean [sum+1];
        dp[sum]=true;
        for (int num : nums) {
            if (num>sum) return false;
            if (dp[num])return true;
            int gap = num;
            while(gap<=sum) {
                if(dp[gap])dp[gap-num]=true;
                gap++;
            }
        }
        return dp[0];
    }
}
