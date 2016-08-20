import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;
import java.util.Scanner;


public class InsertionSort {
 
    public static void insertIntoSorted(int[] ar) {
        // Fill up this function  
         int size=ar.length, temp=0;
        int val=ar[size-1];
        for(int i=size-2;i>=0;i--){
            if(val<ar[i]){
                ar[i+1]=ar[i];
            }
            else
            {
            	System.out.print("ELSE");
                ar[i+1]=val;break;
            }
            for(int j=0;j<size;j++){
            System.out.print(ar[j]+" ");
            }
            System.out.println();
        }	
        for(int i=0;i<size;i++){
            System.out.print("Final: "+ar[i]+" ");
            }
    }
    
    public static void main(String args[]){
    	
    	int[] ar={2,4,6,8,3};
    	insertIntoSorted(ar);
    	
    }
}