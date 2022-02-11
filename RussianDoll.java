// Time Complexity: O(nlogn)
// Space Complexity: O(n)
// DP and Sorting
public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes)
    {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        
        int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) ->{    
            if(a[0] == b[0]) // edge case [6,4][6,7]
                return b[1]-a[1];
            return a[0] - b[0];
        });
        
        int []dp = new int[n];
        dp[0] = envelopes[0][1];
        int len = 1;
        
        for(int i = 1; i < n; i++)
        {
            if(dp[len-1]< envelopes[i][1])
            {
                dp[len] = envelopes[i][1];
                len++;
            }
            else
            {
                // replace old number with smaller value 
                // idx is the index of smallest number envelopes[i][1]
                int idx = binarySearch(0, len, envelopes[i][1], dp);
                dp[idx] = envelopes[i][1];
            }
        }
        return len;public int maxEnvelopes(int[][] envelopes) {
            if(envelopes == null || envelopes.length == 0)
                return 0;
            
            int n = envelopes.length ,idx = 0;
            // sort by width so that you can select by height
            Arrays.sort(envelopes, (a,b) ->{    
                if(a[0] == b[0]) // edge case [6,4][6,7]
                    return b[1]-a[1];
                return a[0] - b[0];
            });
            
            int []dp = new int[n];
            dp[idx] = envelopes[0][1];
           
            for(int i = 1; i < n; i++)
            {
                // if num > then add to dp array
                if(dp[idx]< envelopes[i][1])
                {
                    // need to grow idx first
                    dp[++idx] = envelopes[i][1];
                }
                else
                {
                    // replace old number with smaller value 
                    // idx is the index of smallest number envelopes[i][1]
                    int nidx = binarySearch(0, idx, envelopes[i][1], dp);
                    dp[nidx] = envelopes[i][1];
                }
            }
            return idx+1; // since idx starts with 0
        }
        
        private int binarySearch(int low, int high, int target, int[] nums)
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
                    low = mid+1;
                }
            }
            
            return low;
        }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n)
// DP Pattern 2 TLE
