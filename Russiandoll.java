// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Code with binary search

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0) return 0;
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0])
            {
                return b[1]-a[1];
            }
            else
            {
                return a[0]-b[0];
            }
        });
        int m = envelopes.length;
        int len =0;
        int [] dp = new int[m];
        dp[len++] = envelopes[0][1];
        for(int i = 1;i <m;i++)
        {
            if(envelopes[i][1]>dp[len-1])
            {
                dp[len++]= envelopes[i][1];
            }
            else
            {
                int index = BinarySearch(dp,0, len-1,envelopes[i][1]);
                dp[index]=envelopes[i][1];
            }
        }
        return len;
        
        
    }
    private int BinarySearch(int[] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = (high-low)/2 + low;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}

