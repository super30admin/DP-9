// Time Complexity : o(n^n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : false TLE
function numberOfWeakCharacters(properties: number[][]): number {
  properties.sort((lhs, rhs) => {
    if (lhs[0] == rhs[0]) return lhs[1] - rhs[1]; // If Width are same the sort those object by height in decending order
    return lhs[0] - rhs[0]; // else sort by width in acending order
  });

  let count: number = 0;

  for (let i = 0; i < properties.length; i++) {
    let defence = properties[i][1];
    let attack = properties[i][0];
    for (let j = i + 1; j < properties.length; j++) {
      if (properties[j][1] > defence && properties[j][0] > attack) {
        count++;
        break;
      }
    }
  }

  return count;
}

// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : true
function numberOfWeakCharacters_efficient(properties: number[][]): number {
  properties.sort((lhs, rhs) => {
    if (lhs[0] == rhs[0]) return rhs[1] - lhs[1]; // If attack are same the sort those object by defence in decending order
    return lhs[0] - rhs[0]; // else sort by attack in acending order
  });

  let weakChar = 0;
  let maxDefence = Number.MIN_SAFE_INTEGER;
  // Interesting idea
  // check the objects from end to start
  // which means last element will be the highest attack and 1st element will be the smallest attack
  // [[3,6], [3,8], [4,10], [5,11]]
  // Also, maintaining max defence work because when we go from end to start
  //    we will always be visiting the smaller element compare to previously visited.
  for (let i = properties.length - 1; i >= 0; i--) {
    if (properties[i][1] < maxDefence) {
      weakChar++;
    }
    maxDefence = Math.max(maxDefence, properties[i][1]);
  }

  return weakChar;
}

describe("1996. The Number of Weak Characters in the Game", () => {
  it("Happy Path - 01", () => {
    let input = [
      [5, 5],
      [6, 3],
      [3, 6],
    ];
    let expected = 0;
    expect(numberOfWeakCharacters(input)).toEqual(expected);
    expect(numberOfWeakCharacters_efficient(input)).toEqual(expected);
  });

  it("Failed Testcase", () => {
    let input = [
      [1, 5],
      [10, 4],
      [4, 3],
    ];
    let expected = 1;
    expect(numberOfWeakCharacters(input)).toEqual(expected);
    expect(numberOfWeakCharacters_efficient(input)).toEqual(expected);
  });
});
