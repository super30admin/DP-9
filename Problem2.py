#Time complexity is O(nlogn)
#Space complexity is O(n) where n is the length of nums
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        #Initializing required variables
        n=len(envelopes)
        #Sorting envelopes based on increasing order of 0th index
        #and decreasing order of 1th index
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        arr=[]
        arr.append(envelopes[0][1])
        le=1
        #Looping through the nums array
        for i in range(1,n):
            #If the below condition satisfies, we will insert the value at the position le
            if(envelopes[i][1]>arr[le-1]):
                arr.insert(le,envelopes[i][1])
                #Increaseing the value of le by 1
                le+=1
            else:
                #Else we ill do binary search on the arr to find index of the just greater 
                #element than nums[i] in arr
                bsIdx=self.binarySearch(arr,0,le-1,envelopes[i][1])
                arr[bsIdx]=envelopes[i][1]
        #FInally we will returning the length of the array of longest subsequence
        return le

    #Function to perform binary search
    def binarySearch(self,arr,low,high,target):
        while(low<=high):
            mid=low+(high-low)/2
            if(arr[mid]==target):
                return mid
            elif(arr[mid]>target):
                high=mid-1
            else:
                low=mid+1
        #We will return the index of the just greater element in the arr
        return low
