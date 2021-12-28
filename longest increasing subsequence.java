//Time complexity:- O(nm) where m is the maximum that inner pointer can travel.
//space complexity:- O(n).

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[]dp=new int[nums.length];
        int output=0;
        Arrays.fill(dp,1);//intially dp array is filled with 1
        for(int i=1;i<nums.length;i++){
            int maxlen=0;
            for(int j=0;j<=i;j++){
                if(nums[j]<nums[i]){
                    maxlen=Math.max(maxlen,dp[j]);// taking two pointers one after other but one pointer will be from index 1 and other pointer will be from index0 ti index of outer pointer. in this iteration if any value is less than nums[i] ,this is one possibility like that finding max of all posibilities and updating dp array.
                }
                
            }
            dp[i]=1+maxlen;
        }
        for(int i=0;i<dp.length;i++){
           output=Math.max(dp[i],output) ;
        }
        return output; //in dp array retrieving max of all elements.
    }
}