package 杨辉三角;



import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows==0)return res;
        res.add(Collections.singletonList(1));
        for (int i = 0;i<numRows;i++){
            List<Integer> pre = res.get(i);
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(pre.get(j)+pre.get(j-1));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.generate(5).toString());
    }
}
