import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int count = 0;
            int numOfIng = in.nextInt();
            int numOfPack = in.nextInt();

            double[] ratatouille = new double[numOfIng];
            int[] indexes = new int[numOfIng-1];

            for(int j = 0; j < numOfIng; ++j) {
                ratatouille[j] = in.nextDouble();
            }

            double[][] source = new double[numOfIng][numOfPack];

            for(int m = 0; m < numOfIng; ++m) {
                for(int k = 0; k < numOfPack; ++k) {
                    source[m][k] = in.nextDouble();
                }
            }

            for (int nn = 0; nn < source.length; nn++) {
                Arrays.sort(source[nn]);
            }

            double singleAmount = ratatouille[0];

            for(int kk = 0; kk < numOfPack; ++kk) {
                double totalAmount = source[0][kk];

                double upperDLimit = Math.floor((totalAmount / singleAmount) * 10 /9);
                double lowerDLimit = Math.ceil((totalAmount / singleAmount) *10 / 11);

                if(upperDLimit < lowerDLimit) continue;

                int lowerLimit = (int) lowerDLimit;
                int upperLimit = (int) upperDLimit;

                int found = 0;

                for (int n = 1; n < numOfIng; n++) {
                    int index = indexes[n - 1];
                    for (int start = index; start < numOfPack; ) {
                        double ingAmount = ratatouille[n];
                        double upperAm = ingAmount * upperLimit;
                        double lowerAm = ingAmount * lowerLimit;

                        upperAm = (upperAm * 11) / 10;
                        lowerAm = (lowerAm * 9) / 10;

                        if (source[n][start] < lowerAm) {
                            start++;
                        } else if (source[n][start] <= upperAm) {
                            found++;
                            indexes[n - 1] = start + 1;
                            break;
                        } else {
                            break;
                        }
                    }
                }
                if (found == numOfIng - 1) count++;
            }

            System.out.println("Case #" + i + ": " + count);
        }
    }

}
