#TC: O(n^2)
#SC: O(n)
#In this problem, we are sorting either height or width and then it becomes a longest subsequence problem
#While sorting by width, if two envelopes have same width then we sort in descending order of height
#so that our program will not choose [2,2] and [2,3]. Because of the custom sort, it becomes [2,3] and [2,2]
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
    	#This is a custom sort which sorts first element in the tuple in ascending order 
    	#and second element in descending order
        newList=sorted(envelopes, key= lambda x: (x[0],-x[1]))

        dp=[1]*len(envelopes)
        result=1
    
        for i in range(1, len(envelopes)):
            for j in range(0,i):
                if newList[j][1]<newList[i][1]:
                    dp[i]=max(dp[i],dp[j]+1)
                    result=max(result, dp[i])
        return result