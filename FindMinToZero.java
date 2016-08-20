import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

public class FindMinToZero {
	
	
	
	public static void main(String args[]){
		int arr[]={-31, -22, -13, -14};
		Arrays.sort(arr);
		int start=0, end=arr.length-1;
		int val1=0, val2=0;
		int min=Math.abs(arr[start]+arr[end]);
		while(end>start){
			//System.out.println("val1 and val2"+val1+" "+val2);
			System.out.println("start and end"+arr[start]+" "+arr[end]);
			if(Math.abs(arr[start]+arr[end])<=min){				
				min=Math.abs(arr[start]+arr[end]);
				System.out.println("Min is:"+min);
				val1=arr[start];
				val2=arr[end];
				end--;
			}
			else{
				if(arr[end]<0){
				++start;
				end=arr.length-1;
				}
				else end--;
			}
		}
		System.out.println("The values are:"+val1+" "+val2);
	}
}
