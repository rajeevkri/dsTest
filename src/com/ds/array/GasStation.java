package com.ds.array;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        //First we will declare the variables which were start, end
        int start = 0;
        int end = 1;
        //Initially the first value of curr will be the cost incur to go to //the next location
        int curr = gas[0] - cost[0];
        //Running a loop till  starts meets end, meaning till our cycle gets //completed
        while (start != end && end<cost.length) {
        //If the curr value is negative, then keep incrementing the start //till it became positive
            while (curr < 0 && start != end) {
                //We need to remove the value of current start that we have added //before
                curr = curr - (gas[start] - cost[start]);
                start = (start + 1) % gas.length;
                //If we again come back to start, that means no solution exist and //we return -1
                if (start == 0)
                    return -1;
            }
            //Adding the gas that we got after visiting the current index
            curr += gas[end] - cost[end];
            end = (end + 1) % gas.length;
        }
        //If in the end, curr became negative that means it was impossible //to traverse  all the location and hence return -1
        if (curr < 0)
            return -1;
        //If that's not the case, then we got the answer.
        return start;

    }

}
