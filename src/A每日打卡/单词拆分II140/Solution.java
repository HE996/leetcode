package A每日打卡.单词拆分II140;

import java.util.*;

class Solution {
}
//class Solution {
//    private int min = Integer.MAX_VALUE;
//    private int max = 0;
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        int n = s.length();
//        List<String> res = new ArrayList<>();
//        if(n==0) return res;
//        Set<String> dict = new HashSet<>();
//        for(String str : wordDict){
//            dict.add(str);
//            min = Math.min(min,str.length());
//            max = Math.max(max,str.length());
//        }
//        boolean[] failed = new boolean[n];
//        dfs(res,new StringBuilder(), s, dict, 0,failed);
//        return res;
//    }
//    private boolean dfs(List<String> res,StringBuilder cur,String s,Set<String> dict,int idx,boolean[] failed){
//        int len = cur.length();
//        if(idx==s.length()){
//            cur.setLength(len-1);
//            res.add(cur.toString());
//            return true;
//        }
//        if(failed[idx]) return false;
//        boolean isBreak = false;
//        for(int i=idx+min-1;i<s.length();i++){
//            String word = s.substring(idx,i+1);
//            if(word.length()>max) break;
//            if(dict.contains(word)){
//                cur.append(word);
//                cur.append(' ');
//                if(dfs(res,cur,s,dict,i+1,failed)){
//                    isBreak = true;
//                }
//                cur.setLength(len);
//            }
//        }
//        failed[idx] = !isBreak;
//        return isBreak;
//    }
//}

