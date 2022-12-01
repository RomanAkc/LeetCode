//
// Created by roman on 02.12.22.
//

#ifndef FINDALLANAGRAMSINASTRINGCPP_SOLUTION_H
#define FINDALLANAGRAMSINASTRINGCPP_SOLUTION_H

#include <vector>
#include <string>
#include <unordered_set>
#include <set>
#include <cstring>
#include <algorithm>

class Solution {
private:
    bool isEqual(int charCount1[],int charCount2[]) {
        for(int i=0;i<26;i++) {
            if(charCount1[i]!=charCount2[i]) {
                return false;
            }
        }
        return true;
    }

public:
    std::vector<int> findAnagrams(std::string s, std::string p) {
        if(p.length() > s.length())
            return {};

        std::vector<int> res;
        int charCount1[26],charCount2[26];
        memset(charCount1,0,sizeof(charCount1));
        memset(charCount2,0,sizeof(charCount2));
        for(auto x: p) {
            charCount2[x-'a']++;
        }
        int n=s.size(),k=p.size(),i;

        i=0;
        for(;i<k;i++) {
            charCount1[s[i] - 'a']++;
        }
        if(isEqual(charCount1,charCount2))
            res.push_back(0);
        for(;i<n;i++) {
            charCount1[s[i - k] - 'a']--;
            charCount1[s[i] - 'a']++;
            if(isEqual(charCount1,charCount2)) {
                res.push_back(i-k+1);
            }
        }
        return res;
    }

    std::vector<int> findAnagrams_unordered(std::string s, std::string p) {
        std::vector<int> vecResult;

        std::sort(p.begin(), p.end());
        std::size_t k = p.length();
        std::unordered_multiset<char> pData(p.begin(), p.end());

        std::unordered_multiset<char> sData;
        for(std::size_t i = 0; i < s.length(); ++i) {
            if(i < k) {
                sData.insert(s[i]);
                continue;
            }

            if(sData == pData)
                vecResult.push_back(i - k);

            sData.erase(sData.find(s[i - k]));

            sData.insert(s[i]);
        }

        if(sData == pData)
            vecResult.push_back(s.length() - k);

        return vecResult;
    }

    std::vector<int> findAnagrams_set(std::string s, std::string p) {
        std::vector<int> vecResult;

        std::sort(p.begin(), p.end());
        std::size_t k = p.length();
        std::multiset<char> pData(p.begin(), p.end());

        std::multiset<char> sData;
        for(std::size_t i = 0; i < s.length(); ++i) {
            if(i < k) {
                sData.insert(s[i]);
                continue;
            }

            if(sData == pData)
                vecResult.push_back(i - k);

            sData.erase(sData.find(s[i - k]));

            sData.insert(s[i]);
        }

        if(sData == pData)
            vecResult.push_back(s.length() - k);

        return vecResult;
    }
};

#endif //FINDALLANAGRAMSINASTRINGCPP_SOLUTION_H
