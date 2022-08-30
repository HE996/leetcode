package 二分法.旋转数组;

public class Solution {

    public int search(int[] nums, int target) {
       int l = 0, r = nums.length-1;
       while(l<=r){
           int m = (l+r)>>1;
           int nm = nums[m];
           if(nm==target) return m;
           if(nums[0]<=target){
               if(nm<target&&nm>=nums[0]) l=m+1;
               else r=m-1;
           }else{
               if(nm>target&&nm<nums[0]) r=m-1;
               else l=m+1;
           }
       }
       return -1;
    }

    public static void main(String[] args) {
        Solution aa = new Solution();
        System.out.println(aa.search(new int[]{1, 1, 1, 1, 1, 1}, 2));
    }
}
