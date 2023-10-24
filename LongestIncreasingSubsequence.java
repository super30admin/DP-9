// Time Complexity : O(nlogn)
// Space Complexity : O(n)

// Approach:
// 1. Create an array of size n and initialize the first element with the first element of the input array.
// 3. Iterate over the input array from index 1 to n-1.
// 4. If the current element is greater than the last element of the effective array, then append the current element to the effective array and increment len.
// 5. Else, do a binary search on the effective array and find the index of the first element that is greater than the current element. Replace the element at that index with the current element.
// 6. Return len.
public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] effectiveArray = new int[n];
        effectiveArray[0] = nums[0];
        int len = 1;

        for(int i=1;i<n;i++){
            if(nums[i] > effectiveArray[len-1]){
                effectiveArray[len] = nums[i];
                len++;
            }else{
                //do binary search and find just greate ele and put it at correct place
                int bsIndex = binarySearch(effectiveArray, 0, len-1, nums[i]);
                effectiveArray[bsIndex] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

}