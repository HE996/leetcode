import java.util.*;
import java.util.stream.Collectors;


public class san {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(--n>0){
            String[] record = sc.nextLine().split(" ");
            System.out.print(helper(record)+" ");
        }
        String[] record = sc.nextLine().split(" ");
        System.out.print(helper(record));
    }

    static String helper(String [] record){
        int absent = 1;
        boolean late = false;
        boolean leaveearly = false;
        int total = 3;
        for (int i = 0; i < record.length; i++) {
            boolean a = false;
            boolean b = false;
            if ("absent".equals(record[i])) {
                absent--;
                total--;
                if (absent < 0) return "false";
            } else if ("late".equals(record[i])) {
                if (late) return "false";
                a = true;
                total--;
            } else if ("leaveearly".equals(record[i])) {
                if (leaveearly) return "false";
                b = true;
                total--;
            } else if ("present".equals(record[i])) {
                continue;
            }
            if(i-7>-1){
                if(!"present".equals(record[i-7])) total++;
            }
            if(total<0)return "false";
            late = a;
            leaveearly = b;
        }
        return "true";
    }
}