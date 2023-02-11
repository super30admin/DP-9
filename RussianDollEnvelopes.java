//Binary Search
// Time Complexity: O(n logn)
// Space Complexity :O(n)

/*
 * sort the martix based on width. now we look for the height in increasing
 * order. store the height in an array in increasing order. if the next 
 * element is incresing then add it to list else replace the element in list.
 */

 class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 1) return 1;
        int m = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] arr = new int[m+1];
        Arrays.fill(arr, 1);
        arr[0] = envelopes[0][1];
        int len = 1;
        for(int i = 1; i < m; i++){
            if(envelopes[i][1] > arr[len-1]){
                arr[len] = envelopes[i][1];
                len++;
            }
            else{
                int binary = binarySearch(arr, 0, len-1, envelopes[i][1]);
                arr[binary] = envelopes[i][1];
            }
        }
        return len;
    }

    public int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == target){
                return mid;
            }

            else if(target > arr[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
}

//DP (TLE solution)
// Time Complexity: O(n^2 + n logn)
// Space Complexity :O(n)

/*
 * sort the martix based on width. now we look for the height in increasing
 * order. maintain another pointer nad if the element is greater than that then
 * add it to the sequence and increment the length. return max length.
 */

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] dp = new int[m+1];
        Arrays.fill(dp, 1);
        int result = dp[0];
        for(int i = 1; i < m; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
    
}