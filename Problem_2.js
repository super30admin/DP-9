// ## Problem2: Russian Doll Envelopes (https://leetcode.com/problems/russian-doll-envelopes/)

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
        if (target === arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return low;
}
/**
 * @param {number[][]} envelopes
 * @return {number}
 */
var maxEnvelopes = function (envelopes) {
    if (envelopes === null || envelopes.length === 0)
        return 0;

    // Binary Search
    envelopes.sort((a, b) => {
        if (a[0] === b[0]) {
            return b[1] - a[1];
        }
        return a[0] - b[0];
    });

    let len = 1;
    let n = envelopes.length;
    let arr = new Array(n);
    arr[0] = envelopes[0][1];
    for (let i = 1; i < n; i++) {
        if (envelopes[i][1] > arr[len - 1]) {
            arr[len] = envelopes[i][1];
            len++;
        } else {
            let index = binarySearch(arr, 0, len - 1, envelopes[i][1]);
            arr[index] = envelopes[i][1];
        }
    }
    return len;

    // DP
    // envelopes.sort((a,b) => a[0]-b[0]);
    // let max = 1;
    // let n = envelopes.length;
    // let dp = new Array(n);
    // dp.fill(1);
    // for(let i=1; i<n; i++){
    //     for(let j=0; j<i; j++){
    //         if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
    //             dp[i] = Math.max(dp[i], dp[j]+1);
    //             max = Math.max(max, dp[i]);
    //         }
    //     }
    // }
    // return max;
};
