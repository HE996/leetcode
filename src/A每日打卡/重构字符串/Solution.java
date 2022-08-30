package A每日打卡.重构字符串;

import java.util.*;

//无论奇偶，一半以下<(n>>1);包括一半<((n+1)>1)
public class Solution {

    public String reorganizeString(String S) {
        int [] dict = new int[26];
        int n = (S.length()+1>>1);
        char [] cs =  S.toCharArray();
        int maxcnt = 0,maxCntIdx = -1;
        for (char c : cs) {
            int i = c-'a';
            if(++dict[i]>n) return "";
            if (++dict[i] > maxcnt) {
                maxcnt = dict[i];
                maxCntIdx = i;
            }
        }
        int i = 0;
        while(dict[maxCntIdx]-->0) {
            cs[i] = (char)('a'+maxCntIdx);
            i+=2;
        }
        for (int j = 0; j < 26; j++) {
            while(dict[j]-->0){
                if(i>cs.length-1) i = 1;
                cs[i] = (char)('a'+j);
            }
        }
        return new String(cs);
    }
}
