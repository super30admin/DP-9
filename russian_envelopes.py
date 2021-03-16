# Appproach - Use DP approach similar to LIS problem
# key - sort one dimension only
# Time Complexity - O(N^2) - TLE did not run on leetocde
# Space - O(N)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if not envelopes or len(envelopes) == 0:
            return 0
        
        # sort array with one dimension (sorted)
        envelopes.sort(key = lambda x: (x[0], x[1]))
        
        dp = [1] * len(envelopes)
        max_len = 1
        
        for i in range(1, len(envelopes)):
            for j in range(0, i):
                if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]: # both have to be true in order to fit the dolls
                    dp[i] = max(dp[i], dp[j] + 1)
                    max_len = max(max_len, dp[i])
                    
        return max_len


# Binary Search Approach
# Time - O( N log N)
# Space - O(N)

# Sort the envelopes based on increasing width and decreasing heights as this will avoid putting 2 enevlopes with same width in the LIS as they wont be considered valid

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        if not envelopes or len(envelopes) == 0:
            return 0
        
        envelopes.sort(key = lambda x:(x[0], -x[1]))
        
        arr = [envelopes[0][1]]
        seq_len = 1
        
        for i in range(1, len(envelopes)):
            if envelopes[i][1] > arr[-1]:
                arr.append(envelopes[i][1])
                seq_len += 1
                
            else:
                
                binary_idx = self.binarySearch(arr, envelopes[i][1], 0, len(arr))
                
                arr[binary_idx] = envelopes[i][1]
                
        return seq_len
    
    
    
    def binarySearch(self, arr, target, low, high):
        
        while low <= high:
            
            midd = low + (high - low) // 2
            
            if arr[midd] == target:
                return midd
            
            elif arr[midd] > target:
                high = midd - 1
                
            else:
                low = midd + 1
                
        return low
            
        

        
        
        