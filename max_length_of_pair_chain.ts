import { array } from "yargs";

function findLongestChain(pairs: number[][]): number {
  function isChain(prevIdx: number, nextIdx: number): boolean {
    return pairs[prevIdx][1] < pairs[nextIdx][0];
  }

  let memo: number[][] = Array.from({ length: pairs.length }, () =>
    Array(pairs.length).fill(-1)
  );

  function dfs(index: number, prevPair: number): number {
    if (index == pairs.length) return 0;

    if (prevPair != -1 && memo[index][prevPair] != -1) {
      return memo[index][prevPair];
    }

    let result = 0;
    if (prevPair == -1 || isChain(prevPair, index)) {
      result = 1 + dfs(index + 1, index);
    }
    result = Math.max(result, dfs(index + 1, prevPair));
    memo[index][prevPair] = result;
    return result;
  }

  pairs.sort((a, b) => {
    if (a[0] == b[0]) {
      return a[1] - b[1];
    }
    return a[0] - b[0];
  });
  return dfs(0, -1);
}

describe("646. Maximum Length of Pair Chain", () => {
  it("Happy Path - 01", () => {
    expect(
      findLongestChain([
        [1, 2],
        [2, 3],
        [3, 4],
      ])
    ).toEqual(2);
  });

  it("Happy Path - 02", () => {
    expect(
      findLongestChain([
        [1, 2],
        [7, 8],
        [4, 5],
      ])
    ).toEqual(3);
  });

  it("Negative Values", () => {
    expect(
      findLongestChain([
        [-10, -8],
        [8, 9],
        [-5, 0],
        [6, 10],
        [-6, -4],
        [1, 7],
        [9, 10],
        [-4, 7],
      ])
    ).toEqual(4);
  });
});
