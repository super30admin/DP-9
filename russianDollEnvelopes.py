# Approach: DP
# TC: O(n^2)
# SC: O(n)
# Gives Time Limit Exceed in the leetcode
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        # base
        if len(envelopes) == 1: return 1
        
        # sort the envelopes by ascending order of width and descending heights
        envelopes.sort(key= lambda x: [x[0], -x[1]])
        
        n = len(envelopes)
        dp = [1] * n
        maxi = 1
        e = envelopes # aliasing long name
        for i in range(1,n):
            for j in range(0,i):
                # if env at jth index is smaller than ith index
                # then you can russian doll it
                if e[j][0] < e[i][0] and e[j][1] < e[i][1]:
                    # then dp at current index i will be 1 + whatever we had upto jth index in the dp array
                    dp[i] = max(dp[i], dp[j]+1)
                    # also keep updating maxi as we want to return maximum number of envelopes we can russian doll
                    maxi = max(maxi, dp[i])
        return maxi


# Approach: Binary Search
# TC: O(n log(n))
# SC: O(n)
class Envelope:
    def __init__(self, width, height):
        self.width = width
        self.height = height
    
    def __lt__(self, other):
        # if width is equal, the taller height is prioritized
        if self.width == other.width:
            return self.height > other.height
        # else envelop with smaller width will come first in sorted order
        return self.width < other.width

    def __str__(self):
        return f"{self.width},{self.height}"
        
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        envelopes = [Envelope(w,h) for w,h in envelopes]
        envelopes.sort()
        
        # initialize 1d array with 0s eq to len of envelopes
        arr = [0]*n
        # set 0th env height to arr[0]th index
        arr[0] = envelopes[0].height
        length = 1
        e = envelopes # alias
        # iterate over rest of the envelope
        for i in range(1,n):
            # if envelope at ith index is taller than last env in arr
            if e[i].height > arr[length - 1]:
                # then add env at index length
                arr[length] = e[i].height
                length += 1
            else:
                # else find index in arr where we can insert the element
                bsIdx = self.binarySearch(arr, 0,  length - 1, e[i].height)
                arr[bsIdx] = e[i].height
        # print(arr)
        return length

    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high-low) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return low