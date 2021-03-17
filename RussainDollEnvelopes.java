// Binary Search 
// TC: O(NlogN) -> worst case do binary serach N times
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
               return 0;
        Arrays.sort(envelopes, (a,b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
             return a[0] - b[0];
            });
        int len = 1;
        int[] arr = new int[envelopes.length];
        
        arr[0] = envelopes[0][1];
        
        for (int i = 1; i < arr.length; i++)
        {
                if (envelopes[i][1] > arr[len-1]  )
                {
                    arr[len] = envelopes[i][1];
                    len++;
                }
                else
                {
                     int index = closestBinarySearch(arr, 0, len, envelopes[i][1]);
                     arr[index] = envelopes[i][1];
                }
        }
     return len;
    }
    private int closestBinarySearch(int[] arr, int low, int high, int target)
    {
        while ( low <= high)
        {
            int mid = low + (high-low)/2;
            if ( arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
}




// DP 
// TC: O(N^2)
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         if (envelopes == null || envelopes.length == 0)
//             return 0;
//         int[] dp = new int[envelopes.length];
//         Arrays.fill(dp, 1);
//         Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
//         int result = 1;
        
//         for (int i = 1; i < dp.length; i++)
//         {
//             for ( int j = 0; j < i; j++)
//             {
//                 if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0])
//                 {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                     result = Math.max(result, dp[i]);
//                 }
//             }
//         }
//         return result;
        
//     }
// }
