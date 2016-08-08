//Leetcode-221

import java.lang.Math;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = row>0 ? matrix[0].length : 0;
        
        int[][] countArr = new int[row+1][column+1];
        int maxLength = 0;
        
        for(int i=1; i<=row; i++) {
            for(int j=1; j<=column; j++) {
                if(matrix[i-1][j-1] == '1') {
                    countArr[i][j] = Math.min(Math.min(countArr[i-1][j], countArr[i][j-1]), countArr[i-1][j-1]) + 1;
                    maxLength = Math.max(maxLength, countArr[i][j]);
                }
            }
        }
        
        return maxLength * maxLength;
    }
}
