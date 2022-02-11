// Time Complexity: O(nlogn)
// Space Complexity: O(n)
// DP and Sorting
public class LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length, idx = 0;
        int [] dp = new int[n];
        dp[idx] = nums[0]; // start a DP array with increasing numbers
        
        for(int i = 1 ; i < n ; i++)
        {
            // if nums[i] is greater add it to DP vals
            if(dp[idx] < nums[i])
            {
                dp[++idx] =nums[i]; // keep dp with growing values
            }
            else
            {
                // we found a smaller element find location for this smaller element by replacing old value
                int nidx = binarySearch(0, idx, nums[i], dp);
                //replace current element with the smallest element
                dp[nidx] = nums[i];
            }
        }
        
        return idx+1; // since idx = 0 
    }

    private int binarySearch(int low, int high, int target, int [] nums)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return low;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n)
// DP Pattern 2
public class LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        if(nums == null || nums.length == 0)
            return ans;
        
        int n = nums.length;
        int [] dp = new int[n];
        
        // worse case 1 will the longest subsequence
        Arrays.fill(result, 1);
        
        for(int i = 1 ; i < n ; i++)
        {
            for(int j = 0 ; j < i ; j ++) // window size
            {
                if(nums[j] < nums[i])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // keep only max length
                }
            }
            ans = Math.max(ans, dp[i]); // overall max is the answer
        }
        
        return ans;
    }
}