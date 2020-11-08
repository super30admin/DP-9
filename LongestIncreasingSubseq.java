import java.util.Arrays;

//TC: O(n2)
//SC: O(n)

public class LongestIncreasingSubseq {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int right = nums.length-1;
        int[] arr = new int[right+1];
        Arrays.fill(arr, 1);
        int res=1, max=1;
        for(int i=0; i<nums.length; i++){
            max = 0;
            for(int j=0; j<i; j++){
                // getting max by comparing all the elements starting from 0 until the current element
                if(nums[i] > nums[j]){
                    max = Math.max(max, arr[j]);
                }
                // adding one to the the prev max obtained 
                arr[i] = max+1;
                // keeping track of the max value
                res = Math.max(res, arr[i]);
            }
        }
        
//         right = 0;
//         for(int i=1; i<nums.length; i++){
//             if(nums[right] <= nums[i]){
//                 arr[right] = 0;
//             }
//             right++;
//         }
        
        return res;
    }
}
