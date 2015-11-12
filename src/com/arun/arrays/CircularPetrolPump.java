package com.arun.arrays;

public class CircularPetrolPump {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null) return -1;

        int total = 0;
        int upToNow = 0;
        int startPos = 0;
        for(int i=0; i<gas.length; i++) {
            int delta = gas[i] - cost[i];
            if(upToNow >= 0)    upToNow += delta;
            else {
                upToNow = delta;
                startPos = i;
            }
            total += delta;
        }

        return total >= 0 ? startPos : -1;
    }
    
    public static void main(String[] args) {
    	int[] gas = {6,3,7};
    	int[] cost = {4,6,3};
    	CircularPetrolPump cpp = new CircularPetrolPump();
    	System.out.println(cpp.canCompleteCircuit(gas, cost));
    }
}