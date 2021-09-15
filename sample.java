// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int length = 1;
        //System.out.println(Arrays.toString(arr));
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > arr[length - 1]) {
                arr[length++] = nums[i];
            } else {
                int bIndex = binarySearch(arr,nums[i],0,length-1); 
                arr[bIndex] = nums[i];
            }
            //System.out.println(Arrays.toString(arr));
        }
        
        return length;
    }
    private int binarySearch(int[] arr,int target,int low,int high) {
        while(low <= high) {
            int mid = low + (high - low) /2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length ==0) {
            return 0;
        }
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int max = 1;
        Arrays.sort(envelopes, (a,b) -> a[0] - b[0]);
        
        for(int i = 1 ; i < envelopes.length;i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}