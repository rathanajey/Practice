public class MorrisTraversal{
	/*
	when current.left==null, print current and make current = its right.
	Find the predecessor of a node and make current as pred.right
	
	*/

	public void traverse(Node root){
		Node pred, current;
		current=root;
		int rank=10;
		int rankCount=1;
		while(current!=null){
			if(current.left==null){
				if(rankCount==rank){
						System.out.print(current.value+" ");
						break;
				}
				rankCount++;
				current=current.right;
			}
			else{
				pred=current.left;
				while(pred.right!=null && pred.right!=current){
					pred=pred.right;
				}

				if(pred.right==null){
					pred.right=current;
					current=current.left;
				}
				else{
					pred.right=null;
					if(rankCount==rank){
						System.out.print(current.value+" ");
						break;
					}
					rankCount++;
					current=current.right;
				}
			}
		}
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
		eight.setLeft(four);
		eight.setRight(twelve);
		four.setLeft(two);
		four.setRight(six);
		two.setLeft(one);
		two.setRight(three);
		six.setLeft(five);
		six.setRight(seven);
		twelve.setLeft(ten);
		twelve.setRight(fourteen);
		ten.setLeft(nine);
		ten.setRight(eleven);
		fourteen.setLeft(thirteen);
		fourteen.setRight(fifteen);
		MorrisTraversal obj=new MorrisTraversal();
		System.out.println("Morris Traversal: ");
		obj.traverse(eight);
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