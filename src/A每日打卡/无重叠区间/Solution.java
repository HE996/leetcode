package A每日打卡.无重叠区间;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=0)return 0;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int end=intervals[0][0]-1,cnt=0;
        for (int[] inter : intervals) {
            if(inter[0]<end){
                cnt++;
                end = Math.min(inter[1],end);
            }else{
                end=inter[1];
            }
        }
        return cnt;
    }
}