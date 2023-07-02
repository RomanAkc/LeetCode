#include <iostream>
#include "Solution.h"

int main() {
    Solution s;

    std::cout << s.multiply("2", "3") << std::endl;
    std::cout << s.multiply("123", "456") << std::endl;
    std::cout << s.multiply("98", "9") << std::endl;
    return 0;
}
