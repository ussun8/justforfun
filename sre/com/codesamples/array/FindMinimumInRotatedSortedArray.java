public class Solution {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end) {
            if(nums[start] < nums[end]) {
                return nums[start];
            }
            
            if(end - start == 1) {
                return Math.min(nums[start], nums[end]);
            }
            
            int med = start + ((end-start)/2);
            if(nums[start] == nums[med]) {
                return nums[start];
            }
            else if(nums[start] < nums[med]) {
                start = med;
            } else {
                end = med;
            }
        }
        return Integer.MAX_VALUE;
    }
}
