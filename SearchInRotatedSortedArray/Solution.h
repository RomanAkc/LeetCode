//
// Created by roman on 30.11.22.
//

#ifndef SEARCHINROTATEDSORTEDARRAY_SOLUTION_H
#define SEARCHINROTATEDSORTEDARRAY_SOLUTION_H

#include <vector>

class Solution {
public:
    int search(std::vector<int>& nums, int target) {
        return bsearch(nums, 0, static_cast<int>(nums.size() - 1), target);
    }

private:
    int bsearch(std::vector<int>& nums, int L, int R, int target) {
        if(L >= R) {
            if(nums[L] == target)
                return L;

            return -1;
        }

        int M = (L + R) / 2;
        if(nums[M] == target)
            return M;

        if(nums[M] > nums[R]) {
            if(target < nums[M] && target > nums[R])
                return bsearch(nums, L, M - 1, target);
            else
                return bsearch(nums, M + 1, R, target);
        } else {
            if(target > nums[M] && target <= nums[R])
                return bsearch(nums, M + 1, R, target);
            else
                return bsearch(nums, L, M - 1, target);
        }
    }
};

#endif //SEARCHINROTATEDSORTEDARRAY_SOLUTION_H
