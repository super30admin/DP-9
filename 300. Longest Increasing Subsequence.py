#approach 1
#time: O(nlog(n))
#space: O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        # creating a subsequence starting with first element
        sub= [nums[0]]

        # iterate the array
        for i in range(1, len(nums)):

            # if element in array is bigger than the last element, append it
            if nums[i] > sub[-1]:
                sub.append(nums[i])
            # else bs to find the next biggest element and then replace it
            else:
                bsindex= self.binarysearch(sub,0, len(sub), nums[i])
                sub[bsindex]= nums[i]

        return len(sub)

        
        #code for binary search
    def binarysearch(self, arr,low,high, target):
        while low <= high:
            mid= low + int((high-low)/2)

            if arr[mid] == target:
                return mid
            elif arr[mid]< target:
                low= mid+1
            else:
                high= mid-1
        return low   

#approach using dp array of 1s and comparing i and j pointer based looping to compare elements
#space: O(n)
#time: O(n*n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n= len(nums)
        dp=[1]* n
        mx=1
        for i in range(n):
            for j in range(i):
                if nums[i]> nums[j]:
                    dp[i]=max(dp[i], dp[j]+1)
            mx= max(mx,dp[i])
        
        return mx
