package DP-9;
// TC: O(n*logn)
// SC: O(n)
public class Problem1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] effArr = new int[n];
        effArr[0]=nums[0];
        int len = 1;

        for(int i=1;i<n;i++){
            if(nums[i]>effArr[len-1]){
                effArr[len] = nums[i];
                len++;
            }else{
                int bsIndex = nextLarger(effArr, 0, len-1, nums[i]);
                effArr[bsIndex] = nums[i];
            }
        }

        return len;
       
    }

    private int nextLarger(int[] arr, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) high=mid-1;
            else low = mid+1;
        }

        return low;
    }
}
