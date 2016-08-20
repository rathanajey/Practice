package recursionAndDP;

public class CountWaysUpSteps {

	public static int CountWaysDP(int n, int[] map){
		System.out.println("N at first entry is: "+n);
		if(n<0){ return 0;}
		else if(n==0){ return 1;}
		else if(map[n]>0){
			System.out.println("N at map value check is: "+n);
			return map[n];
		}
		else{
			System.out.println("N at second entry is: "+n);
			map[n]=CountWaysDP(n-1, map)+CountWaysDP(n-2, map)+CountWaysDP(n-3, map);
			return map[n];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 3;
		int[] array=new int[50];
		int ways=CountWaysDP(i, array);
		System.out.println("Ways are: "+ways);
	}

}
