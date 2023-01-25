//
// Created by roman on 25.01.23.
//

#include "Solution.h"

int Solution::minCostClimbingStairs(const std::vector<int> &cost) {
    int dp0 = cost[0];
    int dp1 = cost[1];
    int dp2 {0};

    for(int i = 2; i < cost.size(); ++i) {
        dp2 = std::min(dp1 + cost[i], dp0 + cost[i]);
        dp0 = dp1;
        dp1 = dp2;
    }

    dp2 = std::min(dp1, dp0);

    return dp2;
}

int Solution::minCostClimbingStairs_memoization(std::vector<int>& cost) {
    std::vector<int> dp(cost.size() + 1);

    dp[0] = cost[0];
    dp[1] = cost[1];

    for(int i = 2; i < cost.size(); ++i) {
        dp[i] = std::min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
    }

    dp[cost.size()] = std::min(dp[cost.size() - 1], dp[cost.size() - 2]);

    return dp.back();
}
