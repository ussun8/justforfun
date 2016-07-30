public class Solution {
    public String reverseString(String s) {
        
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }
}
