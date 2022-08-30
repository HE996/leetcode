package A每日打卡.Dota参议院;

import java.util.Arrays;

class Solution {
    public String predictPartyVictory(String senate) {
        char [] cs = senate.toCharArray();
        System.out.println(Arrays.toString(cs));
        int rlive = 0,rkill= 0,dlive = 0,dkill=0,cnt = cs.length,len= cs.length;
        int i= 0;
        while(cnt>0){
            if(cs[i]=='R'){
                if(rkill<0){
                    rkill++;
                    cnt--;
                }else {
                    cs[i-cs.length+cnt]=cs[i];
                    dkill--;
                    rlive++;
                }
            }else if(cs[i]=='D'){
                if(dkill<0){
                    dkill++;
                    cnt--;
                }else {
                    cs[i-cs.length+cnt]=cs[i];
                    rkill--;
                    dlive++;
                }
            }
            if(++i==len){
                if(dkill+dlive<0) return "Radiant";
                if(rkill+rlive<0) return "Dire";
                i=0;
            }
            len=cnt;
            System.out.println(Arrays.toString(cs));
            System.out.println(cnt);
        }
        return dkill>rkill?"Radiant":"Dire";
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.predictPartyVictory("DR"));
    }
}
//[D, R, R, D, R, D, R, D, R, D, D, R, D, R, D, R]
//[D, R, R, D, R, D, R, D, R, D, D, R, D, R, D, R]
//16
//[D, R, R, D, R, D, R, D, R, D, D, R, D, R, D, R]
//15
//[D, R, R, R, R, D, R, D, R, D, D, R, D, R, D, R]
//15
//[D, R, R, R, R, D, R, D, R, D, D, R, D, R, D, R]
//15
//[D, R, R, R, R, R, R, D, R, D, D, R, D, R, D, R]
//15
//[D, R, R, R, R, R, R, D, R, D, D, R, D, R, D, R]
//15
//[D, R, R, R, R, R, R, R, R, D, D, R, D, R, D, R]
//15
//[D, R, R, R, R, R, R, R, R, D, D, R, D, R, D, R]
//15
//[D, R, R, R, R, R, R, R, R, R, D, R, D, R, D, R]
//15
//[D, R, R, R, R, R, R, R, R, R, R, R, D, R, D, R]
//15
//[D, R, R, R, R, R, R, R, R, R, R, R, D, R, D, R]
//15
//[D, R, R, R, R, R, R, R, R, R, R, R, R, R, D, R]
//15
//[D, R, R, R, R, R, R, R, R, R, R, R, R, R, D, R]
//15
//[D, R, R, R, R, R, R, R, R, R, R, R, R, R, R, R]
//15
//Radiant