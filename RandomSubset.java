import java.util.*;
import java.util.Arrays;
import java.lang.Math;

public class RandomSubset{
	
	public static void main(String arg[]){
		int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int m=5,rand=0;
		double randVal;
		int[] subset=new int[m];
		for(int i=0;i<m;i++){
			subset[i]=arr[i];
		}
		for(int i=m;i<arr.length;i++){
			randVal=Math.random();
			System.out.println("RandVal="+randVal);
			rand=(int)(randVal * ((i-0)+1)+0);
			if(rand<m){
				subset[rand]=arr[i];
			}
		}
		for(int i:subset){
		System.out.print(i+" ");
		}
	}
}