#Time Complexity:O(nlogn)
#Space Complexity:O(n)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if not envelopes:
            return 0
        envelopes = sorted(envelopes, key = lambda x: (x[0], -x[1]))    #sort the envelopes based on first index of each envelope
        dp=[None]*len(envelopes)                                        #declare a dp array that holds tha envelopes
        dp[0]=envelopes[0][1]                                           #start with the first envelope
        maxEnv=1                                                        #increment the number of envelopes possible
        for i in range(1,len(envelopes)):                               #if second index of current element is greater than second index of last dp element
            if envelopes[i][1]>dp[maxEnv-1]:                            #append the element to the dp and increment the maxenv
                dp[maxEnv]=envelopes[i][1]
                maxEnv+=1
            else:
                bsIdx=self.binarySearch(dp,envelopes[i][1],0,maxEnv)    #else find current element position in dp array through binary search 
                dp[bsIdx]=envelopes[i][1]
        return maxEnv

    def binarySearch(self,dp:List[int],target:int,low:int,high:int)->int:
        while(low<=high):
            mid=low+(high-low)//2
            if dp[mid]==target:
                return mid
            elif dp[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return low