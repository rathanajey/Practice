package random;

/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
public class StampDispenser
{
	int[] stampDenominations; // array to store stamp denominations.
	int denomLen; // variable to store length of the stamp demoniations array.
   
    public StampDispenser(int[] stampDenominations)
    {
    	this.stampDenominations=stampDenominations; // stamp denominations array is stored to this objects variable.
    	this.denomLen=stampDenominations.length; // length of the provided array is obtained and stored.  	
    }
     
    public int calcMinNumStampsToFillRequest(int request)
    {  
    	if(denomLen<1) return -1; // checking whether there is at least one denomination in the array. If not it returns -1.
    	boolean hasDenomOne=false;
    	for(int i=0;i<denomLen-1;i++){
    		if(stampDenominations[i]==1|stampDenominations[i+1]==1) hasDenomOne=true; // this condition checks whether the array has denomination 1. If yes it flags the variable as true.
    		if(stampDenominations[i]<stampDenominations[i+1]) { // this condition checks whether the array is in descending order. If not it returns -1.
    			System.out.println("Stamp denominations not in decreasing order");
    			return -1;
    		} 		
    	}
    	if(hasDenomOne==false){ // checks whether the flag signifying demonination value 1 was set. If not it returns -1.
    		System.out.println("Denomination 1 not present in denomination types");
			return -1;
    	}
    	
    	int[] minStampsForValue=new int[request+1]; // Array to hold the minimum number of stamps needed for a request value in range from 0 to value.
    	minStampsForValue[0]=0; // Setting base case here. Number of stamps to make request 0 is 0.
    	int[] minStampsUsingDenomForValue=new int[denomLen]; // Array to hold the number of stamps needed to make this value using this denomination.
    	
    	for(int value=1;value<=request;value++){ // This loop is for calculating minimum number of stamps for the value of variable "value". The range of "value" here is from 1 to request.
    		
    		for(int i=0;i<denomLen;i++){ // Loop for calculating the number of stamps needed to make this value using the denomination in index "i".
    			if(value>=stampDenominations[i]){
    				minStampsUsingDenomForValue[i]=minStampsForValue[value-stampDenominations[i]]+1; // This adds 1 to the number of stamps needed to make a request of value=value-current denomination, Since using this stamp-denomination counts as 1 stamp.
    			}
    		}
    		
    		minStampsForValue[value]=0; // Setting this value to 0 so that we set and compare minimum values.
    		for(int i=0;i<denomLen;i++){ // This loop is for setting the denomination value,
    			if(minStampsUsingDenomForValue[i]>0){ // This checks whether this denomination could be used for making this value.
    				if(minStampsForValue[value]==0){
    					minStampsForValue[value]=minStampsUsingDenomForValue[i]; // Setting the minimum number of stamps necessary, the first time we find that demoniation could be used to make this value.  
    				}
    				if(minStampsUsingDenomForValue[i]<minStampsForValue[value]){
    					minStampsForValue[value]=minStampsUsingDenomForValue[i]; // Compares whether this current denomination used lesses stamps to make the value versus the previous denominations. Sets the minimum of these values.
    				}
    			}
    		}
    	}
        return minStampsForValue[request]; // returns the minimum number of stamps needed for making the request.
    }
    
    public static void main(String[] args)
    {
        int[] denominations = { 90, 30, 24, 10, 6, 2, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;
        int num=stampDispenser.calcMinNumStampsToFillRequest(18);
        System.out.println(num);
    }
}

