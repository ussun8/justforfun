import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int count = in.nextInt();
            int red = in.nextInt();
            int orange = in.nextInt();
            int yellow = in.nextInt();
            int green = in.nextInt();
            int blue = in.nextInt();
            int violet = in.nextInt();
            solve(i, count, red, orange, yellow, green, blue, violet);
        }
    }

    private static void solve(int caseNo, int count, int red, int orange, int yellow, int green, int blue, int violet) {
        char[] result;

        if(justOrangeBlue(red, orange, yellow, green, blue, violet)) {
            result = new char[count];
            if(blue == orange) {
                twoColorCase('B', 'O', result);
                printArray(caseNo, result);
            } else {
                System.out.println("Case #" + caseNo + ": " + IMPOSSIBLE);
            }
            return;
        } else if(justGreenRed(red, orange, yellow, green, blue, violet)) {
            result = new char[count];
            if(green == red) {
                twoColorCase('R', 'G', result);
                printArray(caseNo, result);
            } else {
                System.out.println("Case #" + caseNo + ": " + IMPOSSIBLE);
            }
            return;
        } else if(justVioletYellow(red, orange, yellow, green, blue, violet)) {
            result = new char[count];
            if(yellow == violet) {
                twoColorCase('Y', 'V', result);
                printArray(caseNo, result);
            } else {
                System.out.println("Case #" + caseNo + ": " + IMPOSSIBLE);
            }
            return;
        }
        if(!allNumbersOk(red, orange, yellow, green, blue, violet)) {
            System.out.println("Case #" + caseNo + ": " + IMPOSSIBLE);
            return;
        }


        int tmpRed = red - green;
        int tmpYellow = yellow - violet;
        int tmpBlue = blue - orange;
        if(!baseNumbersAreOk(tmpRed, tmpYellow, tmpBlue)) {
            System.out.println("Case #" + caseNo + ": " + IMPOSSIBLE);
            return;
        }

        String str;
        result = new char[tmpRed+tmpBlue+tmpYellow];
        if(tmpRed >= tmpYellow && tmpRed >= tmpBlue) {
            str = populateResult(tmpRed, 'R', tmpYellow, 'Y', tmpBlue, 'B', result);
        } else if(tmpYellow >= tmpRed && tmpYellow >= tmpBlue) {
            str = populateResult(tmpYellow, 'Y', tmpRed, 'R', tmpBlue, 'B', result);
        } else {
            str = populateResult(tmpBlue, 'B', tmpRed, 'R', tmpYellow, 'Y', result);
        }

        final String r1 = replace("R", "RG", green, str);
        final String r2 = replace("B", "BO", orange, r1);
        final String finalResult = replace("Y", "YV", violet, r2);

        System.out.println("Case #" + caseNo + ": " + finalResult);
    }

    private static String populateResult(int tmp1, char ch1, int tmp2, char ch2, int tmp3, char ch3, char[] result) {
        int total = tmp1 + tmp2 + tmp3;
        int idx = 0;

        while(tmp1 > 0) {
            result[idx] = ch1;
            idx+=2;
            if(idx >= total) idx = 1;
            tmp1--;
        }
        while(tmp2 > 0) {
            result[idx] = ch2;
            idx+=2;
            if(idx >= total) idx = 1;
            tmp2--;
        }
        while(tmp3 > 0) {
            result[idx] = ch3;
            idx+=2;
            if(idx >= total) idx = 1;
            tmp3--;
        }
        String str = new String(result);
        return str;
    }

    private static String replace(String searched, String replacedStr, int count, String str) {
        if(count == 0) return str;
        int firstIdx = str.indexOf(searched);
        StringBuilder builder2 = new StringBuilder();
        for(int i=0; i<count; i++) {
            builder2.append(replacedStr);
        }
        builder2.append(searched);
        return str.substring(0, firstIdx) + builder2.toString() + str.substring(firstIdx+1, str.length());
    }

    private static boolean baseNumbersAreOk(int red, int yellow, int blue) {
        int total = red + yellow + blue;
        int boundary = total / 2;
        if((red <= boundary) && (yellow <= boundary) && (blue <= boundary)) {
            return true;
        }
        return false;
    }

    private static boolean allNumbersOk(int red, int orange, int yellow, int green, int blue, int violet) {
        if((green == 0 || red > green) && (violet == 0 || yellow > violet) && (orange == 0 || blue > orange))  {
            return true;
        }
        return false;
    }

    private static void printArray(int caseNo, char[] result) {
        System.out.println("Case #" + caseNo + ": " + new String(result));
    }

    private static void twoColorCase(char first, char second, char[] result) {
        for(int i=0; i<result.length; i+=2) {
            result[i] = first;
            result[i+1] = second;
        }
    }

    private static boolean justVioletYellow(int red, int orange, int yellow, int green, int blue, int violet) {
        if(violet > 0 && yellow > 0 && red == 0 && orange == 0 && green == 0 && blue == 0) {
            return true;
        }
        return false;
    }

    private static boolean justGreenRed(int red, int orange, int yellow, int green, int blue, int violet) {
        if(green > 0 && red > 0 && orange == 0 && yellow == 0 && blue == 0 && violet == 0) {
            return true;
        }
        return false;
    }

    private static boolean justOrangeBlue(int red, int orange, int yellow, int green, int blue, int violet) {
        if(orange > 0 && blue > 0 && red == 0 && yellow == 0 && green == 0 && violet == 0) {
            return true;
        }
        return false;
    }
}
