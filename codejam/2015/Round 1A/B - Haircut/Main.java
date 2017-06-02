import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] barbersTime;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int barberCount = in.nextInt();
            int queueCount = in.nextInt();
            barbersTime = new int[barberCount];
            for(int i=0; i<barberCount; i++) {
                barbersTime[i] = in.nextInt();
            }
            solve(caseNo, barbersTime, queueCount);
        }
    }

    private static void solve(int caseNo, int[] barbersTime, int queueCount) {
        long low = -1;
        long high = 100000L * queueCount;
        while(low+1 < high) {
            long mid = low + (high-low) / 2;
            long servedCustomersCount = calculateCustomerCount(mid);
            if(servedCustomersCount < queueCount) low = mid;
            else high = mid;
        }
        long servedCustomersCountBefore = calculateCustomerCount(low);

        long diff = queueCount - servedCustomersCountBefore;
        for(int i=0; i<barbersTime.length; i++) {
            if(high % barbersTime[i] == 0) diff--;
            if(diff == 0) {
                System.out.println("Case #" + caseNo + ": " + (i+1));
                return;
            }
        }
    }

    private static long calculateCustomerCount(long mid) {
        if(mid < 0) return 0;
        long total = 0;
        for(int i=0; i<barbersTime.length; i++) {
            total += mid/barbersTime[i] + 1;
        }
        return total;
    }


}
