//
// Created by roman on 06.02.23.
//

#include "Solution.h"
#include <algorithm>

int Solution::subarraySum(std::vector<int> &nums, int k) {
    int counter = 0;
    int sum = 0;

    for(int i = 0; i < nums.size(); ++i) {
        sum = nums[i];

        if(sum == k)
            counter++;

        for(int j = i + 1; j < nums.size(); ++j) {
            sum += nums[j];

            if(sum == k)
                counter++;
        }
    }

    return counter;
}
