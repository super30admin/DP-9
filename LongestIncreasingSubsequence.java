import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLISDP(int[] nums) {
        //dp solution
        //Time Complexity : O(N2)
        //Space Complexity: O(N)
         int dp[] = new int[nums.length];
         Arrays.fill(dp, 1);
         int maxLength = 1;

         for(int i = 1; i< dp.length; i++){
             for(int j = i-1; j >=0 ; j--){
                 if(nums[i]> nums[j]){
                     dp[i] = Math.max(dp[i], dp[j] + 1);
                     maxLength = Math.max(maxLength, dp[i]);
                 }
             }

         }

         return maxLength;
    }

    public int lengthOfLISBinarySearch(int[] nums) {
        //Time Complexity : O(NLogN)
        //Space Complexity: O(N)

        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int idx = 1;
        for(int i = 1; i< nums.length; i++){
            if(arr[idx-1] < nums[i]){
                arr[idx] = nums[i];
                idx++;
            }
            else{
                int index = binarySearch(arr, 0, idx - 1, nums[i]);
                arr[index] = nums[i];
            }
        }
        return idx;

    }

    private int binarySearch(int[] arr, int begin, int end, int target){
        while(begin <= end){
            int mid = (begin+(end))/2;
            if(target == arr[mid]) return mid;
            if(target > arr[mid])begin = mid +1;
            else end = mid -1;
        }

        return begin;
    }

}
