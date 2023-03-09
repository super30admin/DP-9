# Time Complexity :
# O(N Log N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We can sort the given envelopes based on the first index (if the first values are equal then sort in descending oreder from the second element)
#Once we have this, we can find the maximum envelopes by finding the value longest increasing subsequence of the second elements.
#That can be done by extracting the second elements (we know that the first ones are increasing). Then, we go through each element in the second elem list
#when going through, we start adding elements to an effective increasing array whenever the new incoming element is greater than the last element of the effective increasing array
#If the incoming element is smaller than the last element of the effective inreasing array, we replace the element just greater than incoming element in the array by the incoming element (that position is found using binary search)
#At the end of this, the length of the effective increasing subarray is the maximum increasing subsequenbce and also the maximum size of the russian dolls

class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes = sorted(envelopes,key = lambda x : (x[0],-x[1]))
        second_nums = [elem[1] for elem in envelopes]
        return self.lengthOfLIS(second_nums)

    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        effective_increasing = []
        effective_increasing.append(nums[0])
        for i in range(1,n):
            if nums[i] > effective_increasing[-1] :
                effective_increasing.append(nums[i])
            else :
                find_greater_loc = self.binary(effective_increasing,nums[i])
                effective_increasing[find_greater_loc] = nums[i]

        return len(effective_increasing)

    def binary(self,arr,val) :
        low = 0
        high = len(arr)- 1
        while low <= high :
            mid = low + int((high-low)/2)
            if arr[mid] > val :
                high = mid -1
            elif arr[mid] < val :
                low = mid+1
            else :
                return mid
        return low
