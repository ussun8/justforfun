import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PancakeFlipper {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int count = 0;
            String pancakes = in.next();
            char[] pancakeArr = pancakes.toCharArray();
            int window = in.nextInt();

            for(int j=0; j<=pancakeArr.length-window; j++) {
                if(pancakeArr[j] == '+') continue;
                count++;
                for(int k=0; k<window; k++) {
                    if(pancakeArr[j+k] == '+')
                        pancakeArr[j+k] = '-';
                    else
                        pancakeArr[j+k] = '+';
                }
            }
            boolean result = check(pancakeArr, pancakeArr.length-window+1);
            if(result)
                System.out.println("Case #" + i + ": " + count);
            else
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        }
    }

    private static boolean check(char[] pancakeArr, int start) {
        for(int k=start; k<pancakeArr.length; k++) {
            if(pancakeArr[k] == '-')
                return false;
        }
        return true;
    }
}
