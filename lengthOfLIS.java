// approch 1 
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 using DP array
    public static int lengthOfLIS(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        // dp array
        int[] dp = new int[n];
        // fill dp array with 1
        Arrays.fill(dp, 1);
        // max length would be 1 as it is element itself
        // length of 1
        int max = 1;
        // here I will check for each element at index less than current index(i)
        // I will get max length from the previous length
        for (int i = 1; i < n; i++) {
            // second for loop to check previous elements
            for (int j = 0; j < i; j++) {
                // if previous element is less than current element
                if (nums[j] < nums[i]) {
                    // update dp value
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // update the max value
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // approch 2 using effective increasing array
    public static int lengthOfLIS2(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        // effective array list
        List<Integer> list = new ArrayList<>();
        // here I will check if current element is greater than
        // last element in the effective array list than I will add
        // element at last in effective array list or else I will update
        // at suitable index

        // add first element in the list
        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (list.get(list.size() - 1) < nums[i]) {
                list.add(nums[i]);
            } else {
                // get suitable index
                int bsIndex = binarySearch(list, nums[i]);
                list.set(bsIndex, nums[i]);
            }
        }
        return list.size();

    }

    // binary search for getting most suitable index for element
    private static int binarySearch(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // if target matches with mid index element
            if (target == list.get(mid))
                return mid;
            // else if in target is in first half
            else if (target < list.get(mid))
                r = mid - 1;
            else
                l = mid + 1;

        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));

    }
}