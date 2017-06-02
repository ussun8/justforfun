import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//It should be refactored
public class Main {

    private static final int DECIMAL = 10;
    private static String codersResult = null;
    private static String jammersResult = null;
    private static Long minDiff = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            codersResult = null;
            jammersResult = null;
            minDiff = Long.MAX_VALUE;
            String codersScore = in.next();
            String jammersScore = in.next();
            char[] codersArr = codersScore.toCharArray();
            char[] jammersArr = jammersScore.toCharArray();
            solve(codersArr, jammersArr, 0);
            System.out.println("Case #" + caseNo + ": " + codersResult + " " + jammersResult);
        }
    }

    private static void solve(char[] codersArr, char[] jammersArr, int idx) {
        if(idx == codersArr.length) {
            calculateDiff(new String(codersArr), new String(jammersArr));
            return;
        }

        final char codersCh = codersArr[idx];
        final char jammersCh = jammersArr[idx];
        int codersVal = Character.getNumericValue(codersCh);
        int jammersVal = Character.getNumericValue(jammersCh);

        if(codersCh != '?' && jammersCh != '?') {
            if(codersCh == jammersCh) {
                solve(codersArr, jammersArr, idx+1);
            } else if(codersVal > jammersVal) {
                calculateDiffByFavoringTeam(codersArr, jammersArr, '0', '9', idx+1);
                return;
            } else {
                calculateDiffByFavoringTeam(codersArr, jammersArr, '9', '0', idx+1);
                return;
            }
        }
        else if(codersCh != '?') {
            if(codersCh == '0') {
                jammersArr[idx] = codersArr[idx];
                solve(codersArr, jammersArr, idx+1);

                jammersArr[idx] = Character.forDigit(codersVal+1, Main.DECIMAL);
                calculateDiffByFavoringTeam(codersArr, jammersArr, '9', '0', idx+1);
            } else if(codersCh == '9') {
                jammersArr[idx] = Character.forDigit(codersVal-1, Main.DECIMAL);
                calculateDiffByFavoringTeam(codersArr, jammersArr, '0', '9', idx+1);

                jammersArr[idx] = codersArr[idx];
                solve(codersArr, jammersArr, idx+1);
            } else {
                jammersArr[idx] = Character.forDigit(codersVal-1, Main.DECIMAL);
                calculateDiffByFavoringTeam(codersArr, jammersArr, '0', '9', idx+1);

                jammersArr[idx] = codersArr[idx];
                solve(codersArr, jammersArr, idx+1);

                jammersArr[idx] = Character.forDigit(codersVal+1, Main.DECIMAL);
                calculateDiffByFavoringTeam(codersArr, jammersArr, '9', '0', idx+1);
            }
            jammersArr[idx] = '?';
        } else if(jammersCh != '?') {
            if(jammersCh == '0') {
                codersArr[idx] = jammersArr[idx];
                solve(codersArr, jammersArr, idx+1);

                codersArr[idx] = Character.forDigit(jammersVal+1, Main.DECIMAL);
                calculateDiffByFavoringTeam(codersArr, jammersArr, '0', '9', idx+1);
            } else if(jammersCh == '9') {
                codersArr[idx] = Character.forDigit(jammersVal-1, Main.DECIMAL);
                calculateDiffByFavoringTeam(codersArr, jammersArr, '9', '0', idx+1);

                codersArr[idx] = jammersArr[idx];
                solve(codersArr, jammersArr, idx+1);
            }
            else {
                codersArr[idx] = Character.forDigit(jammersVal-1, Main.DECIMAL);
                calculateDiffByFavoringTeam(codersArr, jammersArr, '9', '0', idx+1);

                codersArr[idx] = jammersArr[idx];
                solve(codersArr, jammersArr, idx+1);

                codersArr[idx] = Character.forDigit(jammersVal+1, Main.DECIMAL);
                calculateDiffByFavoringTeam(codersArr, jammersArr, '0', '9', idx+1);
            }
            codersArr[idx] = '?';
        } else {
            jammersArr[idx] = '0';
            codersArr[idx] = '0';
            solve(codersArr, jammersArr, idx+1);

            jammersArr[idx] = '1';
            codersArr[idx] = '0';
            calculateDiffByFavoringTeam(codersArr, jammersArr, '9', '0', idx+1);

            jammersArr[idx] = '0';
            codersArr[idx] = '1';
            calculateDiffByFavoringTeam(codersArr, jammersArr, '0', '9', idx+1);

            codersArr[idx] = '?';
            jammersArr[idx] = '?';
        }
    }

    private static void calculateDiffByFavoringTeam(char[] codersArr, char[] jammersArr, char codersCh,
                                                    char jammersCh, int idx) {
        StringBuilder codersStr = new StringBuilder(new String(Arrays.copyOfRange(codersArr, 0, idx)));
        StringBuilder jammersStr = new StringBuilder(new String(Arrays.copyOfRange(jammersArr, 0, idx)));
        for(int i=idx; i<codersArr.length; i++) {
            codersStr.append(codersArr[i] == '?' ? codersCh : codersArr[i]);
            jammersStr.append(jammersArr[i] == '?' ? jammersCh : jammersArr[i]);
        }
        calculateDiff(codersStr.toString(), jammersStr.toString());
    }

    private static void calculateDiff(String codersStr, String jammersStr) {
        long codersScore = Long.parseLong(codersStr);
        long jammersScore = Long.parseLong(jammersStr);
        long diff = Math.abs(codersScore - jammersScore);
        if(diff < minDiff) {
            minDiff = diff;
            codersResult = new String(codersStr);
            jammersResult = new String(jammersStr);
        }
    }
}
