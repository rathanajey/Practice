public class LCATree{

	/* Use Result class, containing value and isAncestor.
	Case 1: node is P and Q.
	Case 2: Node is P or Q and a child is P or Q;
	Case 3: both children are not null
	case 4: node is P or Q and both children are null
	*/

	public Node findLCA(Node root, Node p, Node q){
		Result result = findLCAHelper(root, p,  q);
		if(result.isAncestor){
			return result.node;
		}
		return null;
	}

	public Result findLCAHelper(Node node, Node p, Node q){
		if(node==null){
			return new Result(null, false);
		}
		if(node==p && node==q){
			return new Result(node, true);
		}
		Result left=findLCAHelper(node.left, p, q);
		if(left.isAncestor==true){
			return left;
		}
		Result right=findLCAHelper(node.right, p, q);
		if(right.isAncestor==true){
			return right;
		}
		if(left.node!=null && right.node!=null){
			return new Result(node, true);
		}
		else if(left.node!=null | right.node!=null){
			if(node==p | node==q){
				return new Result(node, true);
			}
			else{
				if(left.node!=null){
					return left;
				}
				else{
					return right;
				}
			}
		}
		else{
			if(node==p | node==q){
				return new Result(node, false);
			}
			else{
				return new Result(null, false);
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
		Node sixteen=new Node(16);
		LCATree obj=new LCATree();
		Node node=obj.findLCA(one, seven, twelve);
		System.out.println("The LCA is "+node.value);
	}

}

class Result{
	Node node;
	boolean isAncestor;

	Result(Node node, boolean isAncestor){
		this.node=node;
		this.isAncestor=isAncestor;
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