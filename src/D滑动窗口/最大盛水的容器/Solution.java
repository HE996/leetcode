package D滑动窗口.最大盛水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length;
        int res = 0;
        while(l<r){
            if(height[l]<height[r]){
                res = Math.max(res,height[l]*(r-l-1));
                l++;
            }else{
                res = Math.max(res,height[r]*(r-l-1));
                r--;
            }
        }
        return res;
    }
}
