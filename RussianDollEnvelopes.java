// Time Complexity : O(2^n) n-> no of envelopes
// Space Complexity : O(n), recursive stack space
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this : No

// Approach 1 : Brute force, recursive approach
// Here we have 2 choices at every step, whether to choose the current element or not choose the current element.
// We can choose the current element only if it is adheres to the given constraint.
// The result will be the maximum count of the two choices made.
// Since we need to fit in smaller envelope in bigger one, we can sort the envelopes based on the width.

/*
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // edge case
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        Comparator<int[]> comp = new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        };
        
        Arrays.sort(envelopes, comp);
        
        return helper(envelopes, 0, -1);
    }
    
    private int helper(int[][] envelopes, int currIdx, int prevIdx) {
        // base case
        if(currIdx >= envelopes.length)
            return 0;
        
        // logic
        // choose current envelope
        int count1 = 0;
        if(prevIdx == -1 || (envelopes[currIdx][0] > envelopes[prevIdx][0] && envelopes[currIdx][1] > envelopes[prevIdx][1])) {
            count1 = 1 + helper(envelopes, currIdx+1, currIdx);
        }
        
        // Do not choose current envelope
        int count2 = helper(envelopes, currIdx+1, prevIdx);
           
        return Math.max(count1, count2);
    }
}
*/

// Time Complexity : O(2^n) n-> no of envelopes. All unique possibilities are only explored. Overlapping subproblems are computed only once and then directly retrieved from the memo matrix.
// Space Complexity : O(n^2), memo matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 2 : Recursive approach with memoization
// Here we have 2 choices at every step, whether to choose the current element or not choose the current element.
// We can choose the current element only if it is adheres to the given constraint.
// The result will be the maximum count of the two choices made.
// Since we need to fit in smaller envelope in bigger one, we can sort the envelopes based on the width.
// if a certain combination of previous index and current index has been explored earlier, then no need to explore it again. Its result can be directly returned from the memoized array.

/*
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // edge case
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        Comparator<int[]> comp = new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        };
        
        Arrays.sort(envelopes, comp);
        
        int[][] memo = new int[envelopes.length+1][envelopes.length];
        
        return helper(envelopes, 0, -1, memo);
    }
    
    private int helper(int[][] envelopes, int currIdx, int prevIdx, int[][] memo) {
        // base case
        if(currIdx >= envelopes.length)
            return 0;
        
        if(memo[prevIdx+1][currIdx] != 0)
            return memo[prevIdx+1][currIdx];
        
        // logic
        // choose current envelope
        int count1 = 0;
        if(prevIdx == -1 || (envelopes[currIdx][0] > envelopes[prevIdx][0] && envelopes[currIdx][1] > envelopes[prevIdx][1])) {
            count1 = 1 + helper(envelopes, currIdx+1, currIdx, memo);
        }
        
        // Do not choose current envelope
        int count2 = helper(envelopes, currIdx+1, prevIdx, memo);
        memo[prevIdx+1][currIdx] = Math.max(count1, count2);
        return memo[prevIdx+1][currIdx];
    }
}
*/

// Time Complexity : O(n^2) n-> no of envelopes. 
// Space Complexity : O(n), dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 3 : creating a DP array
// We need to check for each index if the previous envelopes can be extended by the current index or not.

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // edge case
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        Comparator<int[]> comp = new Comparator<>() {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        };
        
        Arrays.sort(envelopes, comp);
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for(int curr = 0; curr < envelopes.length; curr++) {
            for(int prev = 0; prev < curr; prev++) {
                if(envelopes[prev][0] < envelopes[curr][0] && envelopes[prev][1] < envelopes[curr][1]) {
                    dp[curr] = Math.max(dp[curr], dp[prev]+1);
                }
            }
            max = Math.max(max, dp[curr]);
        }
        return max;
    }
}
