import java.util.Arrays;

// Time Complexity :O(logn + n^2)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * Approach - DP
 * This gives us a TLE. We should be doing this using BS approach
 * Same approach as longest subsequence.
 */

public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->a[1] -b[1]);
        int n = envelopes.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        
        for(int i=1; i < n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(envelopes[i][0] > envelopes[j][0]
                  && envelopes[i][1] > envelopes[j][1])
                {
                    dp[i] = Math.max(1+dp[j], dp[i]);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}

//Binary Search Solution where custom comparator is important
//Time Complexity - O(nlogn)
//Space Complexity - O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        
        int n = envelopes.length;
        int len = 1;
        
        int[] arr = new int[n];
        arr[0] = envelopes[0][0];
        
        for(int i = 1; i<n; i++)
        {
            if(envelopes[i][0] > arr[len-1])
            {
                arr[len] = envelopes[i][0];
                len++;
            }
            else
            {
                int bsInd = binarySearch(0,len-1,arr,envelopes[i][0]);
                arr[bsInd] = envelopes[i][0];
            }
        }
        return len;
    }
    
    private int binarySearch(int low, int high, int[] arr, int target)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
}