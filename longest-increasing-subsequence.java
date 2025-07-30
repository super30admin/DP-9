//0-1 recursion: chhose - not choose
//time = O(2^n)
//space = 

// //tabulation DP
// //time = O(n^2)
// //space = O(n)
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp,1);
//         int max=1;
//         for(int i=1; i<n; i++){
//             for(int j=0; j<i; j++){
//                 if(nums[j] < nums[i]){
//                     dp[i]=Math.max(dp[i], dp[j]+1);
//                     max = Math.max(max, dp[i]);
//                 }
//             }
//         }
//         return max;
//     }
// }


//Binary Search
//visit each element and form effective increasing sub sequence array
//if curr element is greater than previous(last) element in the subarray then add the curr to subarray
//if curr element is smaller than previous(last) element in the subarray, then replace the number which is JUST greater(closest greater) than curr element with curr in subarray.
//Time=O(nlogn)
//Space=O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n];
        arr[0]=nums[0];
        int le=1;
        for(int i=1; i<n; i++){
            if(arr[le-1]<nums[i]){
                arr[le] = nums[i];
                le++;
            } else {
                //what idx to be replaced
                int bsIdx = binarySearch(arr,0, le, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return le;
    }
    private int binarySearch(int [] arr, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                return mid;
            } else if(arr[mid] > target){
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return low;
    }
}