// Time Complexity : 1 - O(n^2), 2 - O(nlogn)
// Space Complexity : 1 - O(n), 2 - O(n)

// DP Solution (when n is small)
/*class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        // Sorting based on width
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}*/

// Binary Search Solution (when n is large)
class Solution {
  public int maxEnvelopes(int[][] envelopes) {
    if(envelopes == null || envelopes.length == 0) return 0;
    // Sorting based on width
    Arrays.sort(envelopes, (a,b) -> {
      if(a[0] == b[0]) {
        return b[1] - a[1];
      }
      return a[0] - b[0];
    });
    int n = envelopes.length;
    int[] result = new int[n];
    result[0] = envelopes[0][1];
    int len = 1;
    for(int i = 1; i<n; i++) {
      if(envelopes[i][1] > result[len-1]) {
        result[len] = envelopes[i][1];
        len++;
      } else {
        int index = binarySearch(result, 0, len-1, envelopes[i][1]);
        result[index] = envelopes[i][1];
      }
    }
    return len;
  }

  private int binarySearch(int[] nums, int low, int high, int target) {
    while(low <= high) {
      int mid = low + (high - low)/2;
      if(nums[mid] == target) return mid;
      else if(nums[mid] > target) high = mid - 1;
      else low = mid + 1;
    }
    return low;
  }
}