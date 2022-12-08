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

std::pair<Node *, Node *> Solution::FindEqualsSimple(Node *root) {
    std::multimap<int, Node*> mapValues;
    FillMapValues(root, mapValues);
    if(mapValues.size() < 2)
        return {};

    auto it_prev = mapValues.begin();
    auto it_curr = std::next(it_prev);
    while (it_curr != mapValues.end()) {
        if(it_prev->first == it_curr->first)
            return {it_prev->second, it_curr->second};

        auto it_next = std::next(it_curr);
        it_prev = it_curr;
        it_curr = it_next;
    }

    return {};
}

int Solution::FillMapValues(Node *node, std::multimap<int, Node *> &mapValues) {
    if(node == nullptr)
        return 0;

    int l = FillMapValues(node->left, mapValues);
    int r = FillMapValues(node->right, mapValues);

    int value = l | r | (1 << (node->c - 'A'));
    mapValues.emplace(value, node);
    return value;
}

