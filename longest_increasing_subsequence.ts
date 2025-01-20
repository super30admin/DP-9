function lengthOfLIS(nums: number[]): number {
  let memo: number[][] = Array.from({ length: nums.length + 1 }, () =>
    Array(nums.length + 1).fill(Number.MIN_SAFE_INTEGER)
  );
  // Bottom Up DFS for memoisation
  function dfs(current: number, prev: number): number {
    // base case
    if (current >= nums.length) {
      return 0;
    }

    if (memo[current][prev + 1] != Number.MIN_SAFE_INTEGER)
      return memo[current][prev + 1];

    let result = 0;
    // logic
    if (prev == -1 || nums[prev] < nums[current]) {
      // Keep track of prev idx / number choosen for comparision with current number.
      result = 1 + dfs(current + 1, current); // Choosing the element so prev will be current
    }
    result = Math.max(result, dfs(current + 1, prev)); // not chooseing the element so prev will remain same.

    memo[current][prev + 1] = result; // prev + 1 is because in the initial dfs call we are starting with -1
    return result;
  }
  return dfs(0, -1);
}

function lengthOfLIS_tabulation(nums: number[]): number {
  let tabulation: number[] = Array.from({ length: nums.length });
  tabulation.fill(1); // 1 because by default longest increasing subsequence will be individual element itself.

  let max = 1;
  // N^2
  for (let i = 1; i < nums.length; i++) {
    for (let j = 0; j < i; j++) {
      if (nums[i] > nums[j]) {
        tabulation[i] = Math.max(tabulation[i], 1 + tabulation[j]);
        max = Math.max(tabulation[i], max);
      }
    }
  }
  return max;
}

// O(n)
function lengthOfLIS_effective_array_logic(nums: number[]): number {
  let effectiveArray: number[] = [];
  effectiveArray.push(nums[0]);

  function search(value: number): number {
    let left = 0;
    let right = effectiveArray.length - 1;
    while (left <= right) {
      // We should have to exit the loop when left and right crosses that's why <=
      let mid: number = Math.floor(left + (right - left) / 2);
      if (effectiveArray[mid] == value) return mid;
      else if (effectiveArray[mid] > value) right = mid - 1;
      else left = mid + 1;
    }
    return left;
  }

  for (let i = 1; i < nums.length; i++) {
    let len = effectiveArray.length - 1;
    if (nums[i] > effectiveArray[len]) {
      effectiveArray.push(nums[i]);
    } else {
      let idx = search(nums[i]);
      effectiveArray[idx] = nums[i];
    }
  }
  return effectiveArray.length;
}

describe("300. Longest Increasing Subsequence", () => {
  it("Happy Path - 01", () => {
    expect(lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18])).toEqual(4);
    expect(lengthOfLIS([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12])).toEqual(6);
    expect(lengthOfLIS_tabulation([10, 9, 2, 5, 3, 7, 101, 18])).toEqual(4);
    expect(
      lengthOfLIS_effective_array_logic([10, 9, 2, 5, 3, 7, 101, 18])
    ).toEqual(4);
  });

  it("Happy Path - 02", () => {
    expect(lengthOfLIS([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12])).toEqual(6);
    expect(lengthOfLIS_tabulation([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12])).toEqual(
      6
    );
    expect(
      lengthOfLIS_effective_array_logic([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12])
    ).toEqual(6);
  });

  it("Happy Path - 03", () => {
    expect(lengthOfLIS([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12])).toEqual(6);
    expect(lengthOfLIS_tabulation([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12])).toEqual(
      6
    );
    expect(lengthOfLIS_effective_array_logic([10, 9, 2, 5, 3, 4])).toEqual(3);
  });
});
