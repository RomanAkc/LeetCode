//
// Created by roman on 30.01.23.
//

#pragma  once

#include <unordered_map>
#include "TreeNode.h"

class Solution {
public:
    int deepestLeavesSum(TreeNode* root);

private:
    void dfs(TreeNode* root, int depth, int& maxDepth, std::unordered_map<int, int>& mapSum) const;
};

