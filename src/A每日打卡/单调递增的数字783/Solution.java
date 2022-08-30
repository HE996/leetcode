package A每日打卡.单调递增的数字783;

import java.util.HashMap;

public class Solution {
    public int monotoneIncreasingDigits(int N) {
        int ones = 111111111;
        int result = 0;
        for (int i = 0; i < 9; i++) {
            while (result+ones>N) {
                ones /= 10;
            }
            result += ones;
        }
        return result;
    }
    public boolean wordPattern(String pattern, String s) {
        char [] pat = pattern.toCharArray();
        int exist = 0;
        HashMap<String, Character> map = new HashMap<>();
        String [] sarray = s.split(" ");
        for (int i = 0; i < sarray.length; i++) {
            char tmp = map.getOrDefault(sarray[i],'A');
            if (tmp=='A'){
                int pos = 1<<pat[i]-'a';
                if((exist&pos)==pos) return false;
                map.put(sarray[i],pat[i]);
            }
            else if(tmp!=pat[i]) return false;
        }
        return true;
    }

}
