package 二进制中1的个数排序;

import java.util.*;

public class intersection {
    public int onecnt(int num){
        int cnt = 0;
        int flag = 1;
        while(flag<=num){
            if ((flag&num)==flag) cnt++ ;
            flag<<=1;
        }
        return cnt;
    }

    public void partition(int s,int e, int [] ones,int [] arr){
        int i = s, j = e;
        int pivot = arr[s];
        int cnt = ones[s];
        while(i<j){
            while(i<j) {
                if (pivot>arr[j]||pivot==arr[j]&&cnt>ones[j]) break;
                j--;
            }
            arr[i]=arr[j];
            ones[i]=ones[j];
            while(i<j) {
                if (pivot<arr[i]||pivot==arr[i]&&cnt<ones[i]) break;
                i++;
            }
            arr[j]=arr[i];
            ones[j]=ones[i];
        }
        arr[i] = pivot;
        ones[i] = cnt;
        partition (s,i-1,ones,arr);
        partition (i+1,e,ones,arr);
    }
    public int[] sortByBits(int[] arr) {
        int [] ones = new int [arr.length];
        System.out.println(Arrays.toString(ones));
        partition(0,arr.length-1,ones,arr);
        System.out.println(Arrays.toString(ones));
        return arr;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {2,3};
    }
}
