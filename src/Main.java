import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] tmp = Arrays.stream(cin.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = tmp[0];
        int x = tmp[1];
        int[] arr = Arrays.stream(cin.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = arr[i]-p;
            map.put(k,map.getOrDefault(k,0)+1);
            p+=x;
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry:
                map.entrySet()){
            if(entry.getValue()<min){
                min = entry.getValue();
            }
        }
        System.out.println(n-min);
    }
}
