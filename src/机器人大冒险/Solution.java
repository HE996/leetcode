package 机器人大冒险;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        char [] cs = command.toCharArray();
        int yy = 0,xx = 0;
        Set<Long> set = new HashSet<>();
        set.add(0L);
        for (char c : cs) {
            if(c=='U')yy++;
            else xx++;
            set.add(((long)yy<<30)|xx);
        }

        int tmp = Math.min(y/yy,x/xx);
        if(!set.contains(((long)(y-tmp*yy)<<30)|(y-tmp*xx)))return false;

        for (int[] obstacle : obstacles) {
            if(obstacle[0]>x||obstacle[1]>y)continue;
            int s = obstacle[0]/xx;
            int i = obstacle[0]-s*xx;
            int j = obstacle[1]-s*yy;
            if(i==0&&j<0){
                i+=xx;
                j+=yy;
            }
            if(set.contains(((long)j<<30)|i))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().robot("RRRUUU", new int[][]{{3,0}}, 3, 3));
    }
}
