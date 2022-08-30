package F栈和队列.滑动窗口最大值;

class myDeque {
    int[] arr;
    int pri = 0, size = 0,maxsize;

    public myDeque(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
    }

    public boolean add(int num){
        if (size>=maxsize) return false;
        arr[(pri+size++)%maxsize]=num;
        return true;
    }

    public int peekFirst(){
        if (size<=0) return -1;
        return arr[pri%maxsize];
    }

    public int peekLast(){
        if (size<=0) return -1;
        return arr[(pri+size-1)%maxsize];
    }

    public int removeLast(){
        if (size==0) return -1;
        return arr[(pri+--size)%maxsize];
    }

    public int removeFirst(){
        if (size==0) return -1;
        size--;
        return arr[pri++%maxsize];//一直调用该方法，会导致pri 一直增大。
    }
}
public class Solution {
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new int[0];
        int [] res = new int[nums.length-k+1];
        myDeque queue = new myDeque(k);
        for (int i = 0; i < k; i++) {
            while(queue.size>0&&queue.peekLast()<nums[i])queue.removeLast();
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            res[i-k]=queue.peekFirst();
            if( nums[i-k]==queue.peekFirst())queue.removeFirst();
            while(queue.size>0&&queue.peekLast()<nums[i])queue.removeLast();
            queue.add(nums[i]);
        }
        res[nums.length-k]=queue.peekFirst();
        return res;
    }*/
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new int[0];
        int [] res = new int[nums.length-k+1];
        int max = -1;
        for (int i = 0; i < nums.length-k; i++) {
            if(max>=i){
                if (nums[i+k-1]>=nums[max]) max = i+k-1;
            }
            else{
                max=i;
                for (int x = i+1; x < i+k; x++) {
                    if (nums[x]>=nums[max]) max = x;
                }
            }
            res[i]=nums[max];
        }
        return res;
    }
}
