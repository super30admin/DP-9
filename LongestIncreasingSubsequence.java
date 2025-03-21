//TimeComplexity - O(nlog(n))
//Space Complexity - O(n)
class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] result = new int[n];
        int len = 1;
        result[0] = nums[0];

        for(int i = 1; i<n; i++){
            if(nums[i] > result[len - 1]){
                result[len] = nums[i];
                len++;
            } else {
                int bsIndex = binarySearch(result, 0, len - 1, nums[i]);
                result[bsIndex] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] result, int low, int high, int target){
        while (low <= high) {
            int mid = high + (low - high) / 2;
            if (result[mid] == target) {
                return mid;
            } if (result[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
