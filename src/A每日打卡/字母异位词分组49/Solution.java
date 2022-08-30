package A每日打卡.字母异位词分组49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String str : strs) {
            int hash = getHash(str);
            int pos = map.getOrDefault(hash,-1);
            if(pos>=0){
                res.get(pos).add(str);
            }else{
                List<String> temp = new ArrayList<String>();
                temp.add(str);
                res.add(temp);
                map.put(hash,res.size()-1);
            }
        }
        return res;
    }
    public int getHash(String str){
        int sum = 0;
        int mul = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sum+=c;
            mul*=c;
        }
        return sum+mul;
    }
}
