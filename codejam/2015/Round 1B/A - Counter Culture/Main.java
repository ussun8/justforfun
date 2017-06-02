import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            long target = in.nextLong();
            int ans = solve(target);
            System.out.println("Case #" + caseNo + ": " + ans);
        }
    }

    private static int solve(long target) {
        if(target <= 10) {
            return (int)target;
        }
        int ans = 1;
        String str = String.valueOf(target);
        int length = str.length();

        for(int i=1; i<length; i++) {
            int leftLen = i/2;
            int rightLen = (i+1) / 2;
            ans += Math.pow(10, leftLen)-1;
            ans += Math.pow(10, rightLen)-1;
            if(i>1) ans++;
        }

        String left = str.substring(0, length/2);
        String reverseLeft = new StringBuilder(left).reverse().toString();
        String right = str.substring(length/2);
        int reverseLeftVal = Integer.parseInt(reverseLeft);
        int rightVal = Integer.parseInt(right);

        if(rightVal == 0) {
            return solve(target-1) + 1;
        }

        if(startWithOneFollowByZeros(reverseLeft)) {
            ans += rightVal;
            return ans;
        }

        ans += reverseLeftVal;
        ans++;
        ans += rightVal-1;
        return ans;
    }

    private static boolean startWithOneFollowByZeros(String reverseLeft) {
        int reverseLeftVal = Integer.parseInt(reverseLeft);
        return reverseLeftVal == 1;
    }
}
