import java.util.ArrayList;

class MaxHeap{

	ArrayList<Integer> maxHeap;

	public MaxHeap(int[] arr){
		maxHeap = new ArrayList<Integer>();;
		for(int i:arr){
			maxHeap.add(i);
		}
		buildHeap();
	} 

	public void buildHeap(){
		int heapifyIndex = Math.max((maxHeap.size()/2) - 1, 0);

		for(int index = heapifyIndex; index>=0; index--){
			heapify(index);
		}
	}

	public void insert(int num){
		maxHeap.add(num);
		int heapifyIndex = Math.max((maxHeap.size()/2) - 1, 0);

		for(int index = heapifyIndex; index>=0; index = (index - 1) /2){
			heapify(index);
			if(index == 0){
				break;
			}
		}
	}

	public int removeMax(){
		int max = maxHeap.get(0);
		maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
		maxHeap.remove(maxHeap.size() - 1);
		heapify(0);
		return max;
	}

	public void heapify(int index){
		int left = 2 * index + 1;
		int right = left + 1;
		int largestIndex = index;

		if(left <= maxHeap.size() - 1 && maxHeap.get(left) > maxHeap.get(index)){
			largestIndex = left;
		}

		if(right <= maxHeap.size() - 1 && maxHeap.get(right) > maxHeap.get(largestIndex)){
			largestIndex = right;
		}

		if(largestIndex != index){
			int temp = maxHeap.get(index);
			maxHeap.set(index, maxHeap.get(largestIndex));
			maxHeap.set(largestIndex, temp);
			heapify(largestIndex);
		}
	}

	public void printHeap(){
		for(int i:maxHeap){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		MaxHeap obj = new MaxHeap(arr);
		obj.printHeap(); // 5 4 3 1 2
		obj.removeMax();
		obj.printHeap(); // 4 2 3 1
		obj.removeMax();
		obj.printHeap(); // 3 2 1
		obj.insert(9);
		obj.printHeap(); // 9 3 1 2
		obj.insert(11);
		obj.printHeap(); // 11 9 1 2 3
		obj.insert(13);
		obj.printHeap(); // 13 9 11 2 3 1
	}

}