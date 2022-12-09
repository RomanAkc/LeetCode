#include <iostream>
#include <memory>
#include "Solution.h"
#include "TreeNode.h"

TreeNode* createTree(std::initializer_list<int> list);

int main() {
    auto s = std::make_unique<Solution>();
    std::cout << s->sumEvenGrandparent(nullptr) << std::endl;
    std::cout << s->sumEvenGrandparent(createTree({1})) << std::endl;
    std::cout << s->sumEvenGrandparent(createTree({6,7,8,2,7,1,3,9,0,1,4,0,0,0,5})) << std::endl;
    return 0;
}

TreeNode* createTree(std::initializer_list<int> list) {
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