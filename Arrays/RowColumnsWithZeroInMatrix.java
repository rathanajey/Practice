class RowColumnsWithZeroInMatrix{
	public static void main(String[] args){
		int[][] arr= {
			{1,0,3,4},
			{5,6,7,8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
		};

		int n =4;

		for(int i =0; i < n; i++){
			for(int j = 0; j <n; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();

		boolean zeroInRow0 = false;
		boolean zeroInCol0 = false;

		for(int i = 0; i < arr.length; i++){
			if(arr[0][i] == 0){
				zeroInRow0 = true;
			}

			if(arr[i][0] == 0){
				zeroInCol0 = true;
			}

			if(zeroInCol0 == true && zeroInRow0 == true){
				break;
			}
		}

		for(int i = 1; i < arr.length; i++){
			for(int j = 1; j < arr.length; j++){
				if(arr[i][j] == 0){
					arr[0][j] = 0;
					arr[i][0] = 0;
				}
			}
		}

		// Nullify

		for(int i =0; i < arr.length; i++){
			if(arr[0][i] == 0){
				for(int j = 1; j < arr.length; j++){
					arr[j][i] = 0;
				}
			}

			if(arr[i][0] == 0){
				for(int j = 1; j < arr.length; j++){
					arr[i][j] = 0;
				}
			}
		}

		if(zeroInRow0){
			for(int i =0; i < arr.length; i++){
				arr[0][i] = 0;
			}
		}

		if(zeroInCol0){
			for(int i =0; i < arr.length; i++){
				arr[i][0] = 0;
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



// Hold vars for first row and column
// traverse entire matrix, when a cell is zero, set 0 in first row and column