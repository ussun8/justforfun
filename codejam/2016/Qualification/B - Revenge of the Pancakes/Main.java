import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            String pattern = in.next();
            solve(caseNo, pattern);
        }
    }

    private static void solve(int caseNo, String pattern) {
        int count = 0;
        char[] patArr = pattern.toCharArray();
        for(int i=0; i<patArr.length-1; i++) {
            if(patArr[i] != patArr[i+1]) count++;
        }
        if(patArr[patArr.length-1] == '-') count++;
        System.out.println("Case #" + caseNo + ": " + count);
    }
}
