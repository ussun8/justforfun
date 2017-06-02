import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static DecimalFormat df = new DecimalFormat("#.######", new DecimalFormatSymbols(Locale.US));
    static long INF = 1000000000000L;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int cityCount = in.nextInt();
            int caseCount = in.nextInt();
            int[] endurance = new int[cityCount];
            int[] speeds = new int[cityCount];
            int[][] cases = new int[caseCount][2];
            long[][] shortestDist = new long[cityCount][cityCount];
            for(int j=0; j<cityCount; j++) {
                endurance[j] = in.nextInt();
                speeds[j] = in.nextInt();
            }
            for(int m=0; m<cityCount; m++) {
                for(int n=0; n<cityCount; n++) {
                    int dist = in.nextInt();
                    shortestDist[m][n] = dist == -1 ? INF : dist;
                }
            }

            for(int j=0; j<caseCount; j++) {
                cases[j][0] = in.nextInt();
                cases[j][1] = in.nextInt();
            }

            solve(i, endurance, speeds, shortestDist, cityCount, cases);
        }
    }

    private static void solve(int caseNo, int[] endurance, int[] speeds, long[][] shortestDist,
                              int cityCount, int[][] cases) {
        for(int m=0; m<cityCount; m++) {
            for(int n=0; n<cityCount; n++) {
                for(int k=0; k<cityCount; k++) {
                    if(shortestDist[n][k] > shortestDist[n][m] + shortestDist[m][k]) {
                        shortestDist[n][k] = shortestDist[n][m] + shortestDist[m][k];
                    }
                }
            }
        }

        double[][] time = new double[cityCount][cityCount];

        for(int n=0; n<cityCount; n++) {
            for(int k=0; k<cityCount; k++) {
                if(endurance[n] >= shortestDist[n][k]) {
                    time[n][k] = (shortestDist[n][k] * 1.0) / speeds[n];
                } else {
                    time[n][k] = INF;
                }
            }
        }

        for(int m=0; m<cityCount; m++) {
            for(int n=0; n<cityCount; n++) {
                for(int k=0; k<cityCount; k++) {
                    if(time[n][k] > time[n][m] + time[m][k]) {
                        time[n][k] = time[n][m] + time[m][k];
                    }
                }
            }
        }

        System.out.print("Case #" + caseNo + ":");

        for(int j=0; j<cases.length; j++) {
            int source = cases[j][0]-1;
            int dest = cases[j][1]-1;
            double result = time[source][dest];
            System.out.print(" " + df.format(result));
        }

        System.out.println();
    }
}
