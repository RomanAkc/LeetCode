//
// Created by roman on 08.12.22.
//

#ifndef YANDEXTREEEQUALCHARS_SOLUTION_H
#define YANDEXTREEEQUALCHARS_SOLUTION_H

//

#include <utility>
#include <map>

struct Node;

class Solution {
public:
    std::pair<Node*, Node*> FindEquals(Node* root);
    std::pair<Node*, Node*> FindEqualsSimple(Node* root);

private:
    std::pair<int, std::pair<Node*, Node*>> GetValueForNode(Node* node, std::map<int, Node *> &mapValues);
    int FillMapValues(Node* node, std::multimap<int, Node *> &mapValues);
};


#endif //YANDEXTREEEQUALCHARS_SOLUTION_H
