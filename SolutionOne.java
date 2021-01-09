// Time Complexity : O(n log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nopes

class SolutionOne {
    public int lengthOfLIS(int[] nums) {

        if(nums==null||nums.length==0)
            return 0;

        int[] arr = new int[nums.length];



         /* Arrays.fill(dp,1);

        int max = 1;

      for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    dp[i] = Math.max( dp[i] ,dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
        }*/

        int len=0;

        arr[0] = nums[0];
        len++;

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>arr[len-1])
            {
                arr[len] = nums[i];
                len++;
            }
            else
            {
                int bIndex= binarySearch(arr,0,len-1,nums[i]);
                arr[bIndex] = nums[i];
            }
        }


        return len;
    }
    private int binarySearch(int[] nums,int low,int high,int target)
    {
        while(low<=high)
        {
            int mid  = low + (high-low)/2;

            if(nums[mid] == target)
            {
                System.out.println("returning mid:"+mid);
                return mid;
            }
            else if(nums[mid]>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }

        }
        System.out.println("returning low:"+low);
        return low;
    }
}


