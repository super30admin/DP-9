import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequenceBottomUpDP {

        // Bottom Up Dynamic Programming - Time O(n*n) and Space O(n)

        public int lengthOfLIS(int[] nums) {

            // dp array
            int n = nums.length;                  // O(n) space
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            // initial condition
            int max = 1;

            // iterate over elements of nums
            for(int i = 1; i < n; i++) {           // O(n*n)

                // iterate over prior elements
                for(int j = 0; j < i; j++) {

                    // update dp, if a smaller element is found prior to current element
                    if(nums[j] < nums[i]) {

                        // dp at i is maximum of itself and 1 plus dp value at prior smaller element
                        dp[i] = Math.max(dp[i], dp[j] + 1);

                        // update length of the longest increasing subsequence after each dp edit
                        max = Math.max(dp[i], max);
                    }
                }
            }
            // output
            return max;
        }

        public static void main(String[] args) {

            LongestIncreasingSubsequenceBottomUpDP obj = new LongestIncreasingSubsequenceBottomUpDP();

            Scanner scanner = new Scanner(System.in);

            System.out.println("length of nums: ");
            int n = scanner.nextInt();
            int[] nums = new int[n];

            System.out.println("nums: ");
            for(int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int answer = obj.lengthOfLIS(nums);

            System.out.println("the length of the longest strictly increasing subsequence: " + answer);
        }

}

/*
Time Complexity = O(n*n)
Space Complexity = O(n)
*/