/*
 * Time Complexity: O(N)
 * SC = O(N)
 * 
 * Apporach : This is similar to longest increasing subsequence. We sort the inp array and check the longest 
 * increasing subsequence considering both width and height
 */

import java.util.*;
public class RussianDollEnvelopes {
    
    public static int maxEnv(int[][] envelopes)
    {
        if(envelopes == null || envelopes.length==0) return 0;

        Arrays.sort(envelopes,(a,b)-> a[0] - b[0]);
        int n  = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);


        // for(int i =0;i<envelopes.length;i++)
        // {
        //     for(int j =0;j<envelopes[0].length;j++)
        //     {
        //         System.out.print(envelopes[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        int max = 1;

        for(int i =1;i<n;i++)
        {
            for(int j = 0;j<i;j++)
            {
                if(envelopes[i][1]>envelopes[j][1] && envelopes[i][0]>envelopes[j][0])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }


        return max;
    }

    public static void main(String args[])
    {
        int[][] enve = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnv(enve));
    }
}
