//O(NlogN) time
//O(N) space

class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];

        int max = 1;
        arr[0] = nums[0];
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>arr[index])
                arr[++index] = nums[i];
            else
                arr[bs(arr, index, nums[i])] = nums[i];
        }
        return index+1;
    }

    public int bs(int arr[], int high, int target){
        int low = 0;
        int mid;
        while(low<high){
            mid = low + (high - low)/2;

            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}