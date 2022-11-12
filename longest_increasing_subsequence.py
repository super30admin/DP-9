#TIme -> O(n^2)
#Space -> O(n)

#Backward approach
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        my_list=[1]*len(nums)
        
        for i in range(len(nums)-1,-1,-1):
            for j in range(i+1,len(nums)):
                if nums[i]<nums[j]:
                    my_list[i]=max(my_list[i],1+my_list[j])
        
        return max(my_list)




#Forward Approach
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        my_list=[1]*len(nums)
        
        for i in range(1,len(nums)):
            for j in range(0,i):
                if nums[i]>nums[j]:
                    my_list[i]=max(my_list[i],1+my_list[j])
        
        return max(my_list)


#Binary search approach
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        my_list=[0]*len(nums)
        my_list[0]=nums[0]
        len=1

        for i in range(1,len(nums)):
                if nums[i]>nums[len-1]:
                    my_list[len]=nums[i]
                    len+=1
                else:
                    bsIndex=binary(my_list,0,len(nums)-1,my_list[i])
                    my_list[bsIndex]=nums[i]

        return len

    def binary(my_list,low,high,target):
        while low<high:
            mid=low+high//2
            if my_list[mid]==target:
                return target
            elif my_list[mid]<target:
                low=mid+1
            else:
                high=mid-1
        
        return low
