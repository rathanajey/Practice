class BSTFromArray{
	
	public Node convertArrayToTree(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		Node root = helper(0, arr.length - 1, arr);
		return root;
	}

	public Node helper(int left, int right, int[] arr){
		if(left > right){
			return null;
		}

		int mid = (left + right) / 2;
		Node root = new Node(arr[mid]);

		Node leftNode = helper(left, mid - 1, arr);
		Node rightNode = helper(mid + 1, right, arr);

		root.left = leftNode;
		root.right = rightNode;

		return root;
	}

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7};

		BSTFromArray obj = new BSTFromArray();

		Node root = obj.convertArrayToTree(arr);

		System.out.println(root.value);
		System.out.println(root.left.value);
		System.out.println(root.right.value);
	}
}