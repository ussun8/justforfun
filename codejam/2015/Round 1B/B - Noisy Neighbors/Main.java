import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int row = in.nextInt();
            int col = in.nextInt();
            int tenants = in.nextInt();
            solve(caseNo, row, col, tenants);
        }
    }

    private static void solve(int caseNo, int row, int col, int tenants) {
        List<Integer> oddCountList = new ArrayList<>();
        List<Integer> evenCountList = new ArrayList<>();

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                int wallCount = 0;
                if(i>0) wallCount++;
                if(j>0) wallCount++;
                if(i+1<row) wallCount++;
                if(j+1<col) wallCount++;
                if((i+j) % 2 == 0) evenCountList.add(wallCount);
                else oddCountList.add(wallCount);
            }
        }
        Collections.sort(evenCountList);
        Collections.sort(oddCountList);

        int emptyCellCount = row*col-tenants;
        int evenUnhappiness = calculateHappiness(evenCountList, emptyCellCount);
        int oddUnhappiness = calculateHappiness(oddCountList, emptyCellCount);

        System.out.println("Case #" + caseNo + ": " + Math.min(evenUnhappiness, oddUnhappiness));
    }

    private static int calculateHappiness(List<Integer> countList, int emptyCellCount) {
        if (emptyCellCount >= countList.size()) return 0;
        int total = 0;
        int cellToSelect = countList.size() - emptyCellCount;
        for(int i=0; i<cellToSelect; i++) total +=countList.get(i);
        return total;
    }
}
