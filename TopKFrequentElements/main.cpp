#include <iostream>
#include <memory>
#include "Solution.h"

void printVector(const std::vector<int>& vec) {
    std::cout << "[";
    for(auto index : vec)
        std::cout<< index << ", ";
    std::cout << "]" << std::endl;
}

void run(std::vector<int> vec, int k) {
    auto s = std::make_unique<Solution>();
    printVector(s->topKFrequent(vec, k));
}


int main() {
    run({1,1,1,2,2,3}, 2);
    run({1}, 1);
    run({1, 2}, 2);
    return 0;
}
