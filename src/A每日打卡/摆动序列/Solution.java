package A每日打卡.摆动序列;

import java.util.Arrays;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n&&nums[i]==nums[0])i++;
        if(i==n) return 1;
        boolean isasc = nums[i]>nums[0];
        int res = 2;
        int pre = nums[i++];
        for (;i<n;i++) {
            int cur = nums[i];
            if(cur==pre||isasc^cur<pre)continue;
            res++;
            isasc=!isasc;
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}