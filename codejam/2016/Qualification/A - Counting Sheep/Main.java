import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            long val = in.nextLong();
            solve(caseNo, val);
        }
    }

    private static void solve(int caseNo, long val) {
        if(val == 0) {
            System.out.println("Case #" + caseNo + ": " + "INSOMNIA");
            return;
        }
        Set<Integer> numSet = new HashSet<>();
        long init = val;
        int start = 1;
        while(true) {
            while(val>0) {
                numSet.add((int)val%10);
                val /=10;
            }
            if(numSet.size() == 10) {
                System.out.println("Case #" + caseNo + ": " + init * start);
                return;
            }
            start++;
            val = init * start;
        }
    }
}
