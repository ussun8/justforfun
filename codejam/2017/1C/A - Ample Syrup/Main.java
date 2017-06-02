import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Main {

    static DecimalFormat df = new DecimalFormat("#.########", new DecimalFormatSymbols(Locale.US));

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int cakeCount = in.nextInt();
            int cakeNeeded = in.nextInt();
            Pair[] cakes = new Pair[cakeCount];
            for (int j = 0; j < cakeCount; ++j) {
                double rad = in.nextDouble();
                double h = in.nextDouble();
                Pair pair = new Pair(rad, h);
                cakes[j] = pair;
            }
            solve(i, cakes, cakeNeeded);
        }
    }

    private static void solve(int caseNo, Pair[] cakes, int cakeNeeded) {
        PairComparator comparator = new PairComparator();
        PairComparator2 comparator2 = new PairComparator2();
        Arrays.sort(cakes, comparator);
        double totalArea = Double.MIN_VALUE;

        for (int k = 0; k<(cakes.length -cakeNeeded+1); k++) {
            PriorityQueue<Pair> heap = createHeap(cakes, comparator2, k);
            double area = Math.PI * cakes[k].rad * cakes[k].rad;
            area += cakes[k].area;
            for (int i = 0; i < cakeNeeded-1; ++i) {
                area += heap.poll().area;
            }
            totalArea = Math.max(totalArea, area);
        }

        System.out.println("Case #" + caseNo + ": " + df.format(totalArea));
    }

    private static PriorityQueue<Pair> createHeap(Pair[] cakes, PairComparator2 comparator2, int start) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(comparator2);
        for (int i = start+1; i < cakes.length; ++i) {
            maxHeap.add(cakes[i]);
        }
        return maxHeap;
    }

    static class Pair {
        public double rad;
        public double h;
        public double area;

        public Pair(double rad, double h) {
            this.rad = rad;
            this.h = h;
            this.area = 2 * Math.PI * rad * h;
        }
    }

    static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            if(p1.rad != p2.rad) {
                return (int)p2.rad - (int)p1.rad;
            }
            return (int)p2.h - (int)p1.h;
        }
    }

    static class PairComparator2 implements Comparator<Pair> {

        //WHEN YOU COMPARE DOUBLES, DO NOT CAST THEM TO INT AND RETURN IN COMPARATOR (int) p1.area - (int) p2.area.. -> It was wrong!!!

        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.area < p2.area) return 1;
            if (p2.area < p1.area) return -1;
            return 0;
        }
    }
}
