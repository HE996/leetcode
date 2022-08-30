package A每日打卡.自由之路;
import java.util.ArrayList;
//用一个和ring相同长度的数组记录，每次匹配key上的字母时，每个可能的位置所使用的最少操作次数。
class Solution {
    public int findRotateSteps(String ring, String key) {
        final int n = ring.length();
        final int[] memo = new int[n];
        final char[] cs = ring.toCharArray();
        ArrayList<Integer>[] positions = new ArrayList[26];
        for(int i=0;i<26;i++)positions[i]=new ArrayList<>();
        for (int i = 0; i < n; i++) { positions[cs[i]-'a'].add(i); }
        for (int idx : positions[key.charAt(0)-'a']) { memo[idx] = 1+distance(0, idx, n); }
        for (int idx = 1; idx != key.length(); idx++) {
            int il = key.charAt(idx-1)-'a', ic = key.charAt(idx)-'a';
            ArrayList<Integer> cur = positions[ic];
            if (il == ic) {
                for (int i : cur) { memo[i]++; }
                continue; // special ops. should be right
            }
            ArrayList<Integer> last = positions[il];
            for (int i : cur) {
                int midDistance = Integer.MAX_VALUE; // note. cannot n
                for (int j : last) {
                    midDistance = Math.min(midDistance, memo[j] + distance(i, j, n));
                }
                memo[i] = midDistance+1;
            }
        }
        int res = Integer.MAX_VALUE; // note cannot n
        for (int idx : positions[key.charAt(key.length()-1)-'a']) { res = Math.min(res, memo[idx]); }
        return res;
    }

    private int distance(int src, int dest, final int n) {
        if (src < dest) { return Math.min(dest-src, n-dest+src); }
        else { return Math.min(src-dest, n-src+dest); }
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));

    }
}

