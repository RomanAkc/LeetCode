//
// Created by roman on 03.12.22.
//

#ifndef STRINGCOMPRESSION_SOLUTION_H
#define STRINGCOMPRESSION_SOLUTION_H

#include <vector>
#include <string>

class Solution {
public:
    int compress(std::vector<char>& chars) {
        if(chars.size() <= 1)
            return chars.size();

        char c = chars[0];
        int cnt = 1;
        int insert = 0;

        for(int i = 1; i < chars.size(); i++) {
            if(chars[i] != c) {
                if(cnt > 1) {
                    chars[insert++] = c;
                    auto sNum = std::to_string(cnt);
                    for(int j = 0; j < sNum.length(); ++j) {
                        chars[insert++] = sNum[j];
                    }
                    cnt = 1;
                    c = chars[i];
                } else {
                    chars[insert++] = c;
                    cnt = 1;
                    c = chars[i];
                }
            } else {
                cnt++;
            }
        }

        chars[insert++] = c;
        if(cnt > 1) {
            auto sNum = std::to_string(cnt);
            for(int j = 0; j < sNum.length(); ++j) {
                chars[insert++] = sNum[j];
            }
        }

        chars.resize(insert);
        return insert;
    }

    std::string compress_str(std::string s) {
        if(s.size() <= 1)
            return s;

        char c = s[0];
        int cnt = 1;
        int insert = 0;

        for(int i = 1; i < s.length(); i++) {
            if(s[i] != c) {
                if(cnt > 1) {
                    s[insert++] = c;
                    auto sNum = std::to_string(cnt);
                    for(int j = 0; j < sNum.length(); ++j) {
                        s[insert++] = sNum[j];
                    }
                    cnt = 1;
                    c = s[i];
                } else {
                    s[insert++] = c;
                    cnt = 1;
                    c = s[i];
                }
            } else {
                cnt++;
            }
        }

        s[insert++] = c;
        if(cnt > 1) {
            auto sNum = std::to_string(cnt);
            for(int j = 0; j < sNum.length(); ++j) {
                s[insert++] = sNum[j];
            }
        }

        s.resize(insert);

        return s;
    }
};

#endif //STRINGCOMPRESSION_SOLUTION_H
