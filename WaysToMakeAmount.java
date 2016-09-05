class WaysToMakeAmount{
	
	public static int ways(int[] denom, int amount){

		int[] waysToAmounts = new int[amount + 1];
		waysToAmounts[0] = 1;
		int ways = 0;

		for(int i=1; i<=amount; i++){
			int denomIndex = 0;
			ways = 0;
			for(denomIndex = denomIndex; denomIndex < denom.length; denomIndex++){

				// for(int j = 1; j * denom[denomIndex] <= i; j++){
				// 	ways = ways + waysToAmounts[ i - j * denom[denomIndex]];
				// }
				if (i - denom[denomIndex] >= 0) {
					waysToAmounts[i] = waysToAmounts[i] + waysToAmounts[i - denom[denomIndex]];
					System.out.println("i = "+ i + "   denom = " + denom[denomIndex] + "  ways = " + waysToAmounts[i]);
				}
			}

		}

		return waysToAmounts[amount];
	}

	public static void main(String[] args){

		int[] denom = {1, 2, 3};
		int amount = 4;

		System.out.println(ways(denom, amount));

	}
}