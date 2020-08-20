# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Method1 using DP:
# TC = O(n^2) | Sc= O(n)
class Solution:
    def maxEnvelopes(self, en: List[List[int]]) -> int:
        if len(en) == 0:
            return 0
        dp = [1 for _ in range(len(en))]
        max_ = 1 
        en = sorted(en, key = lambda x : (x[0],x[1]))
        
        for i in range(1, len(dp)):
            for j in range(0, i):
                if en[i][1] > en[j][1] and en[i][0] != en[j][0]:
                    dp[i] = max(dp[i], dp[j] + 1 )
        
        for num in dp:
            if num > max_:
                max_ = num
        return max_


# Method 2 using Binary Search
# Tc = O(nlogn) | Sc = O(n)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if len(envelopes) == 0 :
            return 0 
        
        envelopes = sorted(envelopes, key = lambda x : (x[0], -x[1]))
        print(envelopes)
        arr = [1 for _ in range(len(envelopes))]
        len_ = 1 
        arr[0] = envelopes[0]
        
        for i in range(1, len(envelopes)):
            if envelopes[i][1] > arr[len_ -1][1] and envelopes[i][0] != arr[len_ -1][0]:
                len_ += 1 
                arr[len_ - 1] = envelopes[i]
            else:
                indx = self.binarySearch(arr, 0, len_ -1, envelopes[i])
                arr[indx] = envelopes[i]
        print(arr)
        return len_
    
    def binarySearch(self, nums, low, high, target):
        while low <= high:
            mid = (low+high)//2
            
            if nums[mid] == target:
                return mid 
            
            elif nums[mid][1] < target[1] and nums[mid][0] != target[0]:
                low = mid + 1 
            
            else:
                high = mid -1 
        
        return low 