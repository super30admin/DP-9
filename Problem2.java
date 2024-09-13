//Time = O(n log n)
//Space =  O(n)

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        
        // Sort the envelopes in ascending order by width, and if the widths are equal, sort in descending order by height
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // sort in descending order by height if the widths are equal
            } else {
                return a[0] - b[0]; // sort in ascending order by width
            }
        });
        
        // dp[i] stores the smallest height of the last envelope in a subsequence of length i+1 that we can form using the envelopes up to and including the i-th envelope
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE); // initialize dp array with largest possible value
        dp[0] = envelopes[0][1]; // base case
        
        // maxLen stores the length of the longest subsequence of heights
        int maxLen = 1;
        
        // For each envelope, compute the smallest height of the last envelope in a subsequence of length i+1 that we can form using the envelopes up to and including the i-th envelope
        for (int i = 1; i < n; i++) {
            int w = envelopes[i][0];
            int h = envelopes[i][1];
            
            // Use binary search to find the index of the smallest element in dp that is greater than or equal to h
            int lo = 0, hi = maxLen - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] < h) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            
            // If the index is negative, take the bitwise complement to get the index of the first element greater than h
            int idx = lo;
            if (idx < 0) {
                idx = -idx - 1;
            }
            
            // Update dp[idx] with h
            dp[idx] = h;
            
            // If we have found a new longest subsequence of heights, update maxLen
            if (idx == maxLen) {
                maxLen++;
            }
        }
        
        // The length of the longest subsequence of heights is equal to the length of dp
        return maxLen;
    }
}
