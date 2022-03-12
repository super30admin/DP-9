// Time Complexity : Add : O(N * log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LongestIncreasingSubsequenced {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }

    public static  int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] result = new int[n];
        int k = 0;

        for(int i=0; i<n; i++){  // T.C - O(N * log N) // S.C - O(N)
            if(i == 0 || nums[i] > result[k-1]){
                result[k] = nums[i]; // simply add it to result array
                k++; // increment the result index
            } else {
                // do binary search and find where the nums[i] is supposed to be
                int index = binarySearch(result, 0, k-1, nums[i]);
                result[index] = nums[i];  // at that particular index add this element
            }
        }
        return k;
    }

    public static int binarySearch(int[] result, int start, int end, int target){
        while(start<end){
            int mid = start + (end-start)/2;
            if(result[mid] == target)
                return mid;
            else if(result[mid]<target)
                start = start+1;
            else
                end = mid;

        }
        return end;
    }
}

