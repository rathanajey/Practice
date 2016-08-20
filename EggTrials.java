public class EggTrials{
	
	public int countTrials(int eggs, int floors){
		int[][] dp=new int[eggs+1][floors+1];
		
		for(int i=0;i<=eggs;i++){
			dp[i][0]=0;
			dp[i][1]=1;
		}
		for(int i=0;i<=floors;i++){
			dp[1][i]=i;
		}
		for(int i=2;i<=eggs;i++){
			for(int j=2;j<=floors;j++){
				dp[i][j]=Integer.MAX_VALUE;
				for(int x=2;x<=j;x++){
					int val=1+Math.max(dp[i-1][x-1], dp[i][j-x]);
					if(val<dp[i][j]){
						dp[i][j]=val;
					}
				}
				
			}			
		}
		return dp[eggs][floors];
	}
	public static void main(String args[]){
		EggTrials obj=new EggTrials();
		System.out.println("Trials = "+obj.countTrials(4,100));
	}
}