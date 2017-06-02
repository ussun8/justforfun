import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int numOfGroups = in.nextInt();
            int packSize = in.nextInt();
            int[] groupArr = new int[numOfGroups];
            for(int i=0; i<numOfGroups; i++) {
                groupArr[i] = in.nextInt();
            }
            int result = solve(caseNo, groupArr, packSize);
            System.out.println("Case #" + caseNo + ": " + result);
        }
    }

    private static int solve(int caseNo, int[] groupArr, int packSize) {
        int rem0=0, rem1=0, rem2=0, rem3=0;
        int result = 0;
        if(packSize == 2) {
            for(int i=0; i<groupArr.length; i++) {
                if(groupArr[i] % 2 == 0) rem0++;
                else rem1++;
            }
            result += rem0;
            result += ((rem1+1)/2);
        } else if(packSize == 3) {
            for(int i=0; i<groupArr.length; i++) {
                if(groupArr[i] % 3 == 0) rem0++;
                else if(groupArr[i] % 3 == 1) rem1++;
                else rem2++;
            }
            result += rem0;
            int min = Math.min(rem1, rem2);
            result += min;
            result += ((rem1-min+2)/3);
            result += ((rem2-min+2)/3);
        } else {
            for(int i=0; i<groupArr.length; i++) {
                if(groupArr[i] % 4 == 0) rem0++;
                else if(groupArr[i] % 4 == 1) rem1++;
                else if(groupArr[i] % 4 == 2) rem2++;
                else rem3++;
            }
            result += rem0;
            int min = Math.min(rem1, rem3);
            result += min;
            result += rem2/2;
            rem2 %= 2;
            rem1 -= min;
            rem3 -= min;
            if(rem1 > 0) {
                result += rem1/4;
                rem1 %=4;
            }
            else if(rem3 > 0) {
                result += rem3/4;
                rem3 %= 4;
            }
            if(!(rem1 == 0 && rem2 ==0 && rem3 == 0)) {
                result++;
                if((rem1 == 3 && rem2 == 1) || (rem3 == 3 && rem2 == 1)) {
                    result++;
                }
            }
        }
        return result;
    }
}
