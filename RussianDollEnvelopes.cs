// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach


// 	1) Sort first on width
// 	2) Then create dp array as same approach above
// 	3) TC: O(n^2)
// 	4) SC: O(n)


// 	1) Sort first on width decreasing and height on icreasing
// 		a. Higher height cvomes first because we need to binary search on dp array
// 	2) Then do above approach same, binary search and create dp array
// 	3) TC: O(nlogn)
// SC: O(n)

 public int MaxEnvelopes(int[][] envelopes) {
    if(envelopes == null || envelopes.Length == 0)
        return 0;
    
    Array.Sort(envelopes, (a, b) => {
        if(a[0] == b[0])
            return b[1] - a[1];
        return a[0] = b[0];
    });
                
    int n = envelopes.Length;
    int[] dp = new int[n];
    dp[0] = envelopes[0][1];
    int len = 1;
    
    for(int i = 1; i < n; i++)
    {
        if(envelopes[i][1] > dp[len - 1])
        {
            dp[len] = envelopes[i][1];
            len++;
        }
        else
        {
            int bsIndex = binarySearch(dp, 0, len - 1, envelopes[i][1]);
            dp[bsIndex] = envelopes[i][1];
        }

    }
    
    return len;
        
    
                
                
    //return  dpMaxEnvelopes(envelopes)
}

private int dpMaxEnvelopes(int[][] envelopes)
{

    Array.Sort(envelopes, (a, b) => a[0] - b[0]);
    int n = envelopes.Length;
    int[] dp = new int[n];
    int max = 1;

    for(int i = 0; i < n; i++)
    {
        dp[i] = 1;
    }
    
    for(int i = 1; i < n; i++)
    {            
        for(int j = 0; j < i; j++)
        {
            if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0])
            {
                dp[i] = Math.Max(dp[i], dp[j] + 1);
                max = Math.Max(max, dp[i]);
            }
        }
    }
    return max;
}
                
private int binarySearch(int[] dp, int low, int high, int target)
{
    while(low <= high)
    {
        int mid = low + (high - low)/2;
        if(dp[mid] == target)
            return mid;
        
        if(dp[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;            
    }
    return low;
}