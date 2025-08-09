// Time Complexity : O(n log(n))
// Space Complexity : o(n)
public class LongestIncreasingSubsequence {
    static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int len = 1;
        for(int i=1; i<n; i++){
            if(nums[i] > arr[len-1]) {
                arr[len] = nums[i];
                len++;
            } else {

                arr[binarySearch(arr, 0, len-1, nums[i])] = nums[i];
            }
        }
        return len;
    }
    static int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("Longest Increasing Subsequence: " + lengthOfLIS(nums));
    }
}
