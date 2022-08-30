package 二分法.旋转数组;

public class FindMin {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int f = nums[l++];
        if(f<=nums[r]){
            return f;
        }
        while(l<r){
            int m = l+(r-l>>1);
            if(nums[m]>f){
                l = m+1;
            }else{
                r= m;
            }
        }
        return nums[r];
    }
}