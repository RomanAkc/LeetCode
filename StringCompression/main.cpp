#include <iostream>
#include <memory>
#include "Solution.h"

int main() {
    auto s = std::make_unique<Solution>();

    auto vec1 = std::vector<char>{'a','a','b','b','c','c','c'};
    std::cout << s->compress(vec1) << std::endl;

    auto vec2 = std::vector<char>{'a'};
    std::cout << s->compress(vec2) << std::endl;

    auto vec3 = std::vector<char>{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
    std::cout << s->compress(vec3) << std::endl;

    std::cout << s->compress_str("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB") << std::endl;
    return 0;
}
