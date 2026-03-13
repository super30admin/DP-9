
    /**
    Time Complexity :
    DP Solution        -> O(N^2)
    Binary Search Sol  -> O(N log N)

    Explanation:
    - DP checks every previous element for LIS.
    - Binary Search approach maintains a sorted array of LIS tails
      and uses binary search to update positions.

    Space Complexity : O(N)
    Explanation:
    We use an auxiliary array to store the smallest tail of increasing
    subsequences of different lengths.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially implemented the DP solution which is O(N^2).
    Later optimized using the binary search approach where we maintain
    the smallest possible tail element for each LIS length.
    Also needed to carefully implement binary search to find the
    correct replacement index.
    */

    class Solution {


        public int lengthOfLIS(int[] nums) {
            int result = binarySearchSol(nums);
            return result;
        }
    
        // O(N^2) DP solution
        private int dpSolution(int[] nums) {
    
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
    
            int count = 1;
    
            for (int i = 1; i < n; i++) {
    
                for (int j = 0; j < i; j++) {
    
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        count = Math.max(count, dp[i]);
                    }
                }
            }
    
            return count;
        }
    
        // O(N log N) optimized solution
        private int binarySearchSol(int[] nums) {
    
            int n = nums.length;
            int[] arr = new int[n];
    
            arr[0] = nums[0];
            int l = 1;
    
            for (int i = 1; i < n; i++) {
    
                if (nums[i] > arr[l - 1]) {
                    arr[l] = nums[i];
                    l++;
                }
                else {
                    int bidx = binarySearch(arr, 0, l - 1, nums[i]);
                    arr[bidx] = nums[i];
                }
            }
    
            return l;
        }
    
        // Binary search to find correct replacement index
        private int binarySearch(int[] arr, int low, int high, int target) {
    
            while (low <= high) {
    
                int mid = low + (high - low) / 2;
    
                if (arr[mid] == target) {
                    return mid;
                }
                else if (arr[mid] > target) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
    
            return low;
        }
    }