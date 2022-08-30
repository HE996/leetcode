package 接雨水;

class Solution {
    public int trap(int[] height) {
        int res = 0;
        int maxH = 0;
        for (int i : height) maxH = Math.max(maxH,i);

        int maxL = 0;
        for (int i : height){
            if(i<maxL)res+= maxL-i;
            else maxL = i;
        }
        return res;
    }
}
