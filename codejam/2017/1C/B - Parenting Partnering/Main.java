import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int HALF_DAY_IN_MINUTES = 720;
    public static final int FULL_DAY_IN_MINUTES = 1440;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            List<Interval> intervalList = new ArrayList<>();
            int maleBaby = 0;
            int femaleBaby = 0;
            int actCount1 = in.nextInt();
            int actCount2 = in.nextInt();
            for (int j = 0; j < actCount1+actCount2; ++j) {
                Gender gender = j < actCount1 ? Gender.MALE : Gender.FEMALE;
                int start = in.nextInt();
                int end = in.nextInt();
                int diff = end- start;
                if(diff < 0) diff += FULL_DAY_IN_MINUTES;
                if(j <actCount1) maleBaby += diff;
                else femaleBaby += diff;
                Interval interval = new Interval(start, end, gender);
                intervalList.add(interval);
            }
            Collections.sort(intervalList, (o1,o2) -> o1.start - o2.start);
            Interval first = intervalList.get(0);
            intervalList.add(first);
            solve(i, intervalList, maleBaby, femaleBaby);
        }
    }

    private static void solve(int caseNo, List<Interval> intervalList, int maleBaby, int femaleBaby) {
        int maleRemaining = HALF_DAY_IN_MINUTES - maleBaby;
        int femaleRemaining = HALF_DAY_IN_MINUTES - femaleBaby;
        int numOfExc = calculateExchanges(intervalList);
        List<Interval> maleBounded = createBoundedInterval(intervalList, Gender.MALE);
        List<Interval> femaleBounded = createBoundedInterval(intervalList, Gender.FEMALE);
        Collections.sort(maleBounded, (o1, o2) -> ((o1.end-o1.start) - (o2.end- o2.start)));
        Collections.sort(femaleBounded, (o1, o2) -> ((o1.end-o1.start) - (o2.end - o2.start)));

        numOfExc += getCount(maleBounded, maleRemaining);
        numOfExc += getCount(femaleBounded, femaleRemaining);

        System.out.println("Case #" + caseNo + ": " + numOfExc);
    }

    private static int getCount(List<Interval> bounded, int remaining) {
        for(int i=0; i<bounded.size(); i++) {
            Interval in = bounded.get(i);
            int diff = in.end - in.start;
            if(diff <= remaining) remaining -= diff;
            else return 2 * (bounded.size()-i);
        }
        return 0;
    }

    private static List<Interval> createBoundedInterval(List<Interval> intervalList, Gender gender) {
        List<Interval> bounded = new ArrayList<>();
        for(int i=0; i<intervalList.size()-1; i++) {
            final Interval before = intervalList.get(i);
            final Interval after = intervalList.get(i+1);
            if(gender.equals(before.gender) && before.gender.equals(after.gender) && before.end != after.start) {
                if(after.start < before.end) after.start += FULL_DAY_IN_MINUTES;
                bounded.add(new Interval(before.end, after.start, gender));
            }
        }
        return bounded;
    }

    private static int calculateExchanges(List<Interval> intervalList) {
        int count = 0;
        for(int i=0; i<intervalList.size()-1; i++) {
            if(intervalList.get(i).gender != intervalList.get(i+1).gender) count++;
        }
        return count;
    }


    public static class Interval {
        public int start;
        public int end;
        public Gender gender;

        public Interval(int start, int end, Gender gender) {
            this.start = start;
            this.end = end;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return start + "-" + end + "-" + gender;
        }
    }

    public enum Gender {
        MALE,
        FEMALE;
    }
}
