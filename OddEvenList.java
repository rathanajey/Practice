public class OddEvenList{

	public Node getOddEvenList(Node head){
		if(head==null){
			return null;
		}
		Node odd=head;
		Node even=head.right;
		Node firstEven=even;
		if(even==null || even.right==null){
			return head;
		}
		while(true){
			odd.right=even.right;
			odd=even.right;
			if(odd.right==null){
				break;
			}
			even.right=odd.right;
			even=odd.right;
			if(even.right==null){
				break;
			}
		}
		odd.right=firstEven;
		return head;

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
		//one.setLeft(two);
		one.setRight(two);
		//two.setLeft(four);
		two.setRight(three);
		//three.setLeft(six);
		three.setRight(four);
		//four.setLeft(eight);
		four.setRight(five);
		//five.setLeft(ten);
		five.setRight(six);
		//six.setLeft(twelve);
		six.setRight(seven);
		//seven.setLeft(fourteen);
		seven.setRight(eight);
		OddEvenList obj=new OddEvenList();
		Node node=obj.getOddEvenList(one);
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