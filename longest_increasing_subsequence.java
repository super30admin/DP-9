//TC:O(n)
//SC:O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int result=1;
        int []arr=new int[nums.length];
        arr[0]=nums[0];
        int le=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>arr[le-1])
            {
               arr[le]=nums[i];
               le++;
            }
            else
            {
                int idx=binary(arr,0,le,nums[i]);
                arr[idx]=nums[i];
            }
        }
        return le;
    }
    private int binary(int [] arr, int s, int e, int target)
    {
        while(s<=e)
        {
          int mid=s+(e-s)/2;
          if(arr[mid]==target)
          return mid;
          else if(arr[mid]<target)
          {
            s=mid+1;

          }
          else
          {
            e=mid-1;
          }
          
        }
        return s;
    }
}