import java.lang.Integer;

class IsBTaBST{
		
	public boolean isBST(Node root){
		if(root == null) return false;

		boolean result = helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

		return result;
	}

	public boolean helper(Node root, int min, int max){
		if(root == null){
			return true;
		}

		if(root.value > min && root.value <= max){
			boolean leftBool = helper(root.left, min, root.value);

			if(!leftBool){
				return false;
			}

			boolean rightBool = helper(root.right, root.value, max);

			return rightBool;
		}

		return false;
	}

	public static void main(String[] args){
		Node one=new Node(8);
		Node two=new Node(4);
		Node three=new Node(12);
		Node four=new Node(2);
		Node five=new Node(6);
		Node six=new Node(10);
		Node seven=new Node(14);
		Node eight=new Node(1);
		Node nine=new Node(3);
		Node ten=new Node(5);
		Node eleven=new Node(7);
		Node twelve=new Node(9);
		Node thirteen=new Node(11);
		Node fourteen=new Node(13);
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

		IsBTaBST obj = new IsBTaBST();

		System.out.println(obj.isBST(one));

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