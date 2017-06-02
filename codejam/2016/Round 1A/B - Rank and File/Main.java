import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            HashMap<Integer, Integer> heightMap = new HashMap<>();
            int size = in.nextInt();
            for(int i = 0; i<size*2-1; i++) {
                for(int j=0; j<size; j++){
                    int height = in.nextInt();
                    heightMap.putIfAbsent(height, 0);
                    int count = heightMap.get(height);
                    heightMap.put(height, count + 1);
                }
            }
            solve(caseNo, heightMap);
        }
    }

    private static void solve(int caseNo, HashMap<Integer, Integer> heightMap) {
        List<Integer> resultList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : heightMap.entrySet()) {
            int val = entry.getValue();
            if(val % 2 != 0) resultList.add(entry.getKey());
        }
        Collections.sort(resultList);
        System.out.print("Case #" + caseNo + ": ");
        for(int height : resultList) {
            System.out.print(height + " ");
        }
        System.out.println();
    }
}
