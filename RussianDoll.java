//TC will be O(n log n)
//SC will be O(n)

import java.util.Arrays;

class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        int len = 1;

        for(int i = 1; i < n; i++) {
            if(envelopes[i][1] > dp[len - 1]) {
                dp[len] = envelopes[i][1];
                len++;
            } else {
                int bsIndex = binarySearch(dp, 0, len - 1, envelopes[i][1]);
                dp[bsIndex] = envelopes[i][1]; // Update the value in dp array
            }
        }
        return len;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args){
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        RussianDoll obj = new RussianDoll();
        System.out.println(obj.maxEnvelopes(envelopes));

    }
}
