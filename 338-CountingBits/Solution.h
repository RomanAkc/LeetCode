//
// Created by roman on 24.01.23.
//
#include <vector>

class Solution {
public:
    Solution();
    std::vector<int> countBits(int n);

private:
    int bits[256];
    int precalculated_popcnt(int n);
    int direct_popcnt(int n);
};
