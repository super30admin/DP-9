'''
Time Complexity: O(n^2) 
Space Complexity: O(n)  

Approach: 
1. Initialize a dp array of length n with all 1s.
2. Iterate through the nums array and for each element, iterate through the previous elements and if the previous element is less than the current element, update the dp array at the current index to be the maximum of the current dp value and 1 + the dp value at the previous index.
3. Return the maximum value in the dp array.
'''

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        dp = [1 for i in range(len(nums))]

        for i in range(len(nums)):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], 1 + dp[j])

        return max(dp)

'''
Time Complexity: O(nlogn) 
Space Complexity: O(n)  

Approach: 
1. Initialize a sub array with the first element of nums.
2. Iterate through the nums array and for each element, if it is greater than the last element in sub, append it to sub.
3. If it is less than or equal to the last element in sub, use binary search to find the index of the first element in sub that is greater than or equal to the current element. Replace the element at this index with the current element.
4. Return the length of sub.
'''
    

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:

        if not nums:
            return 0
        if len(nums) == 1:
            return 1

        sub = []
        sub.append(nums[0])

        for i in range(1, len(nums)):
            if nums[i] > sub[-1]:
                sub.append(nums[i])
            else:
                indexElementJustGreaterThani = bisect_left(sub, nums[i])
                sub[indexElementJustGreaterThani] = nums[i]

        return len(sub)