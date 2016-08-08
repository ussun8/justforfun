//leetcode-274

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int hIndex(int[] citations) {
        
        if(citations == null || citations.length == 0) {
            return 0;
        }
        
        int length = citations.length;
        int[] counts = new int[length+1];
        for(int i=0; i<length; i++) {
            int val = citations[i];
            if(val > length) {
                counts[length]++;
            } else {
                counts[val]++;
            }
        }
        
        int total = 0;
        for(int i=length; i>=0; i--) {
            total += counts[i];
            if(total >= i) {
                return i;
            }
        }
        return 0;
    }
}
