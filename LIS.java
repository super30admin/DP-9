//Time : O(n*n)
//Space : O(n)

//Approach:
//1.The min longest subsequence can be 1 , so fill a new array with all 1's,where result[i] represents longest increasing subsequence
// length till that element.
//2.Start from second element , have another pointer low at starting element.If current element is greater than element at low,
//  then an increasing subsequence is found. So update result[current] as maximum of result[current] or length of LIS at result[low]+1 (as we are including element at low).
//3.Do this till low pointer reaches current pointer. Do this for all elements in array.Return the max value fro result array.
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)    return 0;
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        int max = 1;
       
        for(int j = 1;j<result.length;j++){
             //STORE MAX LENGTH TILL EACH ELEMENT
            for(int i = 0;i<j;i++){
                if(nums[j]>nums[i])
                    result[j] = Math.max(result[j],result[i]+1);
            }
            max = Math.max(max,result[j]);
        }
        return max;
    }
}
