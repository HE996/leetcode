package E回溯.N皇后;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.*;

class Solution {
    List<List<String>> res = new LinkedList<>();
    Stack<String> stack = null;
    StringBuilder tmp;
    int n = 0;
    public List<List<String>> solveNQueens(int n) {
        stack = new Stack<>();
        this.n=n;
        char[] arr = new char[n];
        Arrays.fill(arr,'.');
        tmp = new StringBuilder(String.valueOf(arr));
        backtrace(0, 0, 0, 0);
        return res;
    }

    public void backtrace(int h, int l, int r, int m) {
        if (m>=n) {res.add(new ArrayList<>(stack)); return;}
        for (int j = 0, i = 1; j < n; j++) {
            if((i&h)!=i&&(i&l)!=i&&(i&r)!=i){
                tmp.setCharAt(j,'Q');
                stack.add(tmp.toString());
                tmp.setCharAt(j,'.');
                backtrace(h|i, (l|i)<<1, (r|i)>>1, m+1);
                stack.pop();
            }
            i=i<<1;
        }
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.myAtoi("4193 with words"));
    }

    public int myAtoi(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        int i = 0;
        char tmp =arr[0];
        if (!Character.isDigit(tmp)&&tmp!='-') return 0;
        while(++i<s.length()){
            tmp =arr[i];
            if(!Character.isDigit(tmp))break;
        }
        int len = i;
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;
        int result=0;
        i=0;
        boolean negative = false;
        if (len > 0) {
            char firstChar = arr[0];
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    return 0;

                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(arr[i++],10);
                if (digit < 0) {
                    return 0;
                }
                if (result < multmin) {
                    return Integer.MIN_VALUE;
                }
                result *= 10;
                if (result < limit + digit) {
                    return Integer.MIN_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        return negative ? result : -result;
    }
}