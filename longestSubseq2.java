//Time: O(NlogN)
//Space: O(N)

//This approach uses binary search
class longestSub {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] arr = new int[nums.length];
        //we add the first element by default and keep track of filled array size
        arr[0] = nums[0];
        int len = 1;
        
        for(int i = 1; i < nums.length; i++){
            
            //compare the upcoming number with last number of array
            //if its greater just add it to the end
            if(nums[i] > arr[len - 1]){
                arr[len++] = nums[i];
            }
            //if smaller then binary search to find and add next to the largest smaller number
            else{
                int bIndex = binarySearch(arr, nums[i], 0, len - 1);
                arr[bIndex] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] arr, int target, int low, int high){
        
        while( low <= high){
            int mid = low + (high - low) / 2;
            
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
                
        }
        return low;
    }
}