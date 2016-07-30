import java.lang.Math;

public class Solution {
    public String minWindow(String s, String t) {
        
        if(s == null || t == null || s.length() == 0) {
            return "";
        }
        
        int sLength = s.length();
        int tLength = t.length();
        int start = 0;
        int totalCount = 0;
        int startIndex = 0;
        int endIndex = 0;
        int minimumLength = Integer.MAX_VALUE;
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        
        for(int i=0; i<tLength; i++) {
            int index = t.charAt(i);
            needToFind[index]++;
        }
        
        for(int end=0; end<sLength; end++) {
            int index = s.charAt(end);
            if(needToFind[index] == 0) {
                continue;
            }
            hasFound[index]++;
            if(hasFound[index] <= needToFind[index]) {
                totalCount++;
            }
            
            if(totalCount == tLength) {
                while(needToFind[s.charAt(start)] == 0 || hasFound[s.charAt(start)] > needToFind[s.charAt(start)]) {
                    if(hasFound[s.charAt(start)] > needToFind[s.charAt(start)]) {
                        hasFound[s.charAt(start)]--;
                    }
                    start++;
                }
                int minCandidate = end - start + 1;
                if(minCandidate < minimumLength) {
                    startIndex = start;
                    endIndex = end;
                    minimumLength = minCandidate;
                }
            }
        }
        if(totalCount == tLength) {
            return s.substring(startIndex, endIndex+1);
        }
        return "";
    }
}
