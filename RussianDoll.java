import java.util.Arrays;

public class RussianDoll {

    // TC : O(n * log n) => first n * logn for sorting and second one for binary search
    // SC : O(n)
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;

        int n = envelopes.length;

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        // dp array will hold heights only
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        int len = 1;

        // This approach is similar to the second approach of Longest increasing subsequence
        for(int i=1; i < n;i++){
            if(envelopes[i][1] > dp[len]){
                dp[len] = envelopes[i][1];
                len++;
            }else {
                int searchIndex = binarySearch(dp, 0, len - 1, envelopes[i][1]);
                dp[searchIndex] = envelopes[i][1];
            }
        }

        return len;
    }

    private int binarySearch(int[] dp, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(dp[mid] == target){
                return mid;
            }else if(target < dp[mid]) {
                high = mid - 1;
            }else
                low = mid + 1;
        }

        return low;
    }
}
