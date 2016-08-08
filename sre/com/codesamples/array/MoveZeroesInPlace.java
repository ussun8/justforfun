public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int left=0;
        int right=1;
        int length = nums.length;
        
        while(right < length) {
            if(nums[left] == 0 && nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            if(!(nums[left] == 0)) {
                left++;
            }
            right++;
        }
    }
}
