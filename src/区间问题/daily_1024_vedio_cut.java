package 区间问题;

import java.util.Arrays;

public class daily_1024_vedio_cut {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips,(x,y)->{
            if (x[0]==y[0]) return x[1]-y[1];
            return x[0]-y[0];
        });
        System.out.println(Arrays.deepToString(clips));
        int pre = 0;
        int cur = 0;
        int cnt = 0;
        if (clips[cur][0]>pre) return -1;
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0]>pre){
                if (clips[cur][1]<clips[i][0]) return -1;
                cnt++;
            }
            if (clips[i][1]>clips[cur][1]) cur = i;
        }
        return cnt;
    }
}
