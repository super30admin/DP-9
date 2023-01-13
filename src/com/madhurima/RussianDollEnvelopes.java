//TC = O(n*n) for dp approach, O(nlogn) for dp with binary search approach (another nlogn for sorting)
//SC = O(n)
//Solution executed successfully on LeetCode: yes, DP approach with TC = O(n*n) gave TLE

package com.madhurima;

import java.util.Arrays;

public class RussianDollEnvelopes {
}

class RussianDollEnvelopesDp {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }

        int n = envelopes.length;

        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;

    }
}

class RussianDollEnvelopesDpWithBinarySearch {

    //using dp and binary search
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }

        int n = envelopes.length;
        int[] dp = new int[n];

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1]; //if width are same, then decreasing order of height
            }
            return a[0] - b[0];
        });

        dp[0] = envelopes[0][1];
        int len = 1;

        for(int i = 1; i < n; i++){
            if(envelopes[i][1] > dp[len-1]){
                dp[len] = envelopes[i][1];
                len++;
            }else{
                int index = binarySearch(dp, 0, len-1, envelopes[i][1]);
                dp[index] = envelopes[i][1];
            }
        }

        return len;

    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }
}
