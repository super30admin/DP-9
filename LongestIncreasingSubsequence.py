#time complexity:O(nlogn)
#space complexity: O(n)

class Solution:
    def binary_search(self,L,target):
        low=0
        high=len(L)
        while(low<high):
            mid=(low+high)//2
            if(L[mid] < target):
                low=mid+1
            else:
                high=mid

        return low

    def lengthOfLIS(self, nums: List[int]) -> int:
        L=[nums[0]]
        for i in range(1,len(nums)):
            if(nums[i]>L[-1]):
                L.append(nums[i])
            else:
                ind=self.binary_search(L,nums[i])
                L[ind]=nums[i]
        return len(L)
