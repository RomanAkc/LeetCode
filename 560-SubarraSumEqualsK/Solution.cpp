//
// Created by roman on 06.02.23.
//

#include "Solution.h"
#include <algorithm>
#include <unordered_map>

int Solution::subarraySum(std::vector<int> &nums, int k) {
    int counter = 0;
    int sum = 0;
    std::unordered_map<int, int> mapSum;

    mapSum[0] = 1;
    for(int i = 0; i < nums.size(); ++i) {
        sum += nums[i];

        if(mapSum.find(sum - k) != mapSum.end()) {
            counter += mapSum.at(sum - k);
        }

        mapSum[sum]++;
    }

    return counter;
}
