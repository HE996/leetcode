package 股票买卖;

import java.util.Arrays;

public class Solution {
/*    public int maxProfit(int[] prices) {
        if (prices.length==0)return 0;
        int maxpro=0,min=prices[0];
        for (int price : prices) {
            if (price < min) min = price;
            int pro = price - min;
            if (maxpro < pro) maxpro = pro;
        }
        return maxpro;
    }*/
/*    public int maxProfit(int[] prices) {
        if (prices.length<2)return 0;
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i]-prices[i-1];
            if(tmp>0)res+=tmp;
        }
        return res;
    }*/

/*    public int maxProfit(int[] prices) {
        int dp_10 = 0,dp_11 = Integer.MIN_VALUE;
        int dp_20 = 0,dp_21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_20 = Math.max(dp_20, dp_21 + price);
            dp_21 = Math.max(dp_21, dp_10 - price);
            dp_10 = Math.max(dp_10, dp_11 + price);
            dp_11 = Math.max(dp_11, -price);
        }
        return dp_20;
    }*/
/*    public int maxProfit(int k, int[] prices) {
        k = Math.min(k,prices.length/2);
        if(k==0)return 0;
        int[] bts = new int[k];
        int[] slds = new int[k];
        for(int i=0;i<k;i++){
            bts[i]=-1001;
            slds[i]=0;
        }
        int tmp = 0;
        for (int price : prices) {
            tmp = 0;
            for (int j = k - 1; j > -1; j--) {
                slds[j] = Math.max(slds[j], bts[j] + price);
                bts[j] = Math.max(bts[j], tmp - price);
            }
        }
        int ans = 0;
        for(int n:slds){
            ans = Math.max(ans,n);
        }
        return ans;
    }*/


    public int maxProfit(int[] prices, int fee) {
        int k = prices.length/2;
        if(k==0)return 0;
        int[] bts = new int[k+1];
        int[] slds = new int[k+1];
        for(int i=0;i<k+1;i++){
            bts[i]=-1001;
            slds[i]=0;
        }
        for (int price : prices) {
            for (int j = k ; j > 0; j--) {
                slds[j] = Math.max(slds[j], bts[j] + price);
                bts[j] = Math.max(bts[j], slds[j-1] - price);
            }
        }
        int ans = 0,tmp = fee;
        for(int i=0;i<k+1;i++){
            ans = Math.max(ans,slds[i]-tmp);
            tmp+=fee;
        }

        return ans;
    }
/*    //含冻结期
    public int maxProfit(int[] prices) {
        if(prices.length<2)return 0;
        int a = -1001;
        int b = 0;
        int c = 0;//是否冷冻期
        for (int p:prices){
            int tmp  = b ;
            if(b<a+p){
                b = a + p;
                c = -b;
            }
            if(a<c-p){
                a = c - p;
            }
            c = tmp;
        }
        return b;
    }*/
}
