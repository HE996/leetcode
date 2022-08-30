package A每日打卡.最大间距164;

import java.util.*;

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2)return 0;
        Arrays.sort(nums);
        int maxdis = 0;
        for (int i = 0; i < nums.length - 1; i++) maxdis = Math.max(nums[i+1]-nums[i],maxdis);
        return maxdis;
    }
}
