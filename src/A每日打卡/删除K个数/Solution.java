package A每日打卡.删除K个数;

public class Solution {
    public String removeKdigits(String num, int k) {
        //cnt表示需要保留的个数，r表示已经保留的个数
        int cnt = num.length()-k,r = 0;
        if (cnt<=0) return "0";
        char [] ans = new char[cnt];
        for (char c: num.toCharArray()) {
            while(k>0&&r>0&&ans[r-1]>c){
                r--;
                k--;
            }
            if (r<cnt)ans[r++] = c;//【原地修改】优于【尾部增删】优于【整行移动】
        }
        int l= 0;
        while(l<r&&ans[l]=='0'){
            cnt--;
            l++;
            if (cnt==0)return "0";//每次移出一个先导0，且cnt--
        }
        return new String(ans,l,cnt);
    }
}
