import java.util.*;

public class BalTree{	

	public int checkBalanceHelper(Node node){
		if(node==null){
			return 0;
		}
		int leftHeight=checkBalanceHelper(node.left);
		if(leftHeight==-1){
			return -1;
		}
		int rightHeight=checkBalanceHelper(node.right);
		if(rightHeight==-1){
			return -1;
		}
		if(Math.abs(leftHeight-rightHeight)>1){
			return -1;
		}
		return Math.max(leftHeight, rightHeight)+1;
	}

	public boolean checkBalance(Node node){
		int result=checkBalanceHelper(node);
		if(result==-1){
			return false;
		}
		return true;
	}

	public static void main(String[] args){
		Node one=new Node(1);
		Node two=new Node(2);
		Node three=new Node(3);
		Node four=new Node(4);
		Node five=new Node(5);
		Node six=new Node(6);
		Node seven=new Node(7);
		Node eight=new Node(8);
		Node nine=new Node(9);
		Node ten=new Node(10);
		Node eleven=new Node(11);
		Node twelve=new Node(12);
		Node thirteen=new Node(13);
		Node fourteen=new Node(14);
		Node fifteen=new Node(15);
		Node sixteen=new Node(16);
		Node seventeen=new Node(17);
		Node eighteen=new Node(18);
		sixteen.setLeft(eighteen);
		eight.setLeft(sixteen);
		nine.setRight(seventeen);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		four.setLeft(eight);
		four.setRight(nine);
		five.setLeft(ten);
		five.setRight(eleven);
		six.setLeft(twelve);
		six.setRight(thirteen);
		seven.setLeft(fourteen);
		seven.setRight(fifteen);
		BalTree obj=new BalTree();
		System.out.println("The tree is balanced = "+obj.checkBalance(one));
	}
}

class Node{
	Node left;
	Node right;
	int value;

	Node(int value){
		this.value=value;
	}

	void setLeft(Node left){
		this.left=left;
	}

	void setRight(Node right){
		this.right=right;
	}

}