class RankOfNum{

	private static RankNode root = null;

	public void track(int num){
		//if(num == null) return;

		RankNode node = new RankNode(num);

		if(root == null){
			root = node;
		}
		else{
			root.insert(node);	
		}	
	}

	public int getRankOfNum(int num){
		if(root == null) return -1;

		return root.getRank(num);
	}

	public static void main(String[] args){
		RankOfNum obj = new RankOfNum();
		// 10, 5, 15, 3, 20, 1, 25
		obj.track(10);
		obj.track(5);
		obj.track(15);
		obj.track(3);
		obj.track(20);
		obj.track(1);
		obj.track(25);

		System.out.println("Rank = " + obj.getRankOfNum(25));
	}

}

class RankNode{
	int value;
	RankNode left, right;
	int numLowerNodes;

	public RankNode(int value){
		this.value = value;
		this.left = null;
		this.right = null;
		numLowerNodes = 0;
	}

	public void insert(RankNode child){
		if(child.value <= this.value){
			if(this.left == null){
				this.left = child;
			}
			else{
				this.left.insert(child);
			}

			numLowerNodes++;
		}
		else{
			if(this.right == null){
				this.right = child;
			}
			else{
				this.right.insert(child);
			}
		}
	}

	public int getRank(int num){
		if(this.value == num) {
			return numLowerNodes;
		}
		else if(num < this.value){
			if(this.left == null) return -1;
			return this.left.getRank(num);
		}
		else if(this.right == null) return -1;

		int numHignerNodes = this.right.getRank(num);

		return (numHignerNodes == -1) ? -1 : numLowerNodes + 1 + numHignerNodes;
	}
}