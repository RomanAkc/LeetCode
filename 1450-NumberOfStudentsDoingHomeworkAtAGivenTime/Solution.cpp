//
// Created by roman on 08.02.23.
//

#include "Solution.h"

int Solution::busyStudent(std::vector<int> &startTime, std::vector<int> &endTime, int queryTime) {
    int counter = 0;

    for(int i = 0; i < startTime.size(); ++i) {
        if(startTime[i] <= queryTime && queryTime <= endTime[i]) {
            counter++;
        }
    }

    return counter;
}
