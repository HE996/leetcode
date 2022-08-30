package A每日打卡.四数之和Ⅱ;

import java.security.KeyPair;
import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int item : A) {
            for (int i : A) {
                int key = item + i;
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }
        }
        int cnt = 0;
        for (int value : A) {
            for (int i : A) {
                int key = -(value + i);
                cnt += map1.getOrDefault(key, 0);
            }
        }
        return cnt;
    }
}
