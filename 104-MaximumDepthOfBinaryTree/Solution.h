//
// Created by roman on 05.01.23.
//
#pragma once

struct TreeNode;

class Solution {
public:
    int maxDepth(TreeNode* root);

private:
    void traverse(TreeNode* node, int& depth, int& maxDepth);
};
