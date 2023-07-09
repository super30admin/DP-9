// tc : O(nlogn)
// sc : O(1)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len =0,ind=0;
        for(int num : nums){
            ind = Arrays.binarySearch(nums,0,len,num);
            if(ind<0) ind = -ind-1;
            if(ind==len) len++;
            nums[ind] = num;
        }
        return len;
    }
}
