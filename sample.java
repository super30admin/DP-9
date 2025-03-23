// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Sample{
    /*******************PROBLEM-1********************/

//TC:0(n*n)
//SC:0(N)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }
            int n=nums.length,max=1;
            int[] dp=new int[n];
            Arrays.fill(dp,1);
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]>nums[j]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                        max=Math.max(max,dp[i]);
                    }

                }
            }
            return max;
        }
    }


    //TC:0(nlogn)
//SC:0(N)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }
            int n=nums.length,len=1;
            int[] result=new int[n];
            result[0]=nums[0];
            for(int i=1;i<n;i++){
                if(nums[i]>result[len-1]){
                    result[len]=nums[i];
                    len++;
                }else{
                    int bSearch=binarySearch(result,0,len-1,nums[i]);
                    result[bSearch]=nums[i];
                }
            }
            return len;
        }
        private int binarySearch(int[] nums,int low,int high,int target){

            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            return low;
        }
    }

    /*******************PROBLEM-2********************/
//TC:0(N LOG N)
//SC:0(N)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if(envelopes==null || envelopes.length==0){
                return 0;
            }
            int n=envelopes.length,len=1;
            int[] result=new int[n];

            Arrays.sort(envelopes,(a,b)->{
                if(a[0]==b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            });
            result[0]=envelopes[0][1];
            for(int i=1;i<n;i++){
                if(envelopes[i][1]>result[len-1]){
                    result[len]=envelopes[i][1];
                    len++;
                }else{
                    int bSearch=binarySearch(result,0,len-1,envelopes[i][1]);
                    result[bSearch]=envelopes[i][1];
                }
            }
            return len;
        }

        private int binarySearch(int[] nums,int low,int high,int target){
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            return low;
        }
    }
}
