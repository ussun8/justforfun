import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int mushroomCount = in.nextInt();
            int[] mushrooms = new int[mushroomCount];
            for(int i = 0; i < mushroomCount; ++i) {
                mushrooms[i] = in.nextInt();
            }
            solve(caseNo, mushrooms);
        }
    }

    private static void solve(int caseNo, int[] mushrooms) {
        int firstResult = solveWithFirstMethod(mushrooms);
        int secondResult = solveWithSecondMethod(mushrooms);
        System.out.print("Case #" + caseNo + ": " + firstResult + " " + secondResult);
        System.out.println();
    }

    private static int solveWithFirstMethod(int[] mushrooms) {
        int total = 0;
        for(int i = 0; i < mushrooms.length-1; ++i) {
            if(mushrooms[i] - mushrooms[i+1] > 0) total += mushrooms[i] - mushrooms[i+1];
        }
        return total;
    }

    private static int solveWithSecondMethod(int[] mushrooms) {
        int maxDiff = 0;
        for(int i = 0; i < mushrooms.length-1; ++i) {
            maxDiff = Math.max(maxDiff, mushrooms[i] - mushrooms[i+1]);
        }
        if (maxDiff == 0) return 0;
        int total = 0;
        for(int i = 0; i < mushrooms.length-1; ++i) {
            if(mushrooms[i] >= maxDiff) total += maxDiff;
            else total += mushrooms[i];
        }
        return total;
    }
}
