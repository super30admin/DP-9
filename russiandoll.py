# Sort the array (envelopes) in the increasing order of width and then height.
# Keep two pointers i which traverses the envelopes array.
# another pointer j which traverses the array from 0 till i-1.
# if the width and height of jth envelope is less than the width and height of the ith envelope. dp[i] = dp[j]+1.
# Time complexity - O(n logn) -- sorting the array + O(n) for finding russian dolls longest seq.
# Space complexity - O(n)
# Did this solution run on leetcode? - no (TLE)

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        if n==0: return 0
        
        dp = [1] * n
        # sort the envelopes
        envelopes.sort(key = lambda x:(x[0], x[1]))
        maxenvelope_seq = 1
        
        for i in range(n):
            for j in range(i):
                if envelopes[j][0] < envelopes[i][0] and envelopes[j][1] < envelopes[i][1]:
                    dp[i] = max(dp[i], dp[j]+1)
                    maxenvelope_seq = max(maxenvelope_seq, dp[i])
        
        # print(dp)
        return maxenvelope_seq
                    

# Sort the array in the increasing order of width and decreasing order of height (This will avoid putting the elements with same width both in the subsequence array).
# Find the index where the envelope should be insrted (using binary search).
# Time complexity - O(n logn) (sort and binary search)
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        n = len(envelopes)
        if n==0: return 0
        
        # sort the envelopes # O(n logn)
        envelopes.sort(key = lambda x:(x[0], -x[1]))
        
        envelope_seq = [envelopes[0]]
        maxenvelope_seq = 1
        
        for envelope in envelopes:
            idx = self.__bsearch(envelope_seq, envelope)     
            if idx < maxenvelope_seq:
                envelope_seq[idx] = envelope
            elif envelope_seq[maxenvelope_seq-1][0] < envelope[0] and envelope_seq[maxenvelope_seq-1][1] < envelope[1]:
                maxenvelope_seq += 1
                envelope_seq.append(envelope)
            else:
                envelope_seq[idx-1] = envelope
        return maxenvelope_seq
    
    
    def __bsearch(self, envelope_seq, envelope):
        low, high = 0, len(envelope_seq)-1
        
        while low<=high:
            mid = low+(high-low)//2
            if envelope[1] == envelope_seq[mid][1]:
                return mid
            elif envelope[1] > envelope_seq[mid][1]:
                low = mid + 1
            else:
                high = mid - 1
        return low        

        