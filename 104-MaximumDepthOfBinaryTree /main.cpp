#include <iostream>
#include <unordered_map>
#include <memory>
#include "TreeNode.h"
#include "Solution.h"

TreeNode* createTree(std::initializer_list<int> list);

int main() {
    auto s = std::make_unique<Solution>();
    std::cout << s->maxDepth(nullptr) << std::endl;
    std::cout << s->maxDepth(createTree({1,0,2})) << std::endl;
    std::cout << s->maxDepth(createTree({3,9,20,0,0,15,7})) << std::endl;
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
