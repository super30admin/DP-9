/*
TC : O(nlogn)
SC : O(n)
Note : the temp vector does not conatin the expected result if required to return the list as well
*/
class Solution
{
public:
    int maxEnvelopes(vector<vector<int>> &envelopes)
    {
        if (envelopes.size() == 0 || envelopes.empty())
        {
            return 0;
        }

        sort(envelopes.begin(), envelopes.end(), [](const vector<int> &a, const vector<int> &b)
             {
                 if (a[0] == b[0])
                 { // If first elements are equal, sort by second element
                     return b[1] < a[1];
                 }
                 return a[0] < b[0]; // Otherwise, sort by first element
             });

        vector<int> temp;
        temp.push_back(envelopes[0][1]);
        for (int i = 1; i < envelopes.size(); i++)
        {
            // add only if both the elemensts are greater than the prev
            if (envelopes[i - 1][0] < envelopes[i][0] && envelopes[i - 1][1] < envelopes[i][1] && temp[temp.size() - 1] < envelopes[i][1])
            {
                temp.push_back(envelopes[i][1]);
            }
            else
            {
                // fetch the index to replace with
                int binIndex = binarySearch(temp, 0, temp.size() - 1, envelopes[i][1]);
                temp[binIndex] = envelopes[i][1];
            }
        }

        return temp.size();
    }

    int binarySearch(vector<int> &nums, int low, int high, int target)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
};