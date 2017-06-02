import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNo = 1; caseNo <= t; ++caseNo) {
            int count = in.nextInt();
            int[] bff = new int[count+1];
            for(int i=1; i<=count; i++) {
                bff[i] = in.nextInt();
            }
            solve(caseNo, bff);
        }
    }

    private static void solve(int caseNo, int[] bff) {
        int maxCircle = 0;
        int maxChain = 0;
        int[] maxChainArr = new int[bff.length];
        for(int i=1; i<bff.length; i++) {
            boolean[] visited = new boolean[bff.length];
            int curNode = i;
            int count = 0;
            while(!visited[curNode]) {
                visited[curNode] = true;
                curNode = bff[curNode];
                count++;
            }
            if(curNode == i) maxCircle = Math.max(maxCircle, count);
            if(curNode == bff[bff[curNode]]) maxChainArr[curNode] = Math.max(maxChainArr[curNode], count);
        }

        for(int i=1; i<maxChainArr.length; i++) {
            if(maxChainArr[i] > 0) {
                maxChain += maxChainArr[i];
                maxChain += maxChainArr[bff[i]];
                maxChain -= 2;
                maxChainArr[bff[i]] = 0;
            }
        }

        int result = Math.max(maxCircle, maxChain);

        System.out.println("Case #" + caseNo + ": " + result);
    }
}
