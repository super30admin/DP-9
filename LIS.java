public class LIS{
    //o(nlogn) o(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        arr[0] = nums[0];
        int len = 1 ; //len of array
        for(int i =1; i < n; i++){
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            }else{
                //replace 
                int bsIdx = binarySearch(arr, 0, len-1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return len;
    }

    public int binarySearch(int[] nums, int lo, int hi, int target){
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                return mid;
            } 
            if(nums[mid] > target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return lo; //for just greater element 
    }

    //without memo - o(2^n)
    //memo - o(n^2)
    // int[][] memo;
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     memo = new int[n][n]; 
    //     for(int i = 0; i < n; i++){
    //         Arrays.fill(memo[i], Integer.MIN_VALUE); 
    //     }
    //     return helper(nums, 0, -1);
    // }

    // public int helper(int nums[], int idx, int prev){
    //     //base 
    //     if(idx == nums.length) return 0;
    //     if(memo[idx][prev+1] != Integer.MIN_VALUE){
    //         return memo[idx][prev+1];
    //     }

    //     //logic 
    //     //no chooose 
    //     int case0 = helper(nums, idx+1, prev);
    //     //chose 
    //     int case1 = 0;
    //     if(prev == -1 || nums[idx] > nums[prev]){
    //         case1 = 1+ helper(nums, idx+1, idx);
    //     }
    //     memo[idx][prev+1] = Math.max(case0, case1);
    //     return memo[idx][prev+1];
    // }
}