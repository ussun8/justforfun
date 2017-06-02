import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long numOfStalls = in.nextLong();
            long numOfPeople = in.nextLong();
            solve(i, numOfStalls, numOfPeople);
        }
    }

    private static void solve(int caseNo, long numOfStalls, long numOfPeople) {
        TreeSet<Long> stallSet = new TreeSet<>(Collections.<Long>reverseOrder());
        HashMap<Long, Long> countMap = new HashMap<>();
        stallSet.add(numOfStalls);
        countMap.put(numOfStalls, 1l);
        while(true) {
            final long max = stallSet.first();
            long first = max/2;
            long second = (max-1)/2;
            final long count = countMap.get(max);
            if(count >= numOfPeople) {
                System.out.println("Case #" + caseNo + ": " + first + " " + second);
                break;
            } else {
                stallSet.remove(max);
                stallSet.add(first);
                stallSet.add(second);
                countMap.putIfAbsent(first, 0l);
                long val = countMap.get(first);
                countMap.put(first, val+count);
                countMap.putIfAbsent(second, 0l);
                long val2 = countMap.get(second);
                countMap.put(second, val2 +count);
                numOfPeople -= count;
            }
        }
    }
}
