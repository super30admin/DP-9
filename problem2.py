#time comoplexity: O(nlogn)
#space complexity: O(n)
#ran on leetcode: yes
#sort the element in increasing order of first element and in case of tie, decreasing order of 2nd element.Then find 
#out the increasing longest subsequence of 2nd element.
class Solution:
    def search(self,target,L):
        low=0
        high=len(L)
        while(low<high):
            mid=low+(high-low)//2
            #possible= target>=L[mid]
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
        #envelopes.sort()
        envelopes=sorted(envelopes,key=lambda x:(x[0],-x[1]))
        #L=[]
        #print(envelopes)
        L=[]
        L.append(envelopes[0][1])
        #L=[envelopes[0][1]]
        for i in range(1,len(envelopes)):
            #print(L)
            if(envelopes[i][1]>L[-1]):
                L.append(envelopes[i][1])
                continue
            ans=self.search(envelopes[i][1],L)
            #print(ans)
            #print(L)
            L[ans]=envelopes[i][1]    
        #print("OUTSIDE FOR")
        #print(envelopes)
        #print(L)
        return len(L)

        
