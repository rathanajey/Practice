public class DiagonalBinarySearch{

	public Coordinate findCoordinate(int[][] array, int num, int rowStart, int rowEnd, int  colStart, int colEnd){
		if(num<array[rowStart][colStart] | num>array[rowEnd][colEnd]){
			return null;
		}
		int i=rowStart;
		int j= colStart;
		for(i=rowStart; i<=rowEnd; i++){
				if(array[i][j]==num){
					System.out.println(num+" = "+ array[i][i]);
					return new Coordinate(i, j);
				}
				if(num>array[i][j]){
					System.out.println(num+" > "+ array[i][i]);
					if(i<rowEnd && j==colEnd){
						return findCoordinate(array, num, i+1, rowEnd, colStart, colEnd);
					}
					if(j<colEnd && i==rowEnd){
						return findCoordinate(array, num, rowStart, rowEnd, j+1, colEnd);
					}
					j++;
					continue;
				}
				else{
					System.out.println(num+" < "+ array[i][i]);
					System.out.println(i+" "+rowEnd);
					Coordinate result=findCoordinate(array, num, i, rowEnd, 0, j-1);
					if(result!=null){
						return result;
					}
					return findCoordinate(array, num, 0, i-1, j, colEnd);	
				}
		}
		return null;
	}
	
	public static void main(String[] args){
		int[][] array=new int[4][6];
		array[0][0] = 15; array[0][1] = 20; array[0][2] = 70; array[0][3] = 85; array[0][4]= 90; array[0][5]= 97;
		array[1][0] = 25; array[1][1] = 35; array[1][2] = 80; array[1][3] = 103; array[1][4]= 108; array[1][5]= 118;
		array[2][0] = 30; array[2][1] = 55; array[2][2] = 95; array[2][3] = 105; array[2][4]= 110; array[2][5]= 135;
		array[3][0] = 40; array[3][1] = 80; array[3][2] = 100; array[3][3] = 120; array[3][4]= 125; array[3][5]= 140;
		DiagonalBinarySearch obj=new DiagonalBinarySearch();
		Coordinate result=obj.findCoordinate(array, 20, 0, 3, 0, 5);
		if(result!=null){
			System.out.println("Row = "+result.row+" column = "+result.column);
		}
		else{
			System.out.println("Null");
		}
		

	}
}

class Coordinate{
	int row;
	int column;

	Coordinate(int row, int column){
		this.row=row;
		this.column=column;
	}
}