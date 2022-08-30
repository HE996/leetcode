package 剑指Offer.offer38字符串全排列;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    char []ss;
    public void dfs(int step){
        if(step==ss.length-1) {
            res.add(String.valueOf(ss));
            return;
        }
        int rec = 0;
        for (int i = step; i < ss.length; i++) {
            int mov= 1<<ss[i];
            if((rec&(mov))==mov)continue;
            rec|=(1<<ss[i]);
            swape(step,i);
            dfs(step+1);
            swape(step,i);
        }
    }
    public void swape(int step,int i){
        if (ss[step]==ss[i]) return;
        ss[step]^=ss[i];
        ss[i]^=ss[step];
        ss[step]^=ss[i];
    }
    public String[] permutation(String s) {
        ss =  s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }
}
