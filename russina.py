# Time: O(nlogn)
# Space: O(n) 
# Did it run on Leetcode: yes

class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        def binarysearch(arr,low,high,target):
            while(low<=high):
                mid=(low+high)//2
                if(arr[mid]==target):
                    return mid
                elif(arr[mid]>target):
                    high=mid
                else:
                    low=mid+1

            return low

        n=len(envelopes)
        arr=[0]*(n)
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        arr[0]=envelopes[0][1]
        le=1
        for i in range(1,n):
            if(envelopes[i][1]> arr[le-1]):
                arr[le]=envelopes[i][1]
                le+=1
            else:
                bsid=binarysearch(arr,0,le-1,envelopes[i][1])
                arr[bsid]=envelopes[i][1]
        return le

