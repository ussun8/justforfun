import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int keyboardLength = in.nextInt();
            int targetLength = in.nextInt();
            int typingCount = in.nextInt();
            String keyboard = in.next();
            String target = in.next();
            solve(caseNo, keyboardLength, targetLength, typingCount, keyboard, target);
        }
    }

    private static void solve(int caseNo, int keyboardLength, int targetLength, int typingCount, String keyboard, String target) {
        int maxOverlap = preProcessKMP(target);
        int maxOccurrence = (1 + (typingCount-targetLength) / (targetLength - maxOverlap));
        double probOfOccurrence = calculateProb(keyboard, target, typingCount);
        double result = (probOfOccurrence == 0) ? 0 : maxOccurrence - probOfOccurrence;
        System.out.println("Case #" + caseNo + ": " + result);
    }

    private static double calculateProb(String keyboard, String target, int typingCount) {
        double prob = 1.0;
        for(char ch : target.toCharArray()){
            double count = keyboard.length() - keyboard.replace(Character.toString(ch), "").length();
            double intensity = count /keyboard.length();
            prob *= intensity;
        }
        prob *= (typingCount - target.length() + 1);
        return prob;
    }

    private static int preProcessKMP(String target) {
        int maxOverlap = 0;
        int length = target.length();
        for(int i=1; i<length; i++) {
            if(target.substring(0,i).equals(target.substring(length-i, length))) {
                maxOverlap = Math.max(maxOverlap, i);
            }
        }
        return maxOverlap;
    }
}
