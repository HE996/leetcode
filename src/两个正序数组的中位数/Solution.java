package 两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2,nums1);
        }
        if (len2==0) return 0.0;
        int l = 0, r = len1;
        int mid = (len1+len2)>>1;
        int p = 0,q = mid-p;
        while (l<=r){
            p = (r+l)>>1; //[0,len1]
            q = mid - p;  //[0,len2]
            if(q!=0&&p!=len1&&nums1[p]<nums2[q-1])l=p+1;
            else if(p!=0&&q!=len2&&nums1[p-1]>nums2[q])r=p-1;
            else break;
        }
        int rmin;
        if(p==len1) rmin=nums2[q];
        else if(q==len2) rmin = nums1[p];
        else rmin = Math.min(nums1[p],nums2[q]);
        if(((len1+len2)&1)==1) return rmin/1.0;

        int lmax;
        if (p==0)lmax = nums2[q-1];
        else if(q==0)lmax = nums1[p-1];
        else lmax= Math.max(nums1[p-1],nums2[q-1]);
        return (rmin+lmax)/2.0;
    }
}