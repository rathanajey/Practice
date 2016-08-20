import java.util.Arrays;
import java.util.*;
import java.lang.Math;

public class WordDistance{
	
	public int minDistance(String[] words, String word1, String word2){
		int min=Integer.MAX_VALUE, distance=Integer.MAX_VALUE;
		int word1Pos=-1, word2Pos=-1;
		String current="";
		for(int i=0;i<words.length;i++){
			current=words[i];
			//if(current.equals(word1)&current.equals(word2))
			if(current.equals(word1)){
				word1Pos=i;
			}
			else if(current.equals(word2)){
				word2Pos=i;
			}
			if(word1Pos!=-1 && word2Pos!=-1)
			{
				distance=Math.abs(word1Pos-word2Pos);
				if(distance<min) min=distance;
			}			
		}
		return min;
		
	}
	
	public static void main(String args[]){
		String[] words={"hello","what","is","going","on","worse","hello","hamster","specific","chaos","hello","mellow","well","other","with","forms"};
		WordDistance obj=new WordDistance();
		int min=obj.minDistance(words,"hello","with");
		System.out.println("Min distance is "+min);
	}
	
}