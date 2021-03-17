// Binary Search 
// TC: O(NlogN) -> worst case do binary serach N times
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int lengthOfLIS(int[] nums) {
        if ( nums == null || nums.length == 0)
            return 0;
        int[] arr = new int[nums.length];
        int len = 1;
        arr[0] = nums[0];
        for ( int i = 1; i < arr.length; i++ )
        {
            if (nums[i] > arr[len-1])
            {
                arr[len] = nums[i];
                len++;
            }
            else
            {
                int index = closestBinarySearch(arr, 0, len, nums[i]);
                arr[index] = nums[i];
            }
        }
        return len;
    }
    private int closestBinarySearch(int[] arr, int low, int high, int target)
    {
        while ( low <= high)
        {
            int mid = low + (high-low)/2;
            if ( arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
}

// DP 
// TC: O(N^2)
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         if ( nums == null || nums.length == 0)
//             return 0;
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, 1);
//         int result = 1;
//         for ( int i = 0; i < dp.length; i++)
//         {
//             for ( int j = 0 ; j < i; j++)
//             {
//                 if (nums[i] > nums[j] )
//                 {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                     result = Math.max(result, dp[i]);
//                 }
//             }
//         }
//         return result;
//     }
// }
