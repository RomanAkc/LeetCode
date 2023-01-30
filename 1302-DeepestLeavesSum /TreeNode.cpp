//
// Created by roman on 30.01.23.
//
#include <unordered_map>
#include "TreeNode.h"


TreeNode *createTree(std::initializer_list<int> list) {
    if(empty(list))
        return nullptr;

    std::unordered_map<int, TreeNode*> mapNodes;
    int index = 0;
    for(auto c : list) {
        TreeNode* p = nullptr;
        if(c != 0) {
            p = new TreeNode(c);
        }

        if(index > 0 && c != 0) {
            int parent = (index - 1 ) / 2;
            if(index % 2 == 1)
                mapNodes[parent]->left = p;
            else
                mapNodes[parent]->right = p;
        }

        mapNodes[index] = p;
        index++;
    }

    return mapNodes[0];
}
