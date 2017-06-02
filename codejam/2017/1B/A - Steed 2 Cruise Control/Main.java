import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        DecimalFormat df = new DecimalFormat("#.######");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            double length = in.nextDouble();
            int horseCount = in.nextInt();
            double res = Double.MIN_VALUE;
            for(int j=0; j<horseCount; j++) {
                double loc = in.nextDouble();
                int speed = in.nextInt();
                double time = (length - loc) / speed;
                res = Math.max(res, time);
            }
            double answer = length / res;
            System.out.println("Case #" + i + ": " + df.format(answer));
        }
    }
}
