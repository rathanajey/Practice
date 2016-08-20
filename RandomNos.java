import java.util.*;
import java.util.Arrays;
import java.lang.Math;

public class RandomNos{
	public static void main(String args[]){
		int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int rand=0, temp=0;
		double randVal=0.0;
		for(int i=0;i<15;i++){
			randVal=Math.random();
			System.out.println("RandVal="+randVal);
			rand=(int)(randVal * ((i-0)+1)+0);
			System.out.println("Total rand="+rand);
			temp=arr[i];
			arr[i]=arr[rand];
			arr[rand]=temp;
			for(int j:arr){
			System.out.print(j+" ");
			}
		}
		System.out.println("________________________");
		for(int i:arr){
		System.out.println(i);
		}
	}
}