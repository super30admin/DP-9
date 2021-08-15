//O(n^2)solution + O(n) space
class Solution {
public:
       int maxEnvelopes(vector<vector<int>>& envelopes) 
{
	int size = envelopes.size();
	if(!size) return 0;
	sort(envelopes.begin(), envelopes.end());
	int maxroll = 1;
    
	vector<int> maxrolls(size,0);
    maxrolls[0]=1;
	for(int i = 1; i < size; ++i)
	{
		maxrolls[i] = 1;
		for(int j = i-1; j >= 0; --j)
			if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1])
				maxrolls[i] = max(maxrolls[i], maxrolls[j]+1);
		maxroll = max(maxroll, maxrolls[i]);
	}
	return maxroll;
}
};
