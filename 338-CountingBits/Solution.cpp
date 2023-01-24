//
// Created by roman on 24.01.23.
//

#include "Solution.h"

Solution::Solution()
{
    for(int i = 0; i < 256; i++) {
        bits[i] = direct_popcnt(i);
    }
}

std::vector<int> Solution::countBits(int n) {
    std::vector<int> result(n + 1);

    for(int i = 0; i <= n; i++) {
        result[i] = precalculated_popcnt(i);
    }

    return result;
}

int Solution::direct_popcnt(int n) {
    int counter = 0;
    while (n > 0) {
        counter++;
        n &= (n - 1);
    }
    return counter;
}

int Solution::precalculated_popcnt(int n) {
    int counter = 0;

    while (n > 0) {
        counter += bits[n & 255];
        n >>= 8;
    }

    return counter;
}


