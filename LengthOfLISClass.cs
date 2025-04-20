public class Solution {

    // TC => O(nlogn)
    // SC => O(n)
    public int LengthOfLIS(int[] nums) {
        if(nums == null || nums.Length == 0){
            return 0;
        }
        int n = nums.Length;
        int[] result = new int[n];
        result[0] = nums[0];
        int length = 1;
        for(int i = 0; i< n; i++){
            if(nums[i] > result[length - 1]){
                result[length] = nums[i];
                length++;
            }
            else{
                int bsIndex = BinarySearch(result, 0, length - 1, nums[i]);
                result[bsIndex] = nums[i];
            }
        }
        return length;
    }

    public int BinarySearch(int[] array, int start, int end, int target){
        while(start <= end){
            var mid = start + (end - start)/2;
            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] < target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return start;
    }


    // TC => O(n^2)
    // SC => O(n)
    // public int LengthOfLIS(int[] nums) {
    //     if(nums == null || nums.Length == 0){
    //         return 0;
    //     }
    //     int n = nums.Length;
    //     int[] dp = new int[n];
    //     Array.Fill(dp, 1);
    //     int max = 1;
    //     for(int i = 1; i < n; i++){
    //         for(int j = 0; j < i; j++){
    //             if(nums[i] > nums[j]){
    //                 dp[i] = Math.Max(dp[i], dp[j] + 1);
    //             }
    //         }
    //         max = Math.Max(max, dp[i]);
    //     }
    //     return max;
    // }
}