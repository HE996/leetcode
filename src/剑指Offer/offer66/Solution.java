package 剑指Offer.offer66;
//注意0的个数
public class Solution {
    public int[] constructArr(int[] a) {
        int tmp = 1,pos = -1;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==0){
                if (pos>=0) return new int[a.length];
                pos = i;
            }else tmp*=a[i];
        }
        if (pos>=0){
            int [] ans = new int[a.length];
            ans[pos] = tmp;
            return ans;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = tmp/a[i];
        }
        return a;
    }
}
