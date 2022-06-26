/*
Problem: https://leetcode.com/problems/longest-increasing-subsequence/
*/

// Approach 1: DP
// TC: O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        int dp[] = new int[n];
        // To be able to print the chosen elements
        int indices[] = new int[n];
        int max = 1;
        
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; ++i) {
            indices[i] = i;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        indices[i] = j;
                    }
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(indices));
        return max;
    }
}

// Approach 2: Binary Search
// TC: O(n log n)
// SC: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
            System.out.println(sub);
        }
        
        return sub.size();
    }
    
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            
            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}