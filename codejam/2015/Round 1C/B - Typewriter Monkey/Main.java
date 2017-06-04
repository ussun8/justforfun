import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Works only small size inputs.
//Not optimal solution
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
            BigDecimal result = solve(caseNo, keyboardLength, targetLength, typingCount, keyboard, target);
            System.out.println("Case #" + caseNo + ": " + result.setScale(6, BigDecimal.ROUND_HALF_UP));
        }
    }

    private static BigDecimal solve(int caseNo, int keyboardLength, int targetLength,
                                    int typingCount, String keyboard, String target) {
        for(char ch : target.toCharArray()) {
            if(keyboard.indexOf(ch) == -1) return BigDecimal.valueOf(0);
        }

        List<Integer> countList = new ArrayList<>();
        dfs(new StringBuilder(), keyboard, target, typingCount, countList, 0);

        BigDecimal maxCount = getMax(countList);
        BigDecimal probSum = BigDecimal.ZERO;
        for(Integer count : countList) {
            probSum = probSum.add(BigDecimal.valueOf(count));
        }
        BigDecimal avg = probSum.divide(BigDecimal.valueOf(countList.size()), 6, BigDecimal.ROUND_HALF_UP);
        return maxCount.subtract(avg);
    }

    private static BigDecimal getMax(List<Integer> countList) {
        int max = Integer.MIN_VALUE;
        for(int val : countList) {
            max = Math.max(max, val);
        }
        return BigDecimal.valueOf(max);
    }

    private static void dfs(StringBuilder builder, String keyboard, String target, int typingCount, List<Integer> countList, int idx) {
        if(idx == typingCount) {
            countList.add(getOccuranceCount(builder.toString(), target));
            return;
        }
        for(int i=0; i<keyboard.length(); i++) {
            builder.append(keyboard.charAt(i));
            dfs(builder, keyboard, target, typingCount, countList, idx+1);
            builder.deleteCharAt(builder.length()-1);
        }
    }

    private static Integer getOccuranceCount(String source, String target) {
        int lastIndex = 0;
        int count = 0;
        while(lastIndex != -1) {
            lastIndex = source.indexOf(target, lastIndex);
            if(lastIndex != -1) {
                count++;
                lastIndex += 1;
            }
        }
        return count;
    }
}
