// Approach : Sort on width or height.if any of them equal then sort the other dimension in asc order 
// Perform the Binary Search to find idx of the element just greater than current Height in the effective array
// Time : o(n) *O(logn) = O(nlogn)
// Space : O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

        int n = envelopes.length;
        int[] arr = new int[n+1]; // effective array
        arr[0] = envelopes[0][1]; // LIS on height

        int len =1; //len for the effective array
        for(int i=1;i<n;i++){
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];
                len++;
            } else{
                // Perform the Binary Search to find idx of the element just greater than current Height in the effective array
                int bsIndex = binarySearch(arr,0,len-1,envelopes[i][1]); // effective array , low , high , target
                arr[bsIndex] = envelopes[i][1];
            }
        }
        return len; // len of effective array
    }

    private int binarySearch(int[] arr , int low , int high , int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;

            if(arr[mid]>target){
                high = mid-1;
            } else low = mid+1;
        }
        return low;
    }
}


// Approach : Bruteforce DP - either Sort on width or height 
// Time : O)(n^2)
// Space : O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a, b) -> a[1] - b[1]); // sort on the height
        int max =1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1]!=envelopes[j][1]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }

        }
        return max;
    }
}