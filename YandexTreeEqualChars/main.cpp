#include <iostream>
#include <unordered_map>
#include <memory>
#include "Solution.h"
#include "Node.h"

Node* createTree(std::initializer_list<char> list);
void printNodePair(std::pair<Node*, Node*> p);
void printNodePair(Node* p1, Node* p2);

int main() {
    auto s = std::make_unique<Solution>();
    Node* n1 = createTree({'D', 'A', 'B', '\0', 'C', '\0', 'D', '\0', '\0', 'D', '\0', '\0', '\0', '\0', 'A', '\0', '\0', '\0', '\0', '\0', 'B', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', 'C', '\0'});
    printNodePair(s->FindEquals(n1));
    Node* n2 = createTree({'C', 'C', 'C'});
    printNodePair(s->FindEquals(n2));
    return 0;
}

Node* createTree(std::initializer_list<char> list) {
    if(empty(list))
        return nullptr;

    std::unordered_map<int, Node*> mapNodes;
    int index = 0;
    for(auto c : list) {
        Node* p = nullptr;
        if(c != '\0') {
            p = new Node();
            p->c = c;
            p->index = index;
        }

        if(index > 0 && c != '\0') {
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

void printNodePair(std::pair<Node*, Node*> p) {
    printNodePair(p.first, p.second);
}

void printNodePair(Node* p1, Node* p2) {
    if(p1 != nullptr)
        std::cout << "First Node: " << p1->c <<" (" << p1->index <<")" << std::endl;
    else
        std::cout << "First Node is empty" << std::endl;

    if(p2 != nullptr)
        std::cout << "Second Node: " << p2->c <<" (" << p2->index <<")" << std::endl;
    else
        std::cout << "Second Node is empty" << std::endl;
}
