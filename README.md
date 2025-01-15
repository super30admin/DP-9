# DP-9

## Problem1: Longest Increasing Subsequence (https://leetcode.com/problems/longest-increasing-subsequence/)
## Time complexity:O(nlogn) Space:O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
       int n=nums.length;
       int[] arr=new int[n]; 
       int len=1;
       arr[0]=nums[0];

       for(int i=1;i<n;i++)
       {
        if(nums[i]>arr[len-1])
        {
            arr[len]=nums[i];
            len++;
        }
        else{
            int bsIndex=binarySearch(arr,0,len-1,nums[i]);
            arr[bsIndex]=nums[i];
        }
       }

return len;
    }

    private int binarySearch(int[] arr,int low,int high,int target)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>target) high=mid-1;
            else low=mid+1;

        }
        return low;
    }
}

## Problem2: Russian Doll Envelopes (https://leetcode.com/problems/russian-doll-envelopes/)
## Time complexity:O(nlogn) space:O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
           if(a[0]==b[0]){
           return b[1]-a[1];
        }

        return a[0]-b[0];
        
    });
        int len=1;
        int n=envelopes.length;
        int[] arr=new int[n]; //LIS ON HEIGHT
        arr[0]=envelopes[0][1];

        for(int i=1;i<n;i++){
           if(envelopes[i][1]>arr[len-1]) 
           {
            arr[len]=envelopes[i][1];
            len++;
           }

           else{
            int bsIndex=binarySearch(arr,0,len-1,envelopes[i][1]);
            arr[bsIndex]=envelopes[i][1];
           }
        }

        return len;

    }

    private int binarySearch(int[] arr,int low,int high,int target)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>target) high=mid-1;
            else low=mid+1;

        }
        return low;
    }
}


