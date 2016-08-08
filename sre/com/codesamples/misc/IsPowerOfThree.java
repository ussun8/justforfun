public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) {
            return true;
        }
        
        int result = 1;
        int limit = Integer.MAX_VALUE/3;
        while(true) {
            if(result > limit) {
                break;
            }
            result *= 3;
            if(n == result) {
                return true;
            }
        }
        return false;
    }
}
