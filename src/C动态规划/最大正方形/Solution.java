package C动态规划.最大正方形;

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        int r = matrix.length;
        if (r<=1)return r;
        int c = matrix[0].length;
        if (c<=1)return c;
        int maxedg = 0;
        for (int[] ints : matrix) {
            if (ints[0] == 1) {
                maxedg = 1;
                break;
            }
        }
        for (int ints : matrix[0]) {
            if (ints == 1||maxedg==1) {
                maxedg = 1;
                break;
            }
        }
        int i = 0;
        int j = 0;
        while (++i < r) {
            while (++j < c) {
                if(matrix[i][j]>0&&matrix[i-maxedg][j-maxedg]>0&&matrix[i-1][j]==maxedg&&matrix[i][j-1]==maxedg){
                    maxedg++;
                    matrix[i][j] = maxedg;
                }
                j = maxedg-1;
            }
            i = maxedg-1;
        }
        return maxedg*maxedg;
    }
}