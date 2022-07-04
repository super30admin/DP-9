//time - O(nlogn), space - O(n)
class Solution {
    public int maxEnvelopes(int[][] nums) {
        if(nums==null || nums.length==0) return 0;

        int n = nums.length;

        Arrays.sort(nums, (a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            else return a[0] - b[0];
        });

        int[] dp = new int[n];
        int len = 1;
        dp[0] = nums[0][1];

        for(int i=1; i<n; i++){
            if(dp[len-1] < nums[i][1]){
                dp[len] = nums[i][1];
                len++;
            }
            else{
                int bsIndex = binarySearch(dp, 0, len-1, nums[i][1]);
                dp[bsIndex] = nums[i][1];
            }
        }

        return len;

    }

    private int binarySearch(int[] dp, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(dp[mid]==target) return mid;
            else if(dp[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
