public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, max=0;
        Map<Character, Integer> charMap = new HashMap<>();
        int length = s.length();
        for(int j=0; j<length; j++) {
            char ch = s.charAt(j);
            if(charMap.keySet().contains(ch)) {
                int order = charMap.get(ch);
                i = Math.max(i, order);
            }
            max = Math.max(max, j-i+1);
            charMap.put(ch, j+1);
        }
        return max;
    }
}
