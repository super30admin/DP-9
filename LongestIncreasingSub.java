//TC will be O(n log n)
//SC will be O(n)

class LongestIncreasingSub {
    public int lengthOfLIS(int[] nums) {
        if(nums== null || nums.length==0){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++){
            if(nums[i]> dp[len -1]){
                dp[len] = nums[i];
                len++;
            }
            else{
                int bsIndex = binarySearch(dp, 0, len -1, nums[i]);
                dp[bsIndex] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target < nums[mid]){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args){
        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSub obj = new LongestIncreasingSub();

        System.out.println(obj.lengthOfLIS(nums));
    }
}