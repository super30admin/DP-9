// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch 
Here are are using binary search to optmise the nested itteration

first we sort the array, by height if they are same use weidth
then take a new array of size of envelopes array
then we do loop over till n
we keep inceaseing and storing length
until we nums[i] not great them arr[le-1];
then we do the binary search to find idx of element to be replaced, num that if just bigger then cur
numder
*/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int[] arr = new int[n];
        arr[0] = envelopes[0][0];
        int le = 1;
        for (int i = 1; i < n; i++) {
            if (envelopes[i][0] > arr[le - 1]) {
                arr[le] = envelopes[i][0];
                le++;
            } else {
                int idx = binarySearch(arr, envelopes[i][0], 0, le - 1);
                arr[idx] = envelopes[i][0];
            }
        }
        return le;
    }

    private int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}