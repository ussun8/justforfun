import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

//Working only for small input
public class Main {

    static DecimalFormat df = new DecimalFormat("#.######", new DecimalFormatSymbols(Locale.US));

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            String str = in.next();
            BigDecimal q = new BigDecimal(str);
            BigDecimal[] probs = new BigDecimal[n];
            for (int j = 0; j < n; ++j) {
                String str2 = in.next();
                BigDecimal prob = new BigDecimal(str2);
                probs[j] = prob;
            }
            solve(i, probs, q);
        }
    }

    private static void solve(int caseNo, BigDecimal[] probs, BigDecimal q) {
        BigDecimal sum = new BigDecimal("1");
        Arrays.sort(probs, Collections.reverseOrder());

        int tmp = 0;
        for (int j = probs.length-1; j > 0; --j) {
            BigDecimal diff = probs[j-1].subtract(probs[j]);
            if(q.compareTo(diff.multiply(BigDecimal.valueOf(probs.length - j))) > 0) {
                tmp = Math.min(j-1,0);
                for(int m = j; m<probs.length; m++) {
                    probs[m] = probs[m].add(diff);
                    q = q.subtract(diff);
                }
            } else {
                tmp = j;
                break;
            }
        }
        if(q.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal single = q.divide(BigDecimal.valueOf(probs.length - tmp), 50, BigDecimal.ROUND_HALF_UP);
            for(int n=tmp; n<probs.length; n++) {
                probs[n] = probs[n].add(single);
            }
        }

        for(int n=0; n<probs.length; n++) {
            sum = sum.multiply(probs[n]);
        }

        System.out.println("Case #" + caseNo + ": " + sum.toString());
    }
}
