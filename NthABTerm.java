import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class NthABTerm{
	
	public ArrayList<String> permutations(String A, String B, ArrayList<String> permutes){
		if(permutes.isEmpty()) {
			permutes.add(A+B);
			permutes.add(B+A);
			return permutes;
		}

		ArrayList<String> newPermutes = new ArrayList<String>();

		for(String s:permutes){
			for(int i=0;i<=s.length();i++){
				String first=s.substring(0,i);
				String second=s.substring(i);
				if(!newPermutes.contains(first+A+second)){
					newPermutes.add(first+A+second);
				}
			}
		}

		permutes.clear();

		for(String s:newPermutes){
			for(int i=0;i<=s.length();i++){
				String first=s.substring(0,i);
				String second=s.substring(i);
				if(!permutes.contains(first+B+second)){
					permutes.add(first+B+second);
				}
			}
		}

		return permutes;
	}

	public static void main(String[] args){
		String A="3", B="5";
		int n=4;
		boolean nOrMore = false;
		ArrayList<String> oldPermutations = new ArrayList<String>();
		ArrayList<String> newPermutations = new ArrayList<String>();
		NthABTerm obj = new NthABTerm();
		while(!nOrMore){
			newPermutations = obj.permutations(A, B, newPermutations);
			System.out.println("The new permutations obtained are");
			for(String s:newPermutations){
				System.out.println(s);
			}
			for(String s: newPermutations){
				oldPermutations.add(s);	
			}

			System.out.println("The updated old permutations are");
			for(String s:oldPermutations){
				System.out.println(s);
			}
			if(oldPermutations.size() >= n){
				nOrMore = true;
			}
		}

		ArrayList<Integer> result = new ArrayList<Integer>();

		System.out.println("The list is:");
		for(String s:oldPermutations){
			result.add(Integer.parseInt(s));
		}

		//List<String> list = new ArrayList<String>(oldPermutations);
		Collections.sort(result);

		System.out.println(" A = " + A + "& B = "+B);

		System.out.println("The list is:");
		for(Integer s:result){
			System.out.println(s);
		}

		System.out.println("The 4th term = " + result.get(n-1));
	}
}