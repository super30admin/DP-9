// ## Problem1: Longest Increasing Subsequence (https://leetcode.com/problems/longest-increasing-subsequence/)

// DP
// Time Complexity : O(n^2)
// Space Complexity : O(n)

// Binary Search
// Time Complexity : O(nlogn)
// Space Complexity : O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

var binarySearch = (arr, low, high, target) => {
    while (low <= high) {
        let mid = Math.floor(low + ((high - low) / 2));
        if (arr[mid] === target) {
            return mid;
        } else if (arr[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return low;
}
/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
    if (nums === null || nums.length === 0)
        return 0;
    let n = nums.length;
    let len = 1;
    let arr = new Array(n);
    arr[0] = nums[0];
    for (let i = 1; i < n; i++) {
        if (nums[i] > arr[len - 1]) {
            arr[len] = nums[i];
            len++;
        } else {
            let index = binarySearch(arr, 0, len - 1, nums[i]);
            arr[index] = nums[i];
        }
    }
    return len;

    // let dp = new Array(n);
    // let max = 1;
    // dp.fill(1);
    // for(let i=1; i<n; i++){
    //     for(let j=0; j<i; j++){
    //         if(nums[i]>nums[j]){
    //             dp[i] = Math.max(dp[i], dp[j]+1);
    //             max = Math.max(max, dp[i]);
    //         } 
    //     }
    // }
    // return max;
};