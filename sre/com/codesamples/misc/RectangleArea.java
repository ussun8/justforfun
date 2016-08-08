//Leetcode-223

import java.lang.Math;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A) * (D-B);
        int area2 = (G-E) * (H-F);
        
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);
        
        if(left >=right || bottom >= top) {
            return area1 + area2;
        }
        int commonArea = (right- left) * (top-bottom);
        return area1 + area2 - commonArea;
    }
}
