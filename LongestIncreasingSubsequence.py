# Time Complexity : O(n^2)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Dp approach : TC = O(n^2) | SC = O(n)
# class Solution:
#     def lengthOfLIS(self, nums):
#         if len(nums) == 0:
#             return 0 
#         dp = [1 for _ in range(len(nums))]
#         max_ = 1 
#         for i in range(1,len(dp)):
#             for j in range(0, i):
#                 if nums[i] > nums[j]:
#                     dp[i] = max(dp[i], dp[j]+1)
#                     max_ = max(max_, dp[i])
        
#         return max_ 
    
# Method 2 using binary search and keeping an array which hold only the increasing numbers.
#          We keep a variable called 'len' to keep track of the increasing subarray inside our arr. 
# TC = O()
class Solution:
    def lengthOfLIS(self, nums):
        if len(nums) == 0:
            return 0 
        arr = [0 for _ in range(len(nums))]
        len_ = 0 
        arr[len_] = nums[0]
        len_ += 1 
        
        for i in range(1, len(nums)):
            if nums[i] > arr[len_ - 1]:
                len_ += 1 
                arr[len_ - 1] = nums[i]

            else:
                indx = self.binarySearch(arr, 0 , len_ -1, nums[i])
                arr[indx] = nums[i]
        print(arr)
        return len_ 
                
     
    def binarySearch(self, nums, low, high ,target):
        while low <= high:
            
            mid = (low+high) // 2 
            
            if nums[mid] == target:
                return mid 
            elif target > nums[mid]:
                low = mid + 1 
            
            else:
                high = mid - 1 
        
        return low 

if __name__ == "__main__":
    s = Solution()
    
    # Test Case 1 
    # res = s.lengthOfLIS([10,9,2,5,3,7,101,18])
    res = s.lengthOfLIS([5,4,3,2,1])
    print(res)