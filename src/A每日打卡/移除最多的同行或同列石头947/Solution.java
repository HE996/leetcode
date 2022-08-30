package A每日打卡.移除最多的同行或同列石头947;


class Solution {
    class DJS {
        DJS p;
        DJS() {
            this.p = this;
        }
        DJS find() {
            if (p.p != p) {
                p = p.find();
            }
            return p;
        }
        void union(DJS b) {
            this.find().p = b;//不按rank会简单一些 就一些
        }
    }

    public int removeStones(int[][] stones) {
        //又nm看错题
        //并查集
        DJS[] unions = new DJS[20000];
        int ret = 0;
        for (int[] t : stones) {
            int index1 = t[0], index2 = t[1] + 10000;
            DJS d1 = unions[index1], d2 = unions[index2];
            if (d1 == null && d2 == null) {
                DJS d = new DJS();
                unions[index1] = d;
                unions[index2] = d;
            } else if (d1 == null) {
                ++ret;
                d1 = new DJS();
                d1.union(d2);
                unions[index1] = d1;
            } else if (d2 == null) {
                ++ret;
                d2 = new DJS();
                d2.union(d1);
                unions[index2] = d2;
            } else {
                ++ret;
                if (d1.find() != d2.find()) {
                    ++ret;
                    d1.union(d2);
                }
            }
        }
        return ret;
    }
}
