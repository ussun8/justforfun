public class Solution {
    public String longestPalindrome(String s) {
        if(s== null || s.length() == 0) {
            return null;
        }
        
        String longest = s.substring(0,1);
        int length = s.length();
        
        for(int i=0; i<length; i++) {
            String candidate1 = expandStr(s, i ,i);
            if(candidate1.length() > longest.length()) {
                longest = candidate1;
            }
            String candidate2 = expandStr(s, i ,i+1);
            if(candidate2.length() > longest.length()) {
                longest = candidate2;
            }
        }
        return longest;
    }
    
    public String expandStr(String s, int start, int end) {
        int size = s.length();
        
        while(start>=0 && end<=size-1 && (s.charAt(start) == s.charAt(end))) {
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
}
