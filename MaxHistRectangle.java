import java.util.Stack;

class MaxHistRectangle{
	
	public static int maxRectangle(int[] arr){

		Stack<Integer> stack = new Stack<Integer>();
		int length = arr.length;

		int max = 0, area = 0, top = 0, i = 0;

		while(i < length){
			if(stack.isEmpty() || arr[i] >= arr[stack.peek()]){
				stack.push(i);
				i++;
			}
			else{
				top = stack.peek();
				stack.pop();
				area = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

				if(area > max){
					max = area;
				}
			}
		}

		while(!stack.isEmpty()){
			top = stack.peek();
			stack.pop();
			area = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

			if(area > max){
				max = area;
			}
		}

		return max;
	}

	public static void main(String[] args){
		int[] arr = {6, 4, 5, 4, 5, 1, 6};

		int max = maxRectangle(arr);

		System.out.println(max);
	}
}