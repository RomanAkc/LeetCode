//
// Created by roman on 08.12.22.
//

#include "Solution.h"
#include "Node.h"

std::pair<Node *, Node *> Solution::FindEquals(Node *root) {
    std::map<int, Node*> mapValues;
    return GetValueForNode(root, mapValues).second;
}

std::pair<int, std::pair<Node*, Node*>> Solution::GetValueForNode(Node *node, std::map<int, Node *> &mapValues) {
    if(node == nullptr)
        return {0, {}};

    auto resLeft = GetValueForNode(node->left, mapValues);
    if(resLeft.first == -1)
        return resLeft;

    auto resRight = GetValueForNode(node->right, mapValues);
    if(resRight.first == -1)
        return resRight;

    int value = resLeft.first | resRight.first | (1 << (node->c - 'A'));

    if(mapValues.contains(value)) {
        return {-1, {mapValues[value], node}};
    } else {
        mapValues[value] = node;
    }

    return {value, {nullptr, nullptr}};
}

