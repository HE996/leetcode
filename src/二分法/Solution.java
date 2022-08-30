package 二分法;


public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r = nums.length-1,m = 0;
        while(l<=r){
            m = (l+r)>>1;
            if(nums[m]==target) {
                int [] res = new int []{l,m};
                //左边
                r = m;
                while(l<r){
                    m = (l+r)>>1;
                    if(nums[m]>=target) r = m;
                    else if(nums[m]<target) l = m+1;
                }
                res[0] = l;
                //右边
                l = res[1];
                r = nums.length;
                while(l<r){
                    m = (l+r)>>1;
                    if(nums[m]>target) r = m;
                    else if(nums[m]<=target) l = m+1;
                }
                res[1] = r-1;
                return res;
            }
            else if(nums[m]>target) r = m-1;
            else if(nums[m]<target) l = m+1;
        }
        return new int []{-1,-1};
    }

    public static void main(String[] args) {
        /*Solution a = new Solution();
        System.out.println(Arrays.toString(a.searchRange(new int[]{1}, 1)));*/
        long tmp = 0;
        for (int i = 0; i < 10000; i++) {
            tmp =tmp<<3+tmp<<1+i;
        }

    }
}

