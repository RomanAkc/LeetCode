#include <iostream>
#include <memory>
#include "Solution.h"

int main() {
    Solution* s = new Solution();

    std::vector<int> v0{4,5,6,7,0,1,2};
    std::cout << s->search(v0, 3) << std::endl;

    std::vector<int> v1{4,5,6,7,0,1,2};
    std::cout << s->search(v1, 0) << std::endl;

    std::vector<int> v2{4,5,6,7,0,1,2};
    std::cout << s->search(v2, 4) << std::endl;

    std::vector<int> v3{4,5,6,7,0,1,2};
    std::cout << s->search(v3, 2) << std::endl;

    std::vector<int> v4{1};
    std::cout << s->search(v4, 0) << std::endl;

    std::vector<int> v5{7,0,1,2,4,5,6};
    std::cout << s->search(v5, 2) << std::endl;

    std::vector<int> v6{7,0,1,2,4,5,6};
    std::cout << s->search(v6, 7) << std::endl;

    std::vector<int> v7{7,0,1,2,4,5,6};
    std::cout << s->search(v7, 6) << std::endl;

    std::vector<int> v8{7,0,1,2,4,5,6};
    std::cout << s->search(v8, 12) << std::endl;

    std::vector<int> v9{4,5,6,7,8,1,2,3};
    std::cout << s->search(v9, 8) << std::endl;



    delete s;
    return 0;
}
