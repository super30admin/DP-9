/*
TC : O (NLog(N))
SC : O(N)
*/
class Solution
{
public:
    int lengthOfLIS(vector<int> &nums)
    {
        if (nums.size() == 0 || nums.empty())
        {
            return 0;
        }

        // store the list to form increasing subsequence
        // the list does not contain actual subsequence i.e. expeted result
        //  eg i/p : [10, 9, 2, 5, 3, 1 , 101, 18, 19]
        vector<int> result;
        result.push_back(nums[0]);
        for (int i = 1; i < nums.size(); i++)
        {
            if (result[result.size() - 1] < nums[i])
            {
                result.push_back(nums[i]);
            }
            else
            {
                int binaryIndex = binarySearch(result, 0, result.size(), nums[i]);
                result[binaryIndex] = nums[i];
            }
        }
        for (auto i : result)
        {
            cout << i << " ";
        }
        return result.size();
    }

    int binarySearch(vector<int> res, int low, int high, int target)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (res[mid] == target)
            {
                return mid;
            }
            else if (res[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low;
    }
};