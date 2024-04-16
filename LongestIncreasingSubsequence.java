
import java.util.Arrays;

//TC - O(n^2)
//SC - O(n)
//https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
  public int lengthOfLIS(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      Arrays.fill(dp,1);
      int result = 1;
      for (int i = 1; i < n; i++) {
          for (int j = 0; j < i; j++) {
              if (nums[i] > nums[j]) {
                  dp[i] = Math.max(dp[i], dp[j] + 1);
                  result = Math.max(dp[i], result);
              }
          }
      }
      return result;
  }
}
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
