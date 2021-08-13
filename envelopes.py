# Time Complexity : O(NlogN)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution(object):
    def maxEnvelopes(self, envelopes):
        #sorted according to width
        envelopes.sort(key=lambda x: (x[0],-x[1]))
        n = len(envelopes)
        l = 1
        effArr = [0]*n
        #store the height
        effArr[0] = envelopes[0][1]

        for i in range(1,n):
            if envelopes[i][1]>effArr[l-1]:
                effArr[l] = envelopes[i][1]
                l+=1
            else:
                ind = self.BS(effArr,0,l-1,envelopes[i][1])
                effArr[ind] = envelopes[i][1]
        return l
    
    def BS(self,effArr,left,right,target):
        while(left<=right):
            mid = left+(right-left)//2
            if effArr[mid]==target:
                return mid
            elif effArr[mid]>target:
                right = mid-1
            else:
                left = mid+1
        return left