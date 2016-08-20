import java.util.*;
import java.util.Stack;

class BalExpression{
	
	
	public boolean checkExp(String str){
		Stack<Character> exps=new Stack<Character>();
		HashMap<Character, Character> map=new HashMap<Character, Character>();
		map.put(']','[');
		map.put('}','{');
		map.put(')','(');
		for(int i=0;i<=str.length()-1;i++){
			Character ch=str.charAt(i);
			if(map.containsValue(ch)){
				exps.push(ch);
				System.out.println("Pushed "+String.valueOf(ch));
			}
			else if(map.containsKey(ch)){
				if(exps.isEmpty()){
					System.out.println("Empty but string not traversed Exit");
					return false;
				}
				else{
					if(exps.peek()==map.get(ch)){
						Character ch1=exps.pop();
						System.out.println("Popped "+String.valueOf(ch1));
					}
					else{
						System.out.println("Unequal Exit");
						return false;
					}
				}
			}
		}
		if(exps.isEmpty()) return true;
		else{
			System.out.println("Not empty Exit");
			return false;
		} 
	}
	
	public static void main(String args[]){
		String exp="[()]{}{[()()]()}";
		String exp1="[()]{}{[()()]()";
		String exp2=")]{}{[()()]()}";
		BalExpression obj=new BalExpression();
		if(obj.checkExp(exp)){
			System.out.println("Valid");
		}
		else{
			System.out.println("Invalid");
		}
		
		if(obj.checkExp(exp1)){
			System.out.println("Valid");
		}
		else{
			System.out.println("Invalid");
		}
		
		if(obj.checkExp(exp2)){
			System.out.println("Valid");
		}
		else{
			System.out.println("Invalid");
		}
		
	}
}
