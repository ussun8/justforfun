import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String num = in.next();
            int idx = firstBrokenIdx(num);
            if(idx == -1) {
                System.out.println("Case #" + i + ": " + num);
            } else {
                String convertedTidyNum = convertToTidy(num, idx);
                System.out.println("Case #" + i + ": " + convertedTidyNum);
            }
        }
    }

    private static String convertToTidy(String num, int idx) {
        char[] numArr = num.toCharArray();
        numArr[idx]--;
        for(int i=idx+1; i<numArr.length; i++) {
            numArr[i] = '9';
        }
        String str = new String(numArr);
        if(numArr[0] == '0') {
            return str.substring(1);
        }
        return str;
    }

    private static int firstBrokenIdx(String num) {
        char[] numArr = num.toCharArray();
        int brokenIdx = -1;
        for(int i=0; i<numArr.length-1; i++) {
            if(numArr[i] > numArr[i+1]) {
                brokenIdx = i;
                break;
            }
        }
        if(brokenIdx == -1) return -1;
        for(int j = brokenIdx; j>0; j--) {
            if(numArr[j-1] != numArr[j]) {
                return j;
            }
        }
        return 0;
    }
}
