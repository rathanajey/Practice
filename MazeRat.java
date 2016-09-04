import java.util.HashMap;

class MazeRat{
	
	public static boolean isReachable(int[][] maze, int i, int j, int sourceJ, int sourceI, HashMap<String, Boolean> cache){

		if(i < 0 || j < 0 || maze[i][j] == 0){
			return false;
		}

		// System.out.println("i = " + i + "j=" + j);
		// System.out.println("value " + maze[i][j]);

		if(i == sourceI && j == sourceJ){
			return true;
		}

		if(cache.containsKey(i + ":" + j)){
			return cache.get(i + ":" + j);
		}

		boolean result = isReachable(maze, i, j - 1, sourceJ, sourceI, cache) || isReachable(maze, i - 1, j, sourceJ, sourceI, cache);
	
		cache.put(i + ":" + j, result);

		return result;
	}

	public static void main(String[] args){
		int[][] maze = {
			{1,0,0,0},
			{1,1,0,1},
			{0,1,0,1},
			{0,1,0,1},
			{0,0,0,1}
		};

		int destI = 4, destJ = 3;
		int sourceI = 0, sourceJ = 0;

		HashMap<String, Boolean> cache = new HashMap<String, Boolean>();

		boolean result = isReachable(maze, destI, destJ, sourceJ, sourceI, cache);

		System.out.println(result);
	}

}
