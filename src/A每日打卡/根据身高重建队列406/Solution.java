package A每日打卡.根据身高重建队列406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public void partition(int l,int r,int[][] people){
        if (l>=r) return;
        int i = l,j = r;
        int [] pivot = people[l];
        while(i<j){
            while(i<j&&(people[j][0]<=pivot[0]&&people[j][1]>=pivot[1]))j--;
            people[i] = people[j];
            while(i<j&&(people[j][0]>=pivot[0]||people[j][1]<=pivot[1]))i++;
            people[j] = people[i];
        }
        people[i] = pivot;
        partition(l,i-1,people);
        partition(i+1,r,people);
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int []  i:people) {
            list.add(i[1],i);
        }
        return list.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(Arrays.deepToString(a.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
}
