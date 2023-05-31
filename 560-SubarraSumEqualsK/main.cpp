/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -10^7 <= k <= 10^7


*/


#include <iostream>
#include "Solution.h"

int main() {
    Solution s;

    //std::vector<int> vec1 {1,1,1};
    //std::cout << s.subarraySum(vec1, 2) << std::endl;
    //Answer = 2

    //std::vector<int> vec2 {1,2,3};
    //std::cout << s.subarraySum(vec2, 3) << std::endl;
    //Answer = 2

    //std::vector<int> vec3 {1,1,0,0,0,1};
    //std::cout << s.subarraySum(vec3, 2) << std::endl;
    //Answer = 5

    //std::vector<int> vec4 {1,1,9,0,0,1,1};
    //std::cout << s.subarraySum(vec4, 2) << std::endl;
    //Answer = 4

    std::vector<int> vec5 {1,1,-1,1,1,0,0};
    std::cout << s.subarraySum(vec5, 2) << std::endl;
    //Answer = 8

    //std::vector<int> vec6 {1,-1, 0};
    //std::cout << s.subarraySum(vec6, 0) << std::endl;
    //Answer = 3

    return 0;
}
