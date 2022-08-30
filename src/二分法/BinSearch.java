package 二分法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinSearch {
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {2, 2, 2, 2, 3, 5, 8, 9, 10};
        System.out.println(list[search(list, 11)]);
    }
}
