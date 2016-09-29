import java.util.ArrayList;

class EightQueens{
	

	public static ArrayList<Integer[]> getBoards(){
		ArrayList<Integer[]> results = getBoardsUtil(0, new Integer[8], new ArrayList<Integer[]>());

		return results;
	}

	public static ArrayList<Integer[]> getBoardsUtil(int row, Integer[] board, ArrayList<Integer[]> results){
		System.out.println("In getBoardsUtil: row = " + row);
		if(row == 8){
			results.add(board.clone());
		}
		else{
			for(int col = 0; col < 8; col++){
				if(isValid(row, col, board)){
					System.out.println("Adding col = " + col);
					board[row] = col;
					results = getBoardsUtil(row + 1, board, results);
				}
			}
		}

		return results;
	}

	public static boolean isValid(int row, int col, Integer[] board){

		for(int row1 = 0; row1 < row; row1++){
			int col1 = board[row1];

			if(col1 == col || (row - row1 == Math.abs(col - col1))){
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args){
		for(Integer[] arr:getBoards()){
			for(int i:arr){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}