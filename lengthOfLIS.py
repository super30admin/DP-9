class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1]*len(nums)
    
        for i in range(1,len(nums)):
            for j in range(i):
                if nums[j]<nums[i]:
                    dp[i] = max(dp[i], 1+dp[j])
 
        return max(dp)
                
Time : O(N^2) 
Space : O(N)

    
class Solution:
def lengthOfLIS(self, nums: List[int]) -> int:
    arr = [nums[0]]
    length = 1
    for i in range(1,len(nums)):
        if nums[i]>arr[-1]:
            arr.append(nums[i])
            length+=1
        else:
            index = self.binaryLeft(nums[i], arr)
            arr[index] = nums[i]

    return length

def binaryLeft(self, target, arr):
    left, right = 0, len(arr)-1

    while left<=right:
        mid = left+(right-left)//2
        value = arr[mid]

        if value == target:
            return mid
        elif value<target:
            left = mid+1
        else:
            right = mid-1
    return left
            
Tim: O(NlogN)
Space: O(L)
        
        
