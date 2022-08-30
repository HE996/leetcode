package 最长山脉;

import java.util.TreeSet;

public class the_longest_peek {
    public int longestMountain(int[] A) {
        if (A.length<3) return 0;
        boolean dsc = false;
        int maxlen = 0,len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i]==A[i-1]) {
                len = 1;
                dsc = false;
            }
            else if (A[i]>A[i-1] && !dsc || A[i]<A[i-1] && dsc){
                len++;
            }
            else{
                if (dsc) len = 2;
                else len++;
                dsc = ! dsc;
            }
            maxlen = Math.max(len,maxlen);
        }
        return maxlen;
    }
}

