class RotateMatrix{

	public static void main(String[] args){
		int[][] arr= {
			{1,2,3,4},
			{5,6,7,8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
		};

		int n = 4;

		for(int i =0; i < n; i++){
			for(int j = 0; j <n; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();

		for(int i =0; i < n/2; i++){
			int lower = i;
			int upper = n - 1 - lower;

			for(int j = lower; j < upper; j++){
				int diff = j - lower;

				 int top = arr[lower][j];

				// int right = arr[j][lower];

				// int bottom = arr[upper][upper - diff];

				// int left = arr[upper - diff][lower];

				// int temp = right;

				 arr[lower][j] = arr[upper - diff][lower];

				 arr[upper - diff][lower] = arr[upper][upper - diff];

				 arr[upper][upper - diff] = arr[j][upper];

				 arr[j][upper] = top;

			}
		}

		for(int i =0; i < n; i++){
			for(int j = 0; j <n; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}