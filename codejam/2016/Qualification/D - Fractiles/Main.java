import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int tileSize = in.nextInt();
            int depth = in.nextInt();
            int chances = in.nextInt();
            solve(caseNo, tileSize, depth, chances);
        }
    }

    private static void solve(int caseNo, int tileSize, int depth, int chances) {
        if(depth*chances < tileSize) {
            System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
            return;
        }
        List<Long> positions = new ArrayList<>();
        for(long i=1; i<=tileSize; i+=depth) {
            long pos = i;
            for(int k=1; k<depth; k++) {
                pos = (tileSize * (pos-1)) + Math.min(tileSize, (i+k));
            }
            positions.add(pos);
        }

        System.out.print("Case #" + caseNo + ": ");
        for(long pos : positions) {
            System.out.print(pos + " ");
        }
        System.out.println();
    }
}
