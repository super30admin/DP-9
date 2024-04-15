
import java.util.ArrayList;
import java.util.List;

class LongestIncreasingSubsequence {
    // TC: O(n^2)
    // SC: O(n)

    // Approach: Bottom up DP from the back.
    // At each point; see which value gives the largest
    // the increasing subsequence and take the max.

    public int lengthOfLIS(int[] nums) {
        int answer = 0;
        int[] dp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int res = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    res = Math.max(res, 1 + dp[j]);
                }
            }
            dp[i] = res;
            answer = Math.max(dp[i], answer);
        }

        return answer;
    }

    // TC: O(nlogn)
    // SC: O(n)

    // Approach: Maintain effective longest increasing
    // subsequence.

    public int lengthOfLIS2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                // replace next largest
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }

        return list.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int end = list.size() - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid) == target) {
                return mid;
            }

            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

}
