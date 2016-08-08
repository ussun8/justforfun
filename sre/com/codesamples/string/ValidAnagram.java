//Leetcode-242

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        String sortedS = sortStr(s);
        String sortedT = sortStr(t);
        return sortedS.equals(sortedT);
    }
    
    public String sortStr(String str) {
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
}
