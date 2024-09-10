//TC - O(nlogn)
//SC - O(1)
//Using Binary search
class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // Subsequence does not have to be consecutive. It can be consecutive or not.
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int le = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] > arr[le - 1]) {
                //fill last index of effective array
                arr[le] = nums[i];
                le++;
            } else {
                //replace the number with the number just greater
                int bsIdx = binarySearch(arr, 0, le - 1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return le;
    }
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}