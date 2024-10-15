// DP Solution
// TC : O(n2)
// SC : O(n)
class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
        if (a[0] == b[0]) {
            return b[1] - a[1];
        } else {
            return a[0] - b[0];
        }
        });

        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i] ,dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}

//Binary Search Solution
// TC: O(nlogn)
// SC : O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) return b[1]-a[1];
            else return a[0]-b[0];
        });

        int length = 1;
        int[] effectiveNums = new int[n];
        effectiveNums[0] = envelopes[0][1];
        for(int i=1;i<n;i++) {
            if(envelopes[i][1] > effectiveNums[length-1]) {
                effectiveNums[length++] = envelopes[i][1];
            } else {
                int bsIdx = binarySearch(effectiveNums,0,length,envelopes[i][1]);
                effectiveNums[bsIdx] = envelopes[i][1];
            }
        }
        return length;
    }

    private int binarySearch(int [] arr, int low, int high, int target) {
        while(low < high) {
            int mid = low+(high - low)/2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] > target) high = mid;
            else low = mid+1;
        }
        return low;
    }
}