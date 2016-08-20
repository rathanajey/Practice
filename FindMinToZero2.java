import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

public class FindMinToZero2 {
	
	
	
	public static void main(String args[]){
		int arr[]={-12, 0, 0, 0, 0};
		Arrays.sort(arr);
		int start=0, end=arr.length-1;
		int val1=0, val2=0;
		int min=arr[start]+arr[end], temp=0;
		while(end>start){
			//System.out.println("val1 and val2"+val1+" "+val2);
			System.out.println("start and end"+arr[start]+" "+arr[end]);
			temp=arr[start]+arr[end];
			if(Math.abs(temp)<Math.abs(min)){
				min=temp;
				System.out.println("Min is:"+min);
				val1=arr[start];
				val2=arr[end];
				}
				if(min>0){
					end--;
				}
				else{
					start++;
				}
		}
		System.out.println("The values are:"+val1+" "+val2);
	}
}
