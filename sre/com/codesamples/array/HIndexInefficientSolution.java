//Leetcode-274

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int hIndex(int[] citations) {
        
        int hIndex = 0;
        
        if(citations == null || citations.length == 0) {
            return hIndex;
        }
        
        List<Integer> citList = new ArrayList<Integer>();
        
        for(int val : citations) {
            citList.add(val);
        }
        Collections.sort(citList);
        
        int length = citList.size();
        for(int i=0; i<length; i++) {   
            int biggerCitCount = length - i;
            int val = citList.get(i);
            if(val >= biggerCitCount) {
                hIndex = biggerCitCount;
                break;
            }
        }
        return hIndex;
    }
}
