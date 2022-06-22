using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class RussianDollEnvelopes
    {
        /*
         * T.C: O(nlogn) sorting cost nlogn and creating dp array cost nlogn, so asymptotically nLogn
         * S.C: O(n)
         */
        public int MaxEnvelopes(int[][] envelopes)
        {
            if (envelopes == null || envelopes.Length == 0) return 0;

            Array.Sort(envelopes, (a, b) => {
                if (a[0] == b[0])
                {
                    return b[1] - a[1];
                }
                else
                    return a[0] - b[0];
            });

            int n = envelopes.Length;
            int[] dp = new int[n];
            dp[0] = envelopes[0][1];
            int len = 1;

            for (int i = 0; i < n; i++)
            {
                if (envelopes[i][1] > dp[len - 1])
                {
                    dp[len] = envelopes[i][1];
                    len++;
                }
                else
                {
                    int bsIndex = binarySearch(dp, 0, len - 1, envelopes[i][1]);
                    dp[bsIndex] = envelopes[i][1];
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
                    return mid;

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
