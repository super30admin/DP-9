//TimeComplexity:O(nlogn)
//spacecomplexity:O(n)

class Solution {
    int binarySearch(int []effectiveArray, int low, int high, int target) {
        while(low<=high) {
            int mid = low +(high-low)/2;
            if(effectiveArray[mid] == target) {
                return mid;
            } else if(effectiveArray[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
            
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int []effectiveArray = new int[nums.length];
        effectiveArray[0] = nums[0];
        int lastElement = 0;
        for(int i =1; i<nums.length;i++) {
            if(nums[i] > effectiveArray[lastElement]) {
                lastElement++;
              effectiveArray[lastElement] = nums[i];
              
              
            } else {
                int index = binarySearch(effectiveArray, 0, lastElement-1, nums[i]);
                effectiveArray[index] = nums[i];
                
            }
        }
        return lastElement+1;
    }
}