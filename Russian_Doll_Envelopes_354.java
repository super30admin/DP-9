// DP Solution
//Time Complexity : O(n^2)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

class Russian_Doll_Envelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        if(envelopes.length == 1)
            return 1;
        int n = envelopes.length;
        int maxCount = 0;
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++)
        {
            int count = 0;
            for(int j = 0; j < i; j++)
            {
                if(envelopes[i][0] > envelopes[j][0])
                {
                    if(envelopes[i][1] > envelopes[j][1])
                        count = Math.max(count, dp[j]);
                }
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

    // public int maxEnvelopes(int[][] envelopes) {
    //     if(envelopes == null || envelopes.length == 0)
    //         return 0;
    //     if(envelopes.length == 1)
    //         return 1;
    //     int n = envelopes.length;
    //     int length = 1;
    //     Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    //     int[] arr = new int[n];
    //     arr[0] = envelopes[0][1];
        
    //     for(int i = 1; i < n; i++)
    //     {
    //         if(arr[length - 1] < envelopes[i][1])
    //         {
    //             arr[length] = envelopes[i][1];
    //             length++;
    //          }
    //         else 
    //         {
    //             int idx = binarySearch(arr, 0, length - 1, envelopes[i][1]);
    //             arr[idx] = envelopes[i][1];
    //         }
    //     }
    //     return length;
    // }
    
    // private int binarySearch(int[] arr, int low, int high, int target)
    // {
    //     while(low <= high)
    //     {
    //         int mid = low + (high - low) / 2;
    //         if(arr[mid] == target)
    //             return mid;
    //         else if(arr[mid] < target)
    //             low = mid + 1;
    //         else high = mid - 1;
    //     }
    //     return low; // low ptr is always at the just immediate greater element than the target in the arr[]
    // }
}