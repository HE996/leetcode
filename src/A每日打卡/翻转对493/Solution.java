package A每日打卡.翻转对493;

import java.util.*;
//1、归并排序，每次合并数组，都统计一遍翻转对，注意3
//归并的额外空间可以用tmp存储前面一个，tmp和后面一个比较，小的存入前面一个，知道tmp都存到原始数组。
class Solution {
    public int reversePairs(int[] nums) {
        int [] buffer = new int[(nums.length >>1) +1];
        return merge(0, nums.length-1,nums,buffer);
    }
    public int merge(int l, int r,int [] nums,int [] buffer){
        if (l>=r) return 0;
        int m = (l+r)>>1;
        int lcnt = merge(l,m,nums,buffer);
        int rcnt = merge(m+1,r,nums,buffer);
        //3、这里j不用每次都从头开始
        for(int i = l,j = m+1;i<m+1;i++){
            int n = (nums[i]>>1)+(1&nums[i]);
            for(;j<r+1&&n>nums[j];j++);
            lcnt+= j - m - 1;
        }
        System.arraycopy(nums, l, buffer, 0, m - l + 1);
        int i = l,j=m+1,k = 0;
        while(k<m-l+1&&j<r+1){
            if(nums[j]<=buffer[k]) nums[i++]=nums[j++];
            else nums[i++]=buffer[k++];
        }
        while(k<m-l+1) nums[i++]=buffer[k++];
        return lcnt+rcnt;
    }
}
