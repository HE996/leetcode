package A每日打卡.分割数组;



class Solution {
    public boolean isPossible(int[] nums) {
        if(nums.length<3) return false;
        int i=0,cnt=0;
        int one=0,two=0,three=0;
        while(i<nums.length){
            while(++i<nums.length&&nums[i]==nums[i-1]);
            if(cnt==0||nums[i-1]==nums[cnt-1]+1) {
                System.out.println(i-cnt);
                cnt = i-cnt-one+two;
                if (cnt<0) return false;
                cnt -= three;
                three = two+(cnt>0?three:three+cnt);
                two = one;
                one = Math.max(cnt,0);
            }else{
                if(one+two>0) return false;
                three = 0;
                two = 0;
                one = i-cnt;
            }
            cnt = i;
        }
        return one+two==0;
    }
}
