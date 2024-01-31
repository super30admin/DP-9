"""
Problem : 2

Time Complexity : 
Approach 1 - O(n^2)
Approach 2 - O(nlogn)

Space Complexity : 
Approach 1 - O(n)
Approach 2 - O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Approach - 1
# DP Array

class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        n=len(envelopes)
        newEnvelopes = sorted(envelopes, key=lambda x: (x[0], -x[1]))
        dp=[1 for _ in range(n)]
        result=1
        for i in range(1,n):
            for j in range(i):
                if newEnvelopes[i][1]>newEnvelopes[j][1]:
                    dp[i]=max(dp[i],dp[j]+1)
                    result=max(result,dp[i])
        return result
    

# Approach - 2
# Binary Search

class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        n=len(envelopes)
        envelopes = sorted(envelopes, key=lambda x: (x[0], -x[1]))
        arr=[]
        arr.append(envelopes[0][1])
        for i in range(1,n):
            if envelopes[i][1]>arr[-1]:
                arr.append(envelopes[i][1])
            else:
                binIdx=self.binarySearch(0,len(arr)-1,arr,envelopes[i][1])
                arr[binIdx]=envelopes[i][1]
        return len(arr)



    def binarySearch(self,low,high,arr,num):
        while low<=high:
            mid=low+(high-low)/2
            if arr[mid]==num:
                return mid
            elif arr[mid]>num:
                high=mid-1
            else:
                low=mid+1
        return low