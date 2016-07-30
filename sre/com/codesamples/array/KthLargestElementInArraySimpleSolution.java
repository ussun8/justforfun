public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        List<Integer> intList = new ArrayList<>(nums.length);
        for(int i=0; i<nums.length; i++) {
            intList.add(nums[i]);
        }
        Collections.sort(intList);
        return intList.get(intList.size()-k);
    }
}
