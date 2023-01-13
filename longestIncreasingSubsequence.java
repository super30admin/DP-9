// Time Complexity : O(nlogn)
// Space Complexity :O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
       
        int n=nums.length;
        int[] dp=new int[nums.length];
        dp[0] = nums[0];
        int len=1;
        
        for(int i=1;i<n;i++){
            if(nums[i] > dp[len-1]){
                dp[len++] = nums[i];
            }else{
                int index=binSearch(dp, 0, len,nums[i]);
                dp[index] = nums[i];
            }
        }
        return len;
    }
    
    private int binSearch(int[] dp, int l, int h, int n){
        while(l<=h){
           int mid=l+(h-l)/2;
           if(n==dp[mid]){
               return mid;
           } else if(n<dp[mid]){
               h=mid-1;
           }else{
               l=mid+1;
           }
        }
        return l;
    }
}