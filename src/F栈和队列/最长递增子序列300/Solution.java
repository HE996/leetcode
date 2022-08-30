package F栈和队列.最长递增子序列300;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2)return nums.length;
        int [] stack = new int[nums.length];
        stack[0]=nums[0];
        int end = 0;
        for (int num : nums) {
            int i = end;
            while(i>-1&&num<stack[i])i++;
            stack[i+1]=num;
            System.out.println(Arrays.toString(stack));
        }
        return end+1;
    }
}
