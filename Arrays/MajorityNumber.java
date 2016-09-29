
public class MajorityNumber {
	
	public boolean isMajority(int arr[], int n, int x){
		for(int i=0;i<n;i++){
			//System.out.println("i = "+ i);
		    if(arr[i] == x && (i+n/2) <= n - 1 && arr[i+n/2] == x){
		           return true;
		    }
		}
		
		return false;
	}
	
	public boolean isMajoritySearch(int arr[], int n, int x){
		int firstOccurance = getFirstOccurance(arr, 0, n-1, x);
		//System.out.println("First Occurance = " + firstOccurance);
		
		if(firstOccurance >=0 && (firstOccurance + n/2) <= n - 1 && arr[firstOccurance + n/2] == x) {
			return true;
		}
		
		return false;
		
	}
	
	public int getFirstOccurance(int arr[], int left, int right, int x){
		
		//check whether partitioning is possible.
		if(left <= right){
			int mid = (left + right)/2;
			
			// Evaluates to true, if arr[mid] is x, and either mid is first element of array or arr[mid-1] is less thatn x. This means mid is first occurance of x.
			if(arr[mid] == x && (mid == 0 || arr[mid-1]<x)){
				return mid;
			}
			// Comes to this line if arr[mid] > x, or if arr[mid] = x and mid != 0 or arr[mid-1] is also x. That means arr[mid] is not the first occurance of x.
			else if(arr[mid] >= x){
				return getFirstOccurance(arr, left, mid-1, x);
			}
			// when arr[mid] is < x, need to look at the right side to find first occurance of x.
			else{
				return getFirstOccurance(arr, mid+1, right, x);
			}
		}
		
		// if x does not occur at all.
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = {1,2,3,3,3,3,6};
		MajorityNumber obj = new MajorityNumber();
		
		boolean result = obj.isMajority(arr, arr.length, 3);
		System.out.println(result);
		
		result = obj.isMajoritySearch(arr, arr.length, 3);
		System.out.println(result);

	}

}
