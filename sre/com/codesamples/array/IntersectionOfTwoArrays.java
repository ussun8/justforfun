public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(isNotValid(nums1,nums2)) {
            return new int[0];
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        int arrLength = nums1.length>nums2.length ? nums1.length : nums2.length;
        List<Integer> resultList = new ArrayList<>();
        int index = 0;
        
        for(int i=0; i<nums1.length; i++) {
            if(countMap.containsKey(nums1[i])) {
                Integer count = countMap.get(nums1[i]);
                countMap.put(nums1[i],++count);
            } else {
                countMap.put(nums1[i],1);
            }
        }
        
        for(int i=0; i<nums2.length; i++) {
            if(countMap.containsKey(nums2[i]) && (countMap.get(nums2[i])>0)) {
                resultList.add(nums2[i]);
                Integer count = countMap.get(nums2[i]);
                countMap.put(nums2[i],--count);
            }
        }
        
        return listToArr(resultList);
    }
    
    private int[] listToArr (List<Integer> resultList) {
        int[] resultArr = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }
    
    private boolean isNotValid(int[] nums1, int[] nums2) {
        return nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0;
    }
}
