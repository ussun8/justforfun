public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        PriorityQueue<Integer> minPrQueue = new PriorityQueue<>();
        
        for(int i=0; i<nums.length; i++) {
            minPrQueue.add(nums[i]);
            if(minPrQueue.size() > k) {
                minPrQueue.poll();
            }
        }
        return minPrQueue.peek();
    }
}
