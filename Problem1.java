// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem1 {
    int [][] dp ;
    public int lengthOfLIS(int[] nums) {
        //return tabulation(nums);
        //return lseAlgo(nums);
        int n = nums.length;
        this.dp = new int[n][n+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        return dpMemoization(nums,0,-1);
    }


    //TC:O(N^2)
    //SC:O(N^2)
    //recursive approach
    public int dpMemoization(int[] nums,int currIdx , int prevIdx) {
        int n = nums.length;

        //base condition
        if(currIdx == n) return 0;

        if(dp[currIdx][prevIdx+1] != Integer.MIN_VALUE){
            return dp[currIdx][prevIdx+1];
        }
        //logic
        int chose = 0;
        if(prevIdx == -1 || nums[currIdx] > nums[prevIdx]){
            chose = 1+  dpMemoization(nums,currIdx+1,currIdx);
        }
        int noChose = dpMemoization(nums,currIdx+1,prevIdx);



        int max = Math.max(chose,noChose);
        dp[currIdx][prevIdx+1] = max;

        return max;
    }

    //TC:O(N^2)
    //SC:O(N)
    public int tabulation(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }

        return max;
    }

    //TC:O(NlogN)
    //SC:O(N)
    public int lseAlgo(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n];
        Arrays.fill(arr,Integer.MIN_VALUE);
        arr[0] = nums[0];
        int len = 1;
        for(int i=1;i<n;i++){
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            }else{
                int idx = binarySearch(arr,0,len-1,nums[i]);
                arr[idx] = nums[i];
            }
        }

        return len;
    }
    //TC:O(Logn)
    private int binarySearch(int[] arr,int l , int h,int target){

        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]<target){
                l=mid+1;
            }else{
                h=mid-1;
            }

        }
        return l;
    }
}

