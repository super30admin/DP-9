# // Time Complexity :O(n^2)/O(nlogn)
# // Space Complexity :O(n^2) momomap/ O(n) for res arr
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach


# dfs with memoisation 9908 ms T: O(n^2) S: O(n^2)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        self.memo= [[-99999]*n for _ in range(n)]           # memoMap        
        return self.helper(nums, 0, -1)

    def helper(self, nums, idx, prevIdx):
        
        #basecase
        if idx == len(nums):
            return 0
        if self.memo[idx][prevIdx] != -99999:
            return self.memo[idx][prevIdx]

        #logic
        
        case0 = self.helper(nums,idx +1, prevIdx)               
        
        case1 = 0
        if prevIdx == -1 or nums[idx] > nums[prevIdx]:
            case1 = 1 + self.helper(nums,idx+1,idx)

        self.memo[idx][prevIdx] = max(case0,case1)
        return self.memo[idx][prevIdx]


# binar search 11ms; T: O(nlogn) S: O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        res = []
        res.append(nums[0])
        length = 1
        # create a resultant array to keep maxsize of consequetive length
        for i in range(1,n):
            if nums[i] > res[length-1]:         # just add to res
                res.append(nums[i])
                length+=1
            else:                               # replace 
                bsIndex = self.binarySearch(res,0,length-1,nums[i])
                res[bsIndex] = nums[i]

        return length

    def binarySearch(self, arr,low,high, target):
        while low <= high:
            mid = low + (high-low)//2

            if arr[mid] ==target:
                return mid
            if arr[mid]> target:
                high = mid - 1
            else:
                low = mid + 1
        return low