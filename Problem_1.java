// Time Complexity : O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// first set the innitial value to the arr array, the check for the new value from index 1. if the i is grater then j, the add j by 1 and and i, and set the arr[i] to be used to sore the value, once opposit, then find the index and replace the data. and for new increase the count.
// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] arr = new int [n];
        arr[0] = nums[0];
        int len = 1;
        for(int i = 1; i < n; i++){
            if(arr[len-1] < nums[i]){
                arr[len] = nums[i];
                len++;
            }else{
                int index = binarySearch(arr, nums[i], len-1, 0);
                if( index != -1){
                    arr[index] = nums[i];
                }
            }
        }
        return len;
    }
    private int binarySearch(int [] nums, int x, int h, int l){
        while( l <=h ){
            int m = l + (h-l)/2;
            if(nums[m] == x) return m;
            else if( nums[m] > x) h = m - 1;
            else l = m + 1;
        }
        return l;
    }
}

// // dp solution - but not the best
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int [] dp = new int [n];
//         Arrays.fill(dp,1);
//         int sum = 1;
//         for(int i = 1; i < n; i++){
//             for(int j = 0 ; j < i; j++){
//                 if(nums[i] > nums[j]){
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//                     sum = Math.max(sum, dp[i]);
//                 }
//             }
//         }
//         return sum;
//     }
// }