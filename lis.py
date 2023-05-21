class Solution:
    # traverse through the array and enter the elements into the new array, replace the current element if it is smaller than the last elem with a no just greater than it with a hope of getting larger subsequence 
    #TC-O(nlogn),SC-O(n)
    def lengthOfLIS(self, nums: List[int]) -> int:
        def binarysearch(res,s,e,k):
            while s<=e:
                mid=(s+e)//2
                if res[mid]==k:
                    return mid
                elif res[mid]>k:
                    e=mid-1
                else:
                    s=mid+1
            return s
        res=[0 for i in range(len(nums))]
        res[0]=nums[0]
        le=1
        for i in range(1,len(nums)):
            if nums[i]>res[le-1]:
                res[le]=nums[i]
                le+=1
            else:
                ind = binarysearch(res,0,le-1,nums[i])
                print(ind)
                if ind!=-1:
                    res[ind]=nums[i]
        print(res)
        return le



        