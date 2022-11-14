//Time Complexity: O(N Log N)
//Space Complexity: O(N)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, 
                    (a,b) -> (a[0] == b[0]) ? b[1]-a[1] : a[0]-b[0]);
        return lengthofLis(envelopes);
    }
    
    private int lengthofLis(int[][] envs) {
        int len = 0, size = envs.length;
        int[] dp = new int[size];
        dp[len++] = envs[0][1];
        
        for (int i=1; i<size; i++) {
            if (envs[i][1] > dp[len-1]) {
                dp[len++] = envs[i][1];
            } else {
                int pos = findPos(dp, 0, len-1, envs[i][1]);
                dp[pos] = envs[i][1];
            }
        }
        return len;
    }
    
    private int findPos(int[] dp, int low, int high, int n) {
        int mid;
        while (low <= high) {
            mid = low + (high-low)/2;
            if (dp[mid] == n) return mid;
            else if (dp[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}