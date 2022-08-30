package A每日打卡.任务调度器;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) map[c-'A'] ++;
        Arrays.sort(map);
        int res = (map[25]-1)*n+map[25];
        for (int i = 24; i > -1; i--) res+=map[i]==map[25]?1:0;
        return Math.max(res,tasks.length);
    }
}
