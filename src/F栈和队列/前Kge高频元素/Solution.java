package F栈和队列.前Kge高频元素;

import java.util.*;

public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, Comparator.comparingInt(map::get));
        for (Integer num : nums)map.put(num,map.getOrDefault(num,0)-1);
        queue.addAll(map.keySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=queue.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{4,1,2,2,-1,-1,3}, 2)));
    }
}
