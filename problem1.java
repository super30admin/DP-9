// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch 
Here are are using binary search to optmise the nested itteration

create a new array to keep track of how many LIS are there, we keep inceaseing and storing length
until we nums[i] not great them arr[le-1];
then we do the binary search to find idx of element to be replaced, num that if just bigger then cur
numder
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int le = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > arr[le - 1]) {
                arr[le] = nums[i];
                le++;
            } else {
                int bsIdx = binarySearch(arr, nums[i], 0, le - 1);
                arr[bsIdx] = nums[i];
            }
        }
        return le;
    }

    private int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}