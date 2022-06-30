//Method1
class Solution {

    // Time Complexity : 0(n^2) where n is the size of envelopes
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    //This logic is exactly the same as used in longest increasing subsequence. I am just sorting the array 1st based on height
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes , (a,b) -> a[0] - b[0]);
        int n = envelopes.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

//Optimized time

class Solution {

    // Time Complexity : 0(nlogn)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    //Exactly same concept but just I am sorting the array in such a way that if 2 widths are also similar, than I put the larger height 1st and then the smaller height. In this case, I won't take the lower width to put inside another envelope
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes , (a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int [] dp = new int[n];
        dp[0] = envelopes[0][1];
        int len = 1;
        for(int i = 1; i < n; i++){
            if(envelopes[i][1] > dp[len - 1]){
                dp[len] = envelopes[i][1];
                len++;
            }
            else{
                int index = BinarySearch(dp, 0, len - 1, envelopes[i][1]);
                dp[index] = envelopes[i][1];
            }
        }
        return len;
    }
    public int BinarySearch(int [] dp, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(dp[mid] == target){
                return mid;
            }
            else if(dp[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}