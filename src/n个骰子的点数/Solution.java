package n个骰子的点数;

public class Solution {
    public double[] dicesProbability(int n) {
        int cnt = 5*n+1;
        double[] res = new double[cnt];
        double mon = Math.pow(6,n);
        double son = n;
        for (int i = 0; i < cnt>>1; i++) {
            res[i] = res[cnt-1-i] = n/mon;
            son = son * (n-i)/(i+1);
        }
        return res;
    }
}
