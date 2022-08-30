package A每日打卡.拼接最大数;

public class Solution {
    public String removeKdigits(String num, int k) {
        int cnt = num.length()-k,r = 0;
        if (cnt<=0) return "0";
        char [] ans = new char[cnt];
        for (char c: num.toCharArray()) {
            while(k>0&&r>0&&ans[r-1]<c){
                r--;
                k--;
            }
            if (r<cnt)ans[r++] = c;
        }
        int l= 0;
        while(l<r&&ans[l]=='0'){
            cnt--;
            l++;
            if (cnt==0)return "0";
        }
        return new String(ans,l,cnt);
    }
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int i = 0;
//
//    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.removeKdigits("649132", 3));
    }
}
