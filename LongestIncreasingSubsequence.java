/**
TC- O(nlogn)
SC - O(n)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ar = new int[n];
        ar[0] = nums[0];
        int le =1;
        for(int i=1;i<n;i++){
            if(nums[i]>ar[le-1]){
                ar[le]= nums[i];
                le++;
            }
            else{
                int bsIndx = binarySearch(ar, 0, le-1, nums[i]);
                ar[bsIndx] = nums[i];
            }
        }
        return le;
        
    }
    private int binarySearch(int[] ar,int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target == ar[mid]){
                return mid;
            }
            else if(target>ar[mid]){
                low = mid+1;
            }
            else high = mid-1;
        }
        return low;

    }
}
