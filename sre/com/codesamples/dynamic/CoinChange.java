import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0) {
            return 0;
        }
        
        if(coins == null) {
            return -1;
        }
        
        int[] countArr = new int[amount+1];
        Arrays.fill(countArr, Integer.MAX_VALUE);
        countArr[amount] = 0;
        int coinsLen = coins.length;
        
        for(int i=amount; i>=0; i--) {
            for(int j=0; j<coinsLen; j++) {
                int coin = coins[j];
                int index = i-coin;
                if(index >= 0 && countArr[i] != Integer.MAX_VALUE) {
                    countArr[index] = Math.min(countArr[index],countArr[i] + 1);
                }
            }
        }
        if (countArr[0] == Integer.MAX_VALUE) {
            return -1;
        }
        return countArr[0];
    }
}
