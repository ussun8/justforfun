public class Solution {
    public String reverseString(String s) {
        
        if(s == null || s.length() == 0) {
            return s;
        }
        return reverseStringHelper(s);
    }
    
    public String reverseStringHelper(String s) {
        
        int length = s.length();
        if(length==0 || length ==1) {
            return s;
        }
        String leftString = s.substring(0, length/2);
        String rightString = s.substring(length/2, length);
        
        return reverseStringHelper(rightString) + reverseStringHelper(leftString);
    }
    
}
