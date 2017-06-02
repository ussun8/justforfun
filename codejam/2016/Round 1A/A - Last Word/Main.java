import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            String str = in.next();
            solve(caseNo, str);
        }
    }

    private static void solve(int caseNo, String str) {
        StringBuilder builder = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(builder.length() == 0) builder.append(ch);
            else {
                int firstCh = builder.charAt(0);
                if(firstCh > ch) builder.append(ch);
                else builder.insert(0, ch);
            }
        }
        System.out.println("Case #" + caseNo + ": " + builder.toString());
    }
}
