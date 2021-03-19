class Solution:
    
    """
    Description: Find longest increasing subsequence in a given array:
    
    Time Complexity: O(n log n) for binary search and O(n^2) using a DP array
    Space Complexity: O(n)
    where, n is length of the given array
    
    Approach: using DP
    1. start a DP array with all values as 1 (longest subsequence to itself)
    2. for each element, check all the elements before that and see if the values are above each 
       - if the value is above then take the maximum of current value of dp array and maximum of the dp array with comparable index + 1
       - else do nothing (since value is smaller, it won't increase the subsequence)
    3. return the maximum value from the dp array (or, keep a max variable and increment it along with the loop)
    
    Approach: using Binary Search
    1. start with an empty array of equal size, start variables like first value of arr, and max length = 1
    2. iterate the given array starting from 2nd index (i.e. 1) 
       - if the value at an index is more than the last value in current array, then increase the lengh and replace the item in the empty array at same index
       - otherwise, use binary search to find item just above the current number, and replace it with (in hope of finding a better solution, with more length)
    3. return the length at the end
    """
    
    # DP Solution:
    def findLIS(self, nums):
        
        if nums == None: return  
        
        dp = [1]*len(nums)
        
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]: 
                    dp[i] = max(dp[i], 1 + dp[j])
                    
        return max(dp)      

    def lengthOfLIS(self, nums: List[int]) -> int:
        
        if nums == None: return  
        
        arr = [0]*len(nums); arr[0] = nums[0]
        length = 1
        
        for i in range(1, len(nums)):
            if nums[i] > arr[length - 1]:
                arr[length] = nums[i]
                length += 1
            else:
                idx = self.binSearch(arr, nums[i], 0, length)
                arr[idx] = nums[i]
                    
        return length
        
    def binSearch(self, arr, target, low, high):
        
        while low <= high:
            mid = low + int((high - low)/2)
            if arr[mid] == target: return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return low
    
      
