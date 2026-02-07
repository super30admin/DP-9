// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: Firstly we sort the array in increasing width, and if two heights are the same, we sort them in descending order
// 2: We maintain an effective array that holds the max length of the subsequence. During iteration on the main array, if we encounter a height larger than the last element in the effective array, we add it to the array
// 3: If the height present in the main array is smaller, we replace that element in the effective array using Binary Search to find the correct index
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int[] arr = new int[n];
        int idx = 0; //index on effective array
        arr[0] = envelopes[0][1];

        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > arr[idx]) {
                arr[idx + 1] = envelopes[i][1];
                idx++;
            } else {
                // replace
                int bsIdx = binarySearch(arr, 0, idx, envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
            }
        }

        return idx+1; // length
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = (low) + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
}