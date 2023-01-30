//
// Created by roman on 30.01.23.
//

#include "Solution.h"

int Solution::deepestLeavesSum(TreeNode *root) {
    if(root == nullptr)
        return 0;

    std::unordered_map<int, int> mapSum;
    int maxDepth = 0;
    dfs(root, 1, maxDepth, mapSum);

    return mapSum[maxDepth];
}

void Solution::dfs(TreeNode *root, int depth, int& maxDepth, std::unordered_map<int, int> &mapSum) const {
    if(root == nullptr)
        return;

    maxDepth = std::max(depth, maxDepth);

    //optimization
    if(depth == maxDepth) {
        mapSum[depth] += root->val;
    }

    dfs(root->left, depth + 1, maxDepth, mapSum);
    dfs(root->right, depth + 1, maxDepth, mapSum);
}
