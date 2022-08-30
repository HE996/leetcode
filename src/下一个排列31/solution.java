package 下一个排列31;

import java.util.Arrays;

public class solution {
    public static void nextPermutation(int[] nums) {
        int tmp = 0, m = 0, i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) i--;
        if (i > 0) {
            tmp = nums[i - 1];
            int l = i, r = nums.length;
            while (l < r) {
                m = (l + r) >> 1;
                if (tmp >= nums[m]) r = m;
                if (tmp < nums[m]) l = m + 1;
            }
            nums[i - 1] = nums[l - 1];
            nums[l - 1] = tmp;
        }
        m = nums.length - 1;
        while (i < m) {
            tmp = nums[m];
            nums[m--] = nums[i];
            nums[i++] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        nextPermutation(new int[] {1,2,5,3,0});
    }
}