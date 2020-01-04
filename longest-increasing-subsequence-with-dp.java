/*


Did it run on leetcode: yes
Did you face any problem: Why its a dp problem, and what is the overlapping pattern.

Time Complexity: 0(N2)
Space Compelxity: 0(N)

Algorithm:
- for every element at index i in nums,
we try to find the maxSubSeq till i-1 and update our dp array.
- our decison is totally based on whether we want to include the element or not.


- I tried tp modify the solution a bit, to print elements as well.
*/



class Solution {
    public int lengthOfLIS(int[] nums) {
    
        if(nums.length==0){
            return 0;
        }
        
       int[] dp = new int[nums.length];
       Arrays.fill(dp,1); 
       
       int[] solution = new int[nums.length];
        for(int i=0;i<nums.length;++i){
            solution[i] = i;
        }
        
       int retVal = 1;
       
        for(int i=1;i<nums.length;++i){
            
            int maxSubSeq = 0;
            for(int j=0;j<i;++j){
                if(nums[i]>nums[j]){
                    if(dp[j]>maxSubSeq){
                        solution[i]=j;
                    }
                    maxSubSeq= Math.max(maxSubSeq,dp[j]);
                }
            }
            
            dp[i] = dp[i]+maxSubSeq;
            retVal = Math.max(retVal,dp[i]);
        }
        
        System.out.println("----Print start dp array-----:");
        for(int l:dp){
            System.out.print(l+",");
        }
         System.out.println("----Print done dp array-----:");
        
        int maxIndex = -1;
        for(int k=0;k<nums.length;++k){
            if(dp[k]==retVal){
                maxIndex=k;break;
            }
        }
        printLISelements(solution,maxIndex,nums);
        return retVal;
        
    }
    
    
    private void printLISelements(int[] solution,int maxIndex,int[] nums){
        
        System.out.println("maxIndex:"+maxIndex);
        System.out.println("----Print start solution-----:");
        for(int l:solution){
            System.out.print(l+",");
        }
         System.out.println("----Print done solution-----:");
        
        int idx=maxIndex,newIdx = maxIndex;
        do{
            
            idx = newIdx;
            System.out.print(nums[idx] + " ");
            newIdx = solution[idx];
            
        }while(idx!=newIdx);
        
    }
}