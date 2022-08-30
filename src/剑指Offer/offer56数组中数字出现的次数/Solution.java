package 剑指Offer.offer56数组中数字出现的次数;

import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        int one = 0,two = 0;
        for (int n : nums) {
            one = ~one&n&~two;
            two = one&n&~two;
        }
        return one^two;
    }
}
