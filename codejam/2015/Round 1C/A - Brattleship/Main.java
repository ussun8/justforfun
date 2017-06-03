import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int row = in.nextInt();
            int col = in.nextInt();
            int width = in.nextInt();
            solve(caseNo, row, col, width);
        }
    }

    private static void solve(int caseNo, int row, int col, int width) {
        int result = (col/width) * (row-1);
        if(width > (col/2)) result += Math.min(col, width+1);
        else result += col/width + (width-1) + ((col%width)==0 ? 0 : 1);
        System.out.println("Case #" + caseNo + ": " + result);
    }
}
