//
// Created by roman on 05.01.23.
//

#include <algorithm>
#include "Solution.h"
#include "TreeNode.h"

int Solution::maxDepth(TreeNode *root) {
    if(root == nullptr)
        return 0;

    int depth = 0;
    int maxDepth = 0;

    traverse(root, depth, maxDepth);
    return maxDepth;
}

void Solution::traverse(TreeNode *node, int &depth, int &maxDepth) {
    depth++;
    maxDepth = std::max(depth, maxDepth);

    if(node->right != nullptr)
        traverse(node->right, depth, maxDepth);
    if(node->left != nullptr)
        traverse(node->left, depth, maxDepth);

    depth--;
}
