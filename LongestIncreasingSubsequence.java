// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can use dp to solve this problem with O(n^2) by checking all possible subsequence of previous elements and increasing one
// For n logn, we try to keep an effecting increasing subsequence and replace the incoming with an element that is just greater to make sure we are increasing the chances of getting a longer subsequence in the future
// eg [1,3,4,6,7] -> incoming 5 -> [1,3,4,5,7] now we can accomate future 6

class Solution {
    ArrayList<Integer> result;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        result = new ArrayList();
        result.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (result.get(result.size() - 1) < nums[i])
                result.add(nums[i]);
            else
                bsReplace(nums[i]);
        }
        return result.size();
    }

    private void bsReplace(int target) {
        int l = 0;
        int r = result.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == result.get(mid)) {
                l = mid;
                break;
            } else if (target < result.get(mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        result.set(l, target);
    }

    public int lengthOfLIS_DP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}