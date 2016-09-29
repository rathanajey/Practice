public class ListToTree{
	/* Declare a static variable to track the head node.
	Find size of list.
	Base case is start>end
	Find midpoint
	recurse left for 0, mid-1
	create root node;
	change head to head.next
	recurse right for mid+1, end
	return root
	*/

	LNode current;

	public Node listToTree(LNode head){
		int listSize=getListSize(head);
		current=head;
		Node root=listToTree(1,listSize);
		return root;
	}

	public Node listToTree(int start, int end){
		if(end<start){
			return null;
		}
		int mid=end+start/2;
		Node left=listToTree(start, mid-1);
		Node root=new Node(current.value);
		root.left=left;
		current=current.next;
		Node right=listToTree(mid+1, end);
		root.right=right;
		return root;
	}

	public int getListSize(LNode head){
		if(head==null){
			return 0;
		}
		int size=1;
		while(head.next!=null){
			size++;
			head=head.next;
		}
		System.out.println("List Size = "+size);
		return size;
	}

	public void printTree(Node root){
		if(root==null){
			return;
		}
		printTree(root.left);
		System.out.println(root.value);
		printTree(root.right);
	}

	public static void main(String[] args){
		LNode one=new LNode(1);
		LNode two=new LNode(2);
		LNode three=new LNode(3);
		LNode four=new LNode(4);
		LNode five=new LNode(5);
		LNode six=new LNode(6);
		LNode seven=new LNode(7);
		one.next=two;
		two.next=three;
		three.next=four;
		four.next=five;
		five.next=six;
		six.next=seven;
		ListToTree obj=new ListToTree();
		Node root=obj.listToTree(one);
		obj.printTree(root);
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