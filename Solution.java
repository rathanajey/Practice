import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {

	public static class Movie{
        private final int movieId;
        private final float rating;
        private List<Movie> similarMovies; // Similarity is bidirectional

        public Movie(int movieId, float rating) {
            this.movieId = movieId;
            this.rating = rating;
            similarMovies = new ArrayList<Movie>();
        }
        
        public int getId() {
            return movieId;
        }

        public float getRating() {
            return rating;
        }

        public void addSimilarMovie(Movie movie) {
            similarMovies.add(movie);
            movie.similarMovies.add(this);
        }

        public List<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }
	
    public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
    	
    	if(numTopRatedSimilarMovies == 0) return new ArrayList<Movie>();
    	
        PriorityQueue<Movie> result = new PriorityQueue<Movie>(new MovieComparator());
        
        Queue<Movie> movieQueue = new LinkedList<Movie>();
        HashSet<Movie> visited=new HashSet<Movie>();
        
        movieQueue.add(movie);
        visited.add(movie);
        List<Movie> similars=null;
        
        Movie current = null;
        
		while(!movieQueue.isEmpty()){
			current=movieQueue.remove();
			System.out.println("Deque from movieQueue = " + current.getId());
			similars=current.getSimilarMovies();
			
			for(Movie similarMovie:similars){
				System.out.println("similar = " + similarMovie.getId());
				if(!visited.contains(similarMovie)){
					visited.add(similarMovie);
					movieQueue.add(similarMovie);
					
					if(similarMovie != movie){
						if(!result.isEmpty()){
							if(result.size() == numTopRatedSimilarMovies){
								Movie lowestRating = result.peek();
								if(lowestRating.getRating() < similarMovie.getRating()){
									System.out.println("resultSizeLimit Adding to resultQueue = " + similarMovie.getId());
									result.poll();
									result.add(similarMovie);
								}
							}
							else {
								System.out.println("resultSizeLess Adding to resultQueue = " + similarMovie.getId());
								result.add(similarMovie);
							}
						}
						else{
							System.out.println("resultSizeEmpty Adding to resultQueue = " + similarMovie.getId());
							result.add(similarMovie);
						}
					}				
				}				
			}
		}
		
		List<Movie> resutlList = new ArrayList<Movie>();
		for(Movie m:result){
			resutlList.add(m);
		}
        
        return resutlList;
    }
    
    static class MovieComparator implements Comparator<Movie>{

		@Override
		public int compare(Movie o1, Movie o2) {
    		if(o1.getRating() - o2.getRating() < 0){
    			return -1;
    		}
    		else return 1;
			// TODO Auto-generated method stub
		}

    }

	public static void main(String[] args) {
		Solution obj = new Solution();
		Movie d = new Movie(4, 4.8f);
		Movie c = new Movie(3, 2.4f);
		Movie b = new Movie(2, 3.6f);
		Movie a = new Movie(1, 1.2f);
		Movie e = new Movie(5, 8.2f);
		
		c.addSimilarMovie(d);
		b.addSimilarMovie(d);
		a.addSimilarMovie(b);
		a.addSimilarMovie(c);
		d.addSimilarMovie(e);
		
		List<Movie> result = Solution.getMovieRecommendations(a, 3);
		for(Movie m: result){
			System.out.println(m.getId());
		}
	}

}
