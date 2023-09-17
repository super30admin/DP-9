Problem 1 Longest Increasing SubSequence
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        //dp
        //O(n^2)
        // int[] dp= new int[n];
        // Arrays.fill(dp, 1);
        // int res=1;
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[j]<nums[i]){
        //             dp[i]=Math.max(dp[i], dp[j]+1);
        //             res=Math.max(res, dp[i]);
        //         }
        //     }
        // }
        // return res;

        //Binary Search //O(nlogn) O(n)
        int[] arr= new int[n];
        int res=0;
        arr[0]=nums[0];
        int len=1;

        for(int i=1;i<n;i++){
            if(nums[i]>arr[len-1]){
                arr[len]=nums[i];
                len++;
            }else if(nums[i]<arr[len-1]){
                //replace number just greater than nums[i] in arr
                int bsIdx= binarySearch(arr, 0, len-1, nums[i]);
                arr[bsIdx]=nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] arr, int start, int end, int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}

Problem 2 Russian doll envelopes
// Time Complexity : O(2nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Sort 2d array based one any one parameter and if they are equal on other parameter.
//once you have one envelope, search for next big envelope that will fit in it.
class Solution {
    //O(nlogn+nlogn) //O(n)
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        int[] arr= new int[n];
        Arrays.sort(envelopes, (a,b)->{
            if(a[0]==b[0])
                return b[1]-a[1];
            return a[0]-b[0];
        });

        arr[0]=envelopes[0][1];
        int le=1;
        for(int i=1;i<n;i++){
            if(envelopes[i][1]>arr[le-1]){
                arr[le]=envelopes[i][1];
                le++;
            }else{
                int bsIndex=binarySearch(arr, 0, le-1, envelopes[i][1]);
                arr[bsIndex]=envelopes[i][1];
            }
        }
        return le;
    }
    private int binarySearch(int[] arr, int start, int end, int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}