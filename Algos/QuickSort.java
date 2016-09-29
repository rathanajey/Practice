package Algo;

public class QuickSort{
public int[] quicksort(int arr[], int first, int last)
{
 int i,j,pivot,temp;
 for(int k=0;k<arr.length;k++)
	{
		System.out.print(arr[k]+" ");
	}
	System.out.println("");
 if(first < last)
 {
   pivot = first;
   i = first;
   j = last;

   while(i < j)
   {
     while(arr[i] <= arr[pivot] && i < last)
        i++;
     while(arr[j] > arr[pivot])
        j--;
     if(i < j)
     {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
     }
   }

   for(int k=0;k<arr.length;k++)
	{
		System.out.print(arr[k]+" ");
	}
	System.out.println("--------------------------");
   temp = arr[pivot];
   arr[pivot] = arr[j];
   arr[j] = temp;
   for(int k=0;k<arr.length;k++)
	{
		System.out.print(arr[k]+" ");
	}
	System.out.println("--------------------------");
   quicksort(arr, first, j-1);
   quicksort(arr, j+1, last);
 }
 return arr;
}

public static void main(String args[])
{
	int a[]={12,54,2,14,78,1};
	System.out.println(a);
	QuickSort obj=new QuickSort();
	a=obj.quicksort(a, 0, 5);
	System.out.println(a);
	for(int i=0;i<a.length;i++)
	{
		System.out.println(a[i]);
	}
}
}