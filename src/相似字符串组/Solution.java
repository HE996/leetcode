package 相似字符串组;

class Solution {
    public int numSimilarGroups(String[] strs) {
        int cnt = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i+1; j < strs.length; j++) {
                if(isSimilar(strs, i , j))cnt++;
            }
        }
        return cnt;
    }
    public boolean isSimilar(String[] strs,int i ,int j){
        if(strs[i].equals(strs[j])) return true;
        int n = 2;
        int tmp=0;
        for (int k = 0; k < strs[i].length(); k++) {
            if(strs[i].charAt(k)!=strs[j].charAt(k)){
                tmp += strs[i].charAt(k)-strs[j].charAt(k);
                n--;
                if (n<0)return false;
            }
        }
        return tmp==0;
    }
}