using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class LongestIncreasingSubSeq
    {
        /*
         * T.C: O(n2) since looping twice 
         * S.C: O(n) dp array contains n element
         * 
         */
        public int LengthOfLIS(int[] nums)
        {
            if (nums == null || nums.Length == 0) return 0;

            int n = nums.Length;
            int[] dp = new int[n];
            Array.Fill(dp, 1);
            //dp[0] = nums[0];
            int len = 1;
            int max = 1;

            for (int i = 1; i < n; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    if (nums[j] < nums[i])
                    {
                        dp[i] = Math.Max(dp[i], dp[j] + 1);
                        max = Math.Max(max, dp[i]);
                    }

                }
            }

            return max;

        }


        /*
         * T.C. O(nlogn) binary searh cause logn and since we are traversing all elements
         * S.C. O(n) since dp array is of length n
         * 
         */
        public int LengthOfLIS1(int[] nums)
        {
            if (nums == null || nums.Length == 0) return 0;

            int n = nums.Length;
            int[] dp = new int[n];

            dp[0] = nums[0];
            int len = 1;


            for (int i = 1; i < n; i++)
            {
                if (nums[i] > dp[len - 1])
                {
                    dp[len] = nums[i];
                    len++;
                }
                else
                {
                    int bsIndex = binarySearch(dp, 0, len - 1, nums[i]);
                    dp[bsIndex] = nums[i];
                }
            }

            return len;

        }
        private int binarySearch(int[] dp, int low, int high, int target)
        {
            while (low <= high)
            {
                int mid = low + (high - low) / 2;

                if (dp[mid] == target)
                {
                    return mid;
                }

                if (dp[mid] < target)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            return low;
        }
    }
}
