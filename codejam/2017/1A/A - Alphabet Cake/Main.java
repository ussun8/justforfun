import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int row = in.nextInt();
            int col = in.nextInt();
            char[][] cake = new char[row][col];
            boolean[][] visited1 = new boolean[row][col];
            boolean[][] visited2 = new boolean[row][col];
            for (int j = 0; j < row; ++j) {
                String s = in.next();
                for (int k = 0; k < col; ++k) {
                    cake[j][k] = s.charAt(k);
                }
            }

            for (int j = 0; j < row; ++j) {
                for (int k = 0; k < col; ++k) {
                    if(cake[j][k] != '?'){
                        dfs(cake, j, k, cake[j][k], visited1);
                    }
                }
            }

            for (int j = 0; j < row; ++j) {
                for (int k = 0; k < col; ++k) {
                    if(cake[j][k] != '?') {
                        dfs2(cake, j, k, cake[j][k], visited2);
                    }
                }
            }

            System.out.println("Case #" + i + ":");
            for (int j = 0; j < row; ++j) {
                for (int k = 0; k < col; ++k) {
                    System.out.print(cake[j][k]);
                }
                System.out.println();
            }
        }
    }

    private static void dfs(char[][] cake, int row, int col, char cellVal, boolean[][] visited1) {
        if((row<0) || (row >= cake.length) ||
                (cake[row][col] != '?' && cake[row][col] != cellVal) || visited1[row][col]) return;

        visited1[row][col] = true;
        cake[row][col] = cellVal;
        dfs(cake, row+1, col, cellVal, visited1);
        dfs(cake, row-1, col, cellVal, visited1);
    }

    private static void dfs2(char[][] cake, int row, int col, char cellVal, boolean[][] visited2) {
        if((col<0) || (col >= cake[0].length) ||
                (cake[row][col] != '?' && cake[row][col] != cellVal) || visited2[row][col]) return;

        visited2[row][col] = true;
        cake[row][col] = cellVal;
        dfs2(cake, row, col+1, cellVal, visited2);
        dfs2(cake, row, col-1, cellVal, visited2);
    }
}
