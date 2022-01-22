# Time:O(n*n)
# Space: O(n)
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = [1]*len(nums)
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    ans[i] = max(ans[i], ans[j]+1)
        #print(ans)
        return max(ans)
        

# Time:O(n*log(n))
# Space: O(n)
class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        seq = []
        seq.append(nums[0])
        for i in range(1, len(nums)):
            if nums[i] > seq[-1]:
                seq.append(nums[i])
            else:
                sorted_index = self.binary_search(seq, nums[i])
                seq[sorted_index] = nums[i]
        return len(seq)
    def binary_search(self, seq, val):
        left = 0
        right = len(seq) - 1
        while left <= right:
            middle = left + (right-left)/2
            if seq[middle] == val:
                return middle
            elif seq[middle] > val:
                right = middle-1
            else:
                left = middle + 1
        return left
        
        
