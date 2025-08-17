class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        def binSearch(arr, num):
            low=0
            high=len(arr)

            while low<high:
                mid=(low+high)//2
                if arr[mid]<num:
                    low=mid+1
                else:
                    high=mid
            
            return low

        sub=[]
        for num in nums:
            idx=binSearch(sub, num)
            if idx==len(sub):
                sub.append(num)
            else:
                sub[idx]=num
        print(sub)
        return len(sub)
            


                    
