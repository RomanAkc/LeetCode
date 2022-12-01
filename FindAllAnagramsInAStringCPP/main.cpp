#include <iostream>
#include <memory>
#include "Solution.h"

void printVector(const std::vector<int>& vec) {
    std::cout << "[";
    for(auto index : vec)
        std::cout<< index << ", ";
    std::cout << "]" << std::endl;
}

int main() {
    auto p = std::make_unique<Solution>();
    printVector(p->findAnagrams("cbaebabacd", "abc"));
    printVector(p->findAnagrams("abab", "ab"));
    printVector(p->findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));

    return 0;
}
