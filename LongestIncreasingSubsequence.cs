// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1) Brute force
// 2) Either choose or not choose element, then take new array and remaining array and keep going
// 3) U will sequences in the end, then we can see which one is in increasing order  and longer
// 4) TC: O(2^n)

// 1) DP
// 2) Create array of length input n with all values 1
// 3) Keep j at 0 and i at 1
// 4) Start comparing i and j values
//     a. If value at j < I, increment j until j = i+1
//         i. Then increment i to i+1 and take j back to 0
//         ii. Then start comparing again i and j
//     b. If value to j > I
//         i. Set count array at i = j+1, only count  if count[i] < count[j] +1, because we are making sure we are not overwriting with lower value, because we already longer subsequence for that index.
//         ii. This mean till index I, we have longest increasing subsequence is count[i]
//         iii. This makes sure we are taking longest subsequence far and adding +1 for new longer subsequence by including one more element.
// 5) Keep max variable and keep overwriting from count array
// 6) TC: O(n^2)
// 7) SC: O(n)

public int LengthOfLIS(int[] nums) {
    if(nums == null || nums.Length == 0)
        return 0;
    
    if(nums.Length == 1)
        return 1;
    
    int n = nums.Length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    int len = 1;
    
    for(int i = 1; i < n; i++)
    {
        if(nums[i] > dp[len - 1])
        {
            dp[len] = nums[i];
            len++;
        }
        else
        {
            int bsIndex = binarySearch(dp, 0, len - 1, nums[i]);
            dp[bsIndex] = nums[i];
        }
    }

    return len;
    
    
    
//         int max = 1;
    
//         for(int i = 0; i < n; i++)
//         {
//             dp[i] = 1;
//         }
    
//         for(int i = 1; i < n; i++)
//         {            
//             for(int j = 0; j < i; j++)
//             {
//                 if(nums[i] > nums[j])
//                 {
//                     dp[i] = Math.Max(dp[i], dp[j] + 1);
//                     max = Math.Max(max, dp[i]);
//                 }
//             }
//         }
//         return max;
}

private int binarySearch(int[] dp, int low, int high, int target)
{
    while(low <= high)
    {
        int mid = low + (high - low) /2;
        if(dp[mid] == target)
            return mid;
        if(dp[mid] < dp[target])
            low = mid + 1;
        else
            high = mid - 1;
    }
    return low;
}