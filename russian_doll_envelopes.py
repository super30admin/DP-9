class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        ## T.C = O(n.logn)
        ## S.C = O(n)
        from functools import cmp_to_key

        def comparator(a, b):
            if a[0] < b[0]:
                return -1
            elif a[0] > b[0]:
                return 1
            elif a[1] > b[1]:
                return -1
            elif a[1] < b[1]:
                return 1
            return 0

        def binary_search(nums, target, low, high):
            while low <= high:
                mid = (low+high) // 2
                if nums[mid] == target:
                    return mid
                elif nums[mid] > target:
                    high = mid - 1
                elif nums[mid] < target:
                    low = mid + 1
            return low

        data = sorted(envelopes, key = cmp_to_key(comparator))

        dp = [data[0][1]]
        for i in range(1, len(data)):
            if(data[i][1] > dp[-1]):
                dp.append(data[i][1])
            else:
                idx = binary_search(dp, data[i][1], 0, len(dp)-1)
                dp[idx] = data[i][1] 
      
        return len(dp)
