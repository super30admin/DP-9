// DP Solution
//Time Complexity : O(n^2)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

class Longest_Increasing_Subsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxCount = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++)
        {   
            int count = 0;
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                    count = Math.max(count, dp[j]);
            }
            dp[i] = count + 1;
            maxCount = Math.max(maxCount, dp[i]);
        }
        return maxCount;
    }

// Binary Search Solution

// //Time Complexity : O(n logn)
// //Space Complexity : O(n)
// //Did this code successfully run on Leetcode : Yes
// //Any problem you faced while coding this : None

//     public int lengthOfLIS(int[] nums) {
//         if(nums == null || nums.length == 0)
//             return 0;
//         int n = nums.length;
//         int length = 1;
//         int[] arr = new int[n];
//         arr[0] = nums[0];
        
//         for(int i = 1; i < n; i++)
//         {
//             if(arr[length - 1] < nums[i])
//             {
//                 arr[length] = nums[i];
//                 length++;
//             }
//             else
//             {
//                 int idx = binarySearch(arr, 0, length - 1, nums[i]);
//                 arr[idx] = nums[i];
//             }
//         }
//         return length;
//     }
    
//     private int binarySearch(int[] arr, int low, int high, int target)
//     {
//         while(low <= high)
//         {
//             int mid = low + (high - low) / 2;
//             if(arr[mid] == target)
//                 return mid;
//             else if(arr[mid] < target)
//                 low = mid + 1;
//             else high = mid - 1;
//         }
//         return low; // low ptr is always at the just immediate greater element than the target in the arr[]
//     }
}