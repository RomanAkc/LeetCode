//
// Created by roman on 09.12.22.
//

#ifndef SUMOFNODESWITHEVENVALUEDGRANDPARENT_SOLUTION_H
#define SUMOFNODESWITHEVENVALUEDGRANDPARENT_SOLUTION_H

#include <unordered_map>

struct TreeNode;

class Solution {
public:
    int sumEvenGrandparent(TreeNode* root);

private:
    int BFS(TreeNode* root);
    TreeNode* getParent(TreeNode* node, const std::unordered_map<TreeNode*, TreeNode*>& mapNodeToParent) const;
    bool isGrandParentEvenValuated(TreeNode* node, const std::unordered_map<TreeNode*, TreeNode*>& mapNodeToParent) const;
};


#endif //SUMOFNODESWITHEVENVALUEDGRANDPARENT_SOLUTION_H
