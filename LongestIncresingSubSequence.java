//TC : O(n*logn)-- Sorting pairs in log(n) time .
//SC : O(n) // using 1D array

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        
        int l = 1;
        
        for(int i = 1; i< nums.length; i++){
            if(nums[i] > result[l-1]){   // If incoming element is larger than most recently added element in Sequence
                result[l] = nums[i];
                l++;
            } else{
                int index = effectiveBinarySearch(result, 0, l-1, nums[i]);
                result[index] = nums[i];
            }
        }
        return l;
    }
    public int effectiveBinarySearch(int[] array, int l, int h, int target){
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if(array[mid] == target)    return mid;
            else if(array[mid] <= target)   l = mid + 1;
            else h = mid - 1;
        }
        
        return l; // index where target should be stored
    }
}

/*

//TC : O(N^2)
//SC : O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        
        Arrays.fill(result, 1);
        
        int max = 1;
        
        for(int i = 1; i< nums.length; i++){
            for(int j = 0; j< i; j++){
                if(nums[i] > nums[j]){
                    result[i] = Math.max(result[i], result[j] + 1);
                    max = Math.max(result[i], max);
                }
            }
        }
        
        return max;
    }
}

*/


