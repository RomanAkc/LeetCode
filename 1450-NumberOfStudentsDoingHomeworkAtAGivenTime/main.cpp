/*
Given two integer arrays startTime and endTime and given an integer queryTime.

The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].

Return the number of students doing their homework at time queryTime. More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.

Example 1:

Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
Output: 1
Explanation: We have 3 students where:
The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.

Example 2:

Input: startTime = [4], endTime = [4], queryTime = 4
Output: 1
Explanation: The only student was doing their homework at the queryTime.

Constraints:

    startTime.length == endTime.length
    1 <= startTime.length <= 100
    1 <= startTime[i] <= endTime[i] <= 1000
    1 <= queryTime <= 1000

 * */

#include <iostream>
#include "Solution.h"

int main() {
    Solution s;

    std::vector<int> startTime1 {1,2,3};
    std::vector<int> endTime1 {3,2,7};
    int queryTime1 = 4;
    std::cout << s.busyStudent(startTime1, endTime1, queryTime1) << std::endl;

    std::vector<int> startTime2 {4};
    std::vector<int> endTime2 {4};
    int queryTime2 = 4;
    std::cout << s.busyStudent(startTime2, endTime2, queryTime2) << std::endl;

    return 0;
}
