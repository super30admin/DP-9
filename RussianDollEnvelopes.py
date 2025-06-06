#time comoplexity: O(nlogn)
#space complexity: O(n)

class Solution:
    def search(self,target,L):
        low=0
        high=len(L)
        while(low<high):
            mid=low+(high-low)//2
            if(target<=L[mid]):
                possible=True
            else:
                possible=False
            if(possible):
                high=mid
            else:
                low=mid+1
        return low


    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes=sorted(envelopes,key=lambda x:(x[0],-x[1]))
        L=[]
        L.append(envelopes[0][1])
        for i in range(1,len(envelopes)):
            if(envelopes[i][1]>L[-1]):
                L.append(envelopes[i][1])
                continue
            ans=self.search(envelopes[i][1],L)
            L[ans]=envelopes[i][1]    
        return len(L)