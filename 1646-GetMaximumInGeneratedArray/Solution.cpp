//
// Created by roman on 31.01.23.
//

#include <memory>
#include "Solution.h"

int Solution::getMaximumGenerated(int n) {
    if(n == 0)
        return 0;

    auto nums = std::make_unique<int[]>(n + 1);

    nums[0] = 0;
    nums[1] = 1;


    //Simple solution
    int max = 1;

    for(int i = 2; i < n + 1; i++) {
        if(i % 2 == 0) {
            nums[i] = nums[i / 2];
        } else {
            nums[i] = nums[i / 2] + nums[i / 2 + 1];
            max = std::max(max, nums[i]);
        }
    }

    return max;

    //Bad solution
    /*int i = 1;
    int max = 1;

    while (true) {
        int even = 2 * i;
        bool isEvenSuitable = isNumSuitable(even, n);
        if(isEvenSuitable)
            nums[even] = nums[i];

        int odd = 2 * i + 1;
        bool isOddSuitable = isNumSuitable(odd, n);
        if(isOddSuitable) {
            nums[odd] = nums[i] + nums[i + 1];
            max = std::max(max, nums[odd]);
        }

        if(!isEvenSuitable && !isOddSuitable)
            break;

        i++;
    }

    return max;*/
}

bool Solution::isNumSuitable(int num, int n) const {
    return num >=2 && num <= n;
}
