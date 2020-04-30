// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
first we sort the first element of the envelopes in ascending order and the second element in the descending order.Then we traverse through the envelopes and check if the second element if it is greater than the last element of the out array then we add it to the array,else we do binary search on the out array to find the index whether the current element is to be replaced.


# Time complexity --> o(nlogn)
# space complexity --> o(n)
class Solution(object):
    def binarysearch(self,out,val):
        low=0
        high=len(out)-1
        while(low<high):
            mid=low+((high-low)/2)
            if val>out[mid]:
                low=mid+1
            else:
                high=mid
        return low
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        if envelopes==None or len(envelopes)==0:
            return 0
         #sort the envelopes first element in ascending order and the second element by descending order.
        envelopes=sorted(envelopes,key=lambda x:(x[0],-x[1]))
        # print(envelopes)
        out=[envelopes[0][1]]
        for i in range(1,len(envelopes)):
            val=envelopes[i]
            #we add it to the out array when the envelopes second element is greater than the last element of the out array
            if val[1]>out[-1]:
                out.append(val[1])
            else:
            #we  find the index where the val[1] has to be replaced in the out array.
                index=self.binarysearch(out,val[1])
                out[index]=val[1]
            # print(out)
        return len(out)
                
            
        