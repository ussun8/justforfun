import java.lang.Math;

public class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        return maxSubArrayHelper(nums, 0, nums.length-1);
        
    }
    
    public int maxSubArrayHelper(int[] nums, int start, int end) {
        if(start == end) {
            return nums[start];
        }
        int middle = start + ((end-start)/2);
        int leftR = maxSubArrayHelper(nums, start, middle);
        int rightR = maxSubArrayHelper(nums, middle+1, end);
        
        int total = 0;
        int leftMax = nums[middle];
        int rightMax = nums[middle+1];
        for(int i=middle; i>=start; i--) {
            total += nums[i];
            leftMax = Math.max(leftMax, total);
        }
        total = 0;
        for(int i=middle+1; i<=end; i++) {
            total += nums[i];
            rightMax = Math.max(rightMax, total);
        }
        return Math.max(Math.max(leftR, rightR), leftMax + rightMax);
    }
}
