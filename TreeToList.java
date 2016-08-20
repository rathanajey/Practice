public class TreeToList{

	/* Aim for circular list.
	Case 1: node is null return null;
	case 2: right and left are null, return circular node
	case 3: if right is null, tail is node, else tail is right.left
	case 4: if right is null, connect(node, left)
			if right is not null, connect (node, right)
	case 5: if left is null, connect (right.left, node)
			if left is not null, conenct(left.left, node)
	case 6: determine tail
	return head
	*/

	public Node covertTreeToList(Node root){
		if(root==null){
			return null;
		}
		Node head=convertTreeToListHelper(root);
		head.left.right=null;
		head.left=null;
		return head;
	}

	public Node convertTreeToListHelper(Node node){
		if(node==null){
			return null;
		}
		Node leftSide=convertTreeToListHelper(node.left);
		Node rightSide=convertTreeToListHelper(node.right);
		Node tail=rightSide==null?null:rightSide.left;
		if(leftSide==null && rightSide==null){
			node.left=node;
			node.right=node;
			return node;
		}
		if(rightSide==null){
			connect(node, leftSide);
		}
		else{
			connect(node, rightSide);
		}
		if(leftSide==null){
			connect(rightSide.left, node);
		}
		else{
			connect(leftSide.left, node);
		}
		if(leftSide!=null && rightSide!=null){
			connect(tail, leftSide);
		}
		return(leftSide==null?node:leftSide);
	}

	public void connect(Node a, Node b){
		a.right=b;
		b.left=a;
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
		TreeToList obj=new TreeToList();
		Node node=obj.covertTreeToList(one);
		while(node!=null){
			System.out.println(node.value+", ");
			node=node.right;
		}
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