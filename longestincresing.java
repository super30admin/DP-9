// TC =O(nlogn)
// SC = O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int len = 0;
        
        for (int num : nums) {
            int index = Arrays.binarySearch(lis, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            lis[index] = num;
            if (index == len) {
                len++;
            }
        }
        
        return len;
    }
}