import java.util.Arrays;

// Time Complexity :O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - Pointer i is used to iterate over the entire array once.
 * 2 - Pointer j is used to form possible combinations with the pointer i and the elements before it.
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null)
        {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        
        Arrays.fill(dp,1);
        
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}

//Time Complexity - O(nlogn)
//Space Complexity - O(n)
//This solution will give us the length of the longest subsequence only. Not the exact subsequence
/*
 * 1 - We build an effective array which works by the following way:
 * - We add the first element to this array. IF the incoming element from the main array is greater than the added element, then we 
 * append it to the effective array. If the element is not greater, then we find the next greater element & perform BS to replace this element at the right index.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int len = 1;
        
        for(int i = 1; i<n; i++)
        {
            if(nums[i] > arr[len-1])
            {
                arr[len] = nums[i];
                len++;
            }
            else
            {
                int binInd = binarySearch(arr,0,len-1,nums[i]);
                arr[binInd] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int[] arr, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
            {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return low;
    }
}