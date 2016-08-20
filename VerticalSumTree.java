import java.util.List;
import java.util.LinkedList;
import java.lang.Integer;

public class VerticalSumTree{
	/* Use linkedlist where each node represents a line. 
	Add value to lnode
	Recurse left subtree
	Recurse right subtree
	For each left, got to node.prev
	For each right go to node.next
	*/

	public int maxSum(Node root){
		if(root==null){
			return Integer.MIN_VALUE;
		}
		List<LNode> list=new LinkedList<LNode>();
		LNode rootNode=new LNode(0);
		list.add(rootNode);
		list=maxSumHelper(root, rootNode, list);
		return findMaxLNode(list).value;
	}

	public List<LNode> maxSumHelper(Node node, LNode lnode, List<LNode> list){
		System.out.println("lnode value is "+lnode.value);
		System.out.println("Updat with "+node.value);
		lnode.value+=node.value;
		System.out.println("Updated lnode value is "+lnode.value);
		if(node.left!=null){
			if(lnode.prev==null){
				lnode.prev=new LNode(0);
				lnode.prev.next=lnode;
				list.add(lnode.prev);
			}
			list=maxSumHelper(node.left, lnode.prev, list);
		}
		if(node.right!=null){
			if(lnode.next==null){
				lnode.next=new LNode(0);
				lnode.next.prev=lnode;
				list.add(lnode.next);
			}
			list=maxSumHelper(node.right, lnode.next, list);
		}
		return list;
	}

	public LNode findMaxLNode(List<LNode> list){
		LNode maxNode=new LNode(Integer.MIN_VALUE);
		for(LNode lnode:list){
			if(lnode.value>maxNode.value){
				System.out.println("lnode value = "+lnode.value);
				maxNode=lnode;
			}
		}
		return maxNode;
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
		VerticalSumTree obj=new VerticalSumTree();
		System.out.println("Max node value = "+obj.maxSum(one));
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

class LNode{
	LNode prev;
	LNode next;
	int value;

	LNode(int value){
		this.value=value;
	}
}