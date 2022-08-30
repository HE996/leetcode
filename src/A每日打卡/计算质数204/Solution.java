package A每日打卡.计算质数204;

public class Solution {
    public int countPrimes(int n) {
        if (n<4) return Math.max(0,n-2);
        boolean[] rec = new boolean[n];
        int cnt = 0;
        double s = (int)Math.sqrt(rec.length);
        for (int i = 2; i<rec.length; i++) {
            if(!rec[i]){
                cnt++;
                if(i < s+1){
                    long j = i*i;
                    while (j < rec.length) {
                        rec[(int)j] = true;
                        j+=i;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a);
    }
}
