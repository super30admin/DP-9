class Solution:
    #Approach 1:  DP
    """
    TC: O(n^2) n-> len(nums)
    SC: O(n)
    """
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1]*n
        result = 1
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j]+1)
                    result = max(result, dp[i])
        return result
    
    # Approach 2: Binary search with effective subsequence
    """
    Use the length of an effective subsequence list to track the result
    1) start from the beginning of the list and compare consequtive elements
    2) if the current element in less than the next one, append to the effective list
    3) else, substitute the next element with its next larger number in the effective list
        a) this would enusre that the resultant list would be longer in case you encounter nums greater than the substitute but lesser than the replaced number
    
    TC: O(n log n) n -> len of nums
    SC: O(n)
    """
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        effective = [nums[0]]
        for i in range(1,n):
            if nums[i] > effective[-1]:
                effective.append(nums[i])
            else:
                replacable_index = self.binary_search(effective, 0, len(effective)-1, nums[i])
                if replacable_index < len(effective):
                    effective[replacable_index] = nums[i]
                else:
                    effective.append(nums[i])
        return len(effective)
    
    def binary_search(self, nums, start, end, target):
        while start <= end:
            mid = start + (end - start)//2
            if nums[mid] == target: return mid
            elif nums[mid] > target:
                end = mid - 1
            else: start = mid + 1
        return start
                
        