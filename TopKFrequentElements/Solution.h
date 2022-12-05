//
// Created by roman on 05.12.22.
//

#ifndef TOPKFREQUENTELEMENTS_SOLUTION_H
#define TOPKFREQUENTELEMENTS_SOLUTION_H

#include <vector>
#include <unordered_map>
#include <map>

class Solution {
public:
    std::vector<int> topKFrequent(std::vector<int>& nums, int k) {
        std::unordered_map<int, int> mapValues;

        for(auto num : nums) {
            auto it = mapValues.find(num);
            if(it == mapValues.end())
                mapValues.emplace(num, 1);
            else
                it->second++;

            /*if(!mapValues.contains(num))
                mapValues.emplace(num, 1);
            else
                mapValues.at(num)++;*/
        }

        std::multimap<int, int> mapK;
        for(auto& [num, frequency] : mapValues) {
            if(mapK.size() < static_cast<int>(k)) {
                mapK.emplace(frequency, num);
            } else {
                if(frequency > mapK.begin()->first) {
                    mapK.erase(mapK.begin());
                    mapK.emplace(frequency, num);
                }

            }
        }

        std::vector<int> vecResult;
        for(auto& [frequency, num ] : mapK) {
            vecResult.emplace_back(num);
        }

        return vecResult;
    }
};

#endif //TOPKFREQUENTELEMENTS_SOLUTION_H
