import java.util.Arrays;

/*
Russian Doll Envelopes
approach: Same as Longest Increasing Subsequence but here we have to search for correct position of incoming smaller element
time: O(n log n)
space: O(n)
 */
public class Problem2 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int dp[] = new int[n];
        Arrays.sort(envelopes, (a,b)->{
            if (a[1]==b[1]) return b[0]-a[0];
            return a[1]-b[1];
        });
        dp[0] = envelopes[0][0];
        int len = 1;
        for (int i=1;i<n;i++) {
            if (envelopes[i][0]>dp[len-1]) {
                dp[len++] = envelopes[i][0];
            }
            else {
                int bSIndex = binarySearch(dp, len, envelopes[i][0]);
                dp[bSIndex] = envelopes[i][0];
            }
        }
        return len;
    }

    private int binarySearch(int[] dp, int len, int target) {
        int l = 0, h = len-1;

        while (l<=h) {
            int m = l+(h-l)/2;

            if (dp[m]==target) return m;
            if (dp[m]<target) l = m+1;
            else h = m-1;
        }
        return l;
    }
}
