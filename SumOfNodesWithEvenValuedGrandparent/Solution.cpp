//
// Created by roman on 09.12.22.
//

#include <queue>
#include "TreeNode.h"
#include "Solution.h"

int Solution::sumEvenGrandparent(TreeNode *root) {
    return BFS(root);
}

int Solution::BFS(TreeNode* root) {
    std::queue<TreeNode*> queue;
    queue.push(root);

    std::unordered_map<TreeNode*, TreeNode*> mapNodeToParent;

    int sum = 0;
    while (!queue.empty()) {
        auto node = queue.front();
        queue.pop();

        if(node == nullptr)
            continue;

        if(node->left != nullptr) {
            queue.push(node->left);
            mapNodeToParent[node->left] = node;
        }

        if(node->right != nullptr) {
            queue.push(node->right);
            mapNodeToParent[node->right] = node;
        }

        if(isGrandParentEvenValuated(node, mapNodeToParent))
            sum += node->val;
    }

    return sum;
}

TreeNode *Solution::getParent(TreeNode* node, const std::unordered_map<TreeNode *, TreeNode *> &mapNodeToParent) const {
    if(!mapNodeToParent.contains(node))
        return nullptr;

    return mapNodeToParent.at(node);
}

bool Solution::isGrandParentEvenValuated(TreeNode *node, const std::unordered_map<TreeNode *, TreeNode *> &mapNodeToParent) const {
    auto parent = getParent(node, mapNodeToParent);
    if(!parent)
        return false;

    auto grandParent = getParent(parent, mapNodeToParent);
    if(!grandParent)
        return false;

    return grandParent->val % 2 == 0;
}
