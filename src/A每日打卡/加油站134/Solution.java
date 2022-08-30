package A每日打卡.加油站134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int store= 0,sumg = 0,sumc = 0,start = gas[0]>=cost[0]?0:-1;
        for (int i = 0; i < gas.length; i++) {
            store += gas[i] - cost[i];
            if(store<0){
                store=0;
                start=i+1;
            }
            sumg+=gas[i];
            sumc+=cost[i];
        }
        if (start>=gas.length) return -1;
        return sumg>=sumc?start:-1;
    }
}
