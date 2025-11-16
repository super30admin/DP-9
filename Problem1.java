// Time Complexity : O(n^2) where n is the number of elements in nums
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using top down dp approach to aintain length of maximum subsequence at each index. Exhaustively check if the current number is greater than each previous index. Put the maximum subsequence length at that point.
 */
class DpSolution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // all elements standalone are 1 length of subsequence
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i <n;i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}

// Time Complexity : O(n^2) where n is the number of elements in nums
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Using bottom up recursive approach to find out the maximum subsequence length. At each number, we have an option to choose or not choose the number.
 *  If we choose the number, then check if the current number is greater than previous choosen number. If it is, then increase the count by 1 and continue to recursion for next number.
 *  If we don't choose the number, then just check the maximum subsequence for the next number.
 */
class MemoSolution {
    Integer [][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        this.memo = new Integer[n][n];

        int re =  helper(nums, 0, -1);
        return re;
    }
    private int helper(int[] nums,int i, int prevIdx){
        //base
        if(i == nums.length){
            return 0;
        }
        if(memo[i][prevIdx+1] != null) return memo[i][prevIdx+1];
        //logic
        int case1 = 0;
        int case2 = 0;
        // skip the current number
        case1 = helper(nums, i+1, prevIdx);
        //don't skip the current number and check if this number is greater than previous number
        if(prevIdx == -1 || nums[i] > nums[prevIdx]){
            case2 = 1 + helper(nums, i+1, i);
        }

        memo[i][prevIdx+1] = Math.max(case1, case2);
        return Math.max(case1, case2);
    }
}

// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Maintain a separate array which tracks the effective longest subsequence of the main array.
 *  If the current number from input is greater than biggest number in subsequence array, then add the number to subsequence array.
 *  If the current number from input is not greater than biggest number in subsequence array, then replace the number in subsequence array which is just greater than the current number to maintain the effective subsequence length.
 *
 * At the end, return the maximum length.
 */
class BinarySearchSolution {
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
                int idx = binarySearch(arr, 0, le - 1, nums[i]);
                arr[idx] = nums[i];
            }
        }

        return le;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
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