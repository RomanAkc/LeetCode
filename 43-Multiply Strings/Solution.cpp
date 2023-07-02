//
// Created by roman on 02.07.23.
//
#include "Solution.h"

std::string Solution::multiply(std::string num1, std::string num2) {
    if(num1 == "0" || num2 == "0")
        return "0";

    std::vector<int> vecResult(num1.length() + num2.length(), 0);

    int maxLength = std::max(num1.length(), num2.length()) + 1;

    for(int i = num1.length() - 1; i >= 0; i--) {
        std::vector<int> vecCurrent(maxLength, 0);
        int remembered = 0;

        int j = num2.length() - 1;
        for(; j >= 0; j--) {


            auto n1 = num1[i] - '0';
            auto n2 = num2[j] - '0';

            int n = n1 * n2 + remembered;

            vecCurrent[maxLength - (num2.length() - j - 1) - 1] = n%10;

            remembered = n/10;
        }

        while(remembered != 0) {
            vecCurrent[maxLength - (num2.length() - j - 1) - 1] = remembered%10;
            remembered /= 10;
            j--;
        }

        int resultIndex = vecResult.size() - (num1.length() - i - 1) - 1;
        for(int k = vecCurrent.size() - 1; k >= 0; k--) {
            int n = vecResult[resultIndex] + vecCurrent[k] + remembered;

            vecResult[resultIndex] = n%10;

            remembered = n/10;
            resultIndex--;
        }

        while(remembered != 0) {
            vecResult[resultIndex] = remembered%10;
            remembered /= 10;
            resultIndex--;
        }
    }

    std::string sResult;
    bool bInLeadingZeros {true};
    for(int i = 0; i < vecResult.size(); ++i) {
        if(vecResult[i] != 0) {
            bInLeadingZeros = false;
        }

        if(bInLeadingZeros)
            continue;

        sResult += std::to_string(vecResult[i]);
    }


    return sResult;
}
