// Brute Force
// Time: O(n^2)
// Space: O(n)
// class Solution {
//     public int lengthOfLIS(int[] A) {
//         if(A == null || A.length == 0)return 0;
//         int[] arr = new int[A.length];
//         Arrays.fill(arr,1);

//         int max = 1;
//         for(int i=1;i<arr.length;i++){
//             for(int j=0;j<=i;j++){
//                 if(A[i]>A[j])
//                     arr[i] = Math.max(arr[j]+1,arr[i]);
//             }
//             max = Math.max(max,arr[i]);
//         }
//         return max;
//     }
// }

/***
 Intuition: Binary Search on the sorted arr
 Time: O(nlogn)
 Space: O(n)
 **/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length==0) return 0;

        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int len = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > arr[len-1])
                arr[len++] = nums[i];
            else {
                int idx = binarysearch(arr,0,len,nums[i]);
                arr[idx] = nums[i];
            }

        }

        return len;

    }
    private int binarysearch(int[] arr, int l, int h,int target){
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target)
                h = mid-1;
            else
                l = mid+1;
        }
        return l;
    }
}