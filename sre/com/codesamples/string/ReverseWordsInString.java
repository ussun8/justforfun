public class Solution {
    public String reverseWords(String s) {
        
        if(s == null || s.isEmpty()) {
            return s;
        }
        
        String[] words = s.trim().split("\\s+");
        String resultStr = "";
        
        StringBuilder builder = new StringBuilder();
        for(int i=words.length-1; i>0; i--) {
            builder.append(words[i]);
            builder.append(" ");
        }
        builder.append(words[0]);
        
        return resultStr + builder.toString();
    }
}
