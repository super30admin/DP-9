
//dp tc- O(n^2) sc- O(n)
//at location of ith dp we are keeping max len compare to all jth previous ele.
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         int result = 1;

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < i; j++){
//                 if(nums[i] > nums[j]){
//                 dp[i] = Math.max(dp[i], dp[j] + 1);
//                 result = Math.max(result, dp[i]);
//                 }
//             }
//         }

//         return result;

//     }
// }


//nlogn solution using bianry search, take affective array, keep adding with next greater ele and if found smaller,
//replace it with next greater ele in affective array

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int len = 1;

        for(int i = 1; i < n; i++){
            if(arr[len-1] < nums[i]){
                arr[len] = nums[i];
                len++;
            }else{
                int bsIndex = binarySearch(arr, 0, len-1, nums[i]);
                arr[bsIndex] = nums[i];//replacing with next bigger ele
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) high = mid -1;
            else low = mid + 1;
        }

        return low;
    }
}