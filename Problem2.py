#Time Complexity :O(nlogn) 
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x:(x[0],-x[1]))
        arr=[]
        arr.append(envelopes[0][1])
        le=1
        for i in range(1,len(envelopes)):
            if envelopes[i][1]> arr[-1]:
                arr.append(envelopes[i][1])
                le+=1
            else:
                idx=self.binarysearch(arr,0, le-1,envelopes[i][1])
                arr[idx]=envelopes[i][1]
        return le

    def binarysearch(self,nums,low,high,target):
        while low<=high:
            mid=int((low+high)/2)
            if nums[mid]==target:
                return mid
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return low
        