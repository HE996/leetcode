package D滑动窗口.最大子序和;

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            if (num + sum <= 0) {
                sum = 0;
            } else {
                sum += num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }
}
