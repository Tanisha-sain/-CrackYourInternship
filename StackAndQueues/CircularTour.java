//  Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
// 1. The amount of petrol that every petrol pump has.
// 2. Distance from that petrol pump to the next petrol pump.
// Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
// Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.


class Solution{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]){
	// Your code here
	    int n = petrol.length;
	    int deficit = 0;
	    int balance = 0;
	    int start = 0;
	    
	    for(int i = 0; i<n; i++){
	        balance += (petrol[i] - distance[i]);
	        if(balance < 0){
	            deficit += balance;
	            start = i+1;
	            balance = 0;
	        }
	    }
	    if(balance + deficit >= 0) return start;
	    return -1;
    }
}
