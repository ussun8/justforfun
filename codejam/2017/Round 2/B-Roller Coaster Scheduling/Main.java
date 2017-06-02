import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int seatCount = in.nextInt();
            int potentialCustomers = in.nextInt();
            int ticketCount = in.nextInt();
            int[] seats = new int[seatCount];
            int[] customers = new int[potentialCustomers];
            for(int i=0; i<ticketCount; i++) {
                int seat = in.nextInt();
                int customer = in.nextInt();
                seats[seat-1]++;
                customers[customer-1]++;
            }
            solve(caseNo, seats, customers);
        }
    }

    private static void solve(int caseNo, int[] seats, int[] customers) {
        int minRide = Integer.MIN_VALUE;
        for(int cus : customers) {
            minRide = Math.max(minRide, cus);
        }
        int total = 0;
        for(int i=0; i<seats.length; i++) {
            total += seats[i];
            int seatMinRide = calculateCeil(total, i+1);
            minRide = Math.max(minRide, seatMinRide);
        }

        int numOfPromotions = 0;
        for(int seat : seats) {
            if(seat > minRide) numOfPromotions += (seat - minRide);
        }

        System.out.println("Case #" + caseNo + ": " + minRide + " " + numOfPromotions);
    }

    private static int calculateCeil(int dividend, int divisor) {
        int remainder = 1;
        if((dividend % divisor) == 0) remainder = 0;
        return (dividend/divisor) + remainder;
    }
}
