class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        
        #Method 1 - Custom sort+Longest Icreasing Sequence (LIS)
        envelopes.sort(key=lambda x:(x[0],-x[1])) 
        
#sort in asceding based on width, if equal descending height.
#Reason for this, once you sort out width in asceding, that is handles, now only the ihght will be out of order. If you observe now, it's an Longest Icreasing Sequence (LIS) problem based on height.
#But consider this, once sorted -> (2,2),(2,3),(3,4),(3,5) the LIS will be all 4 of them. But you can't russian doll (2,2) in a (2,3) and (3,4) in a (3,5), same width. So to fix this issue, descending height will fix it.
#Now -> (2,3), (2,2),(3,5), (3,4). The LIS will be on len 2 -> 1.(2,3),(3,5), 2.(2,3),(3,4), 3. (2,2),(3,5), 4. (2,2),(3,4). Hence if equal descending height.

#After you figure out the custom sort, do the wierd iteration using binary seqarch for updating.

# TC - nlogn+nlogn, SC - O(n)



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