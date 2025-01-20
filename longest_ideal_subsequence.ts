// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : FALSE TLE
function longestIdealString(s: string, k: number): number {
  function hasKDistance(left: number, right: number): boolean {
    let aCode = "a".charCodeAt(0);
    let lNum = s.charCodeAt(left) - aCode;
    let rNum = s.charCodeAt(right) - aCode;
    return Math.abs(rNum - lNum) <= k;
  }
  let memo: number[][] = Array.from({ length: s.length }, () =>
    Array(s.length).fill(-1)
  );
  function dfs(index: number, prevIdx: number): number {
    if (index == s.length) return 0;
    if (prevIdx != -1 && memo[index][prevIdx] != -1)
      return memo[index][prevIdx];
    let result = 0;
    if (prevIdx == -1 || hasKDistance(index, prevIdx)) {
      result = 1 + dfs(index + 1, index);
    }
    result = Math.max(result, dfs(index + 1, prevIdx));
    memo[index][prevIdx] = result;
    return result;
  }
  return dfs(0, -1);
}

function longestIdealString_efficient(s: string, k: number): number {
  function hasKDistance(left: number, right: number): boolean {
    let aCode = "a".charCodeAt(0);
    let lNum = s.charCodeAt(left) - aCode;
    let rNum = s.charCodeAt(right) - aCode;
    return Math.abs(rNum - lNum) <= k;
  }

  let dp: number[] = Array(s.length);
  dp.fill(1);

  

  return 0;
}

describe("2370. Longest Ideal Subsequence", () => {
  it("Happy Path - 01", () => {
    expect(longestIdealString("acfgbd", 2)).toEqual(4);
  });

  it("Failed Testcase", () => {
    expect(longestIdealString("eduktdb", 15)).toEqual(5);
  });
});
