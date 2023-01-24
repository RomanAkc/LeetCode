#include <iostream>

//https://leetcode.com/problems/counting-bits/

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's
in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
*/

#include <iostream>
#include "Solution.h"

void printVector(const std::vector<int>& vec);

int main() {
    Solution s;
    printVector(s.countBits(2));
    printVector(s.countBits(5));
    return 0;
}

void printVector(const std::vector<int>& vec) {
    std::cout << "[";
    if(!vec.empty()) {
        std::cout << vec[0];
    }
    for(int i = 1; i < vec.size(); ++i) {
        std::cout << ", " << vec[i];
    }
    std::cout << "]" << std::endl;
}
