package 回文素数;


import 二叉树.TreeNode;

class Solution {

    public int primePalindrome(int N) {
        while (N<=11){
            if (isPrime(N)) {
                return N;
            }
            N++;
        }
        while (true){
            char[] chars = String.valueOf(N).toCharArray();
            if (chars.length%2!=0) {
                int halfLen = chars.length / 2;
                for (int j = Integer.parseInt(String.valueOf(chars,0,halfLen+1));
                     j<Math.pow(10,halfLen+1); j++) {
                    StringBuilder stringBuilder = new StringBuilder();

                    stringBuilder.append(j);
                    for (int i = j/10; i > 0; i/=10) {
                        stringBuilder.append(i%10);
                    }
                    int res=Integer.parseInt(stringBuilder.toString());
                    if (isPrime(res)&&res>N) {
                        return res; // 判断是不是素数
                    }
                }
            }
            N= (int) Math.pow(10,chars.length);
        }
    }
    private boolean isPrime(int N) {
        if (N<2){
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
}

