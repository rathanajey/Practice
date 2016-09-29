import java.util.*;

class WordBreak{
	
	Set<String> dict;
	WordBreak(){
		dict=new HashSet<String>();
		dict.add("i");
		dict.add("like");
		dict.add("sam");
		dict.add("sung");
		dict.add("samsung");
	}
	
	boolean checkBreak(String str){
		int size=str.length();
		if(size==0|size==1) return false;
		if(str.equals("")) return false;
		int[] table=new int[size+1];
		String res="";
		for(int i=1;i<=size;i++){
			//res="";
			if(table[i]==0 & dict.contains(str.substring(0,i))){
				table[i]=1;
				res=res+str.substring(0,i)+" ";
			}
			if(table[i]==1){
				if(i==size) return true;
				for(int j=i+1;j<=size;j++){
					System.out.println("i ="+i+"  j="+j);
					if(table[j]==0 && dict.contains(str.substring(i,j))){
						table[j]=1;
						res=res+str.substring(i,j)+" ";
						System.out.println(res);
					}
					if(j==size && table[j]==1){
						return true;
					}
				}
			}			
		}
		return false;
	}
	
	public static void main(String args[]){
		WordBreak obj=new WordBreak();
		if(obj.checkBreak("ilike")){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
		if(obj.checkBreak("iisit")){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
		if(obj.checkBreak("ilikesam")){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}

		if(obj.checkBreak("samsung")){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
		if(obj.checkBreak("estoor")){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
		if(obj.checkBreak("ilikesamsung")){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
	}
}