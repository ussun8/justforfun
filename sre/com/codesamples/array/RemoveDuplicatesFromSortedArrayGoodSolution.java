public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return -1;
        }
        int length = nums.length;
        if(length == 0 || length == 1) {
            return length;
        }
        int i = 0;
        for(int j=1; j<length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
