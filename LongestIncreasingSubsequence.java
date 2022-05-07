// Time Complexity : O(n log n) where n is the length of the num array
// Space Complexity : O(n) for sequence list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create sequence of incresing nums and store in list
// Whenever we see an element with value less than the last of the sequence
// We will perform binary search and find its correct position and place it there
// Otherwise we will just at it to the last of the list.
// At the end we will have the seq size which would be the LIS
// We will return the list size.
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > seq.get(seq.size() - 1)){
                seq.add(nums[i]);
            }
            else{
                int index = getIndex(seq, nums[i]);
                seq.set(index, nums[i]);
            }
        }
        return seq.size();
    }
    private int getIndex(List<Integer> seq, int num){
        int s = 0, e = seq.size()-1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(seq.get(mid) == num){
                return mid;
            }
            else if(num < seq.get(mid)){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return s;
    }
}