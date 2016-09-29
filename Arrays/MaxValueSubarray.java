import java.util.*;
import java.util.Arrays;
import java.lang.Math;

class MaxValueSubarray{
	
	int maxProduct(int arr[]){
		int curMax=arr[0], curMin=arr[0], prevMax=arr[0], prevMin=arr[0];
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]==0){
				prevMax=1;
				prevMin=1;
				continue;
			}
			if(arr[i]>0){
				curMax=Math.max(prevMax*arr[i],arr[i]);
				prevMax=curMax;
				curMin=Math.min(prevMin*arr[i],arr[i]);
				prevMin=curMin;
			}
			else{
				curMin=Math.min(prevMax*arr[i],arr[i]);
				curMax=Math.max(prevMin*arr[i],arr[i]);
				prevMax=curMax;
				prevMin=curMin;
			}			
			max=Math.max(max,curMax);
		}
		return max;
	}
	
	public int maxSum(int[] arr){
		int sum=0, maxSum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
			if(sum>maxSum) maxSum=sum;
			else if(sum<0) sum=0;
			}
		return maxSum;
	}

	public static void main(String args[]){
		int arr[]={1,-2,-3,0,7,-8,-2};
		MaxValueSubarray obj=new MaxValueSubarray();
		System.out.println("Max Product= "+obj.maxProduct(arr));
		System.out.println("Max Sum= "+obj.maxSum(arr));
	}
}
/*
a[0]=2
px=8,pm=4,m=8
pm=-8, px=-4, m=8


*/