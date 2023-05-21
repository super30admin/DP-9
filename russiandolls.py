class Solution:
    # sort either on width or height and find the longest increasing subsequence on the other dimension of the sorted sequence, 
    #TC-o(nlogn),SC-O(n)
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
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
        n = len(envelopes)
        res = [0 for i in range(n)]
        envelopes = sorted(envelopes,key=lambda x:(x[0],-x[1]))
        print(envelopes)
        # find length of lis  of sorted envelopes list
        le=1
        res[0]=envelopes[0][1]
        for i in range(1,n):
            if envelopes[i][1]>res[le-1]:
                res[le]=envelopes[i][1]
                le+=1
            else:
                ind = binarysearch(res,0,le-1,envelopes[i][1])
                res[ind]=envelopes[i][1]    
        return le
