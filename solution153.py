#Time Complexity:O(n^2)
#Space Complexity:O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        dp=[1]*len(nums)                        #Create a dp array the same size as input with value 1
        LSbSq=1                                 #maintain the current longest subsequence
        for i in range(1,len(dp)):                #parse through the nums array
            for j in range(i+1):                #compare every element with all its previous elements
                if nums[i]>nums[j]:             #if current element is greater than any previous element
                    dp[i]=max(dp[i],dp[j]+1)    #append in dp array's current position the maximum between previous element plus one and current value
            LSbSq=max(LSbSq,dp[i])              #update longest subsequence for every position
        return LSbSq                 

#Time Complexity:O(nlogn)
#Space Complexity:O(n)
#Approach:Binary search to find longest substring.
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        dp=[None]*len(nums)                                     #use dp array to save the longest subsequence
        maxLen=0                                                #use a variable that holds the longest subsequence 
        dp[0]=nums[0]                                           #place first element in first index of dp and increment length by one.
        maxLen+=1
        for i in range(1,len(dp)):                              #parse through the nums array
            if nums[i]>dp[maxLen-1]:                            #if curr number id greater than last number in dp, add it to dp and increment length
                dp[maxLen]=nums[i]
                maxLen+=1
            else:                                               #else use binary search to find apt position for current number and place it in dp
                bsIdx=self.binarySearch(dp,nums[i],0,maxLen-1)
                dp[bsIdx]=nums[i]
        return maxLen                                           #return maxLen
    
    def binarySearch(self,dp:List[int],target:int,low:int,high:int)->int: #binary search to find position of new number in dp array
        while(low<=high):
            mid=low+(high-low)//2
            if dp[mid]==target:
                return mid
            elif dp[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return low