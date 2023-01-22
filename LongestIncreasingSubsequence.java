public class LongestIncreasingSubsequence {

    //TIme Optimized

    // TC - O(nlogn) SC O(n)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len =1;

        for(int i = 1;i<n;i++){
            if(nums[i]>dp[len-1]){
                dp[len] = nums[i];
                len++;
            }
            else{
                int index = binarySearch(dp, 0, len-1, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] dp, int low, int high, int target){

        while(low<=high){
            int mid = low+ (high-low)/2;
            if(dp[mid]==target) return mid;
            else if (target>dp[mid]) low=mid+1;
            else high = mid-1;


        }
        return low;
    }



    // TC - O(n^2) SC O(n)
    /*  public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max =1;
        for(int i = 1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) {
                    dp[i] = Math.max(dp[i],1+dp[j]);
                    max = Math.max(max, dp[i]);
                }

            }
        }
        return max;
    }*/
}
