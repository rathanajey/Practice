import java.util.List;
import java.util.*;
import java.util.ListIterator;
import java.util.ArrayList;

class SumOfPaths{

	public List<int[]> getPaths(Node root, int sum){
		if(root==null){
			return null;
		}
		List<int[]> pathList=new ArrayList<int[]>();
		int depth=getDepth(root);
		int[] pathArray=new int[depth];
		pathArray[0]=root.value;
		return getPaths(root, sum, pathList, pathArray, 0);		
	}

	public List<int[]> getPaths(Node node, int sum, List<int[]> pathList, int[] pathArray, int level){
		if(node==null){
			return pathList;
		}
		int currentSum=0;
		pathArray[level]=node.value;
		for(int i=level;i>=0;i--){
			currentSum+=pathArray[i];
			if(currentSum==sum){
				pathList.add((getPath(pathArray, level, i)));
			}
		}
		getPaths(node.left, sum, pathList, pathArray, level+1);
		getPaths(node.right, sum, pathList, pathArray, level+1);
		return pathList;
	}

	public int[] getPath(int[] pathArray, int elementLevel, int pathLevel){
		int size=elementLevel - pathLevel + 1;
		int[] path=new int[size];
		for(int i=0;i<size;i++){
			path[i]=pathArray[pathLevel];
			pathLevel++;
		}
		return path;
	}

	public int getDepth(Node node){
		if(node==null){
			return 0;
		}
		return 1 + Math.max(getDepth(node.left), getDepth(node.right));
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

		SumOfPaths obj=new SumOfPaths();
		List<int[]> pathList=obj.getPaths(one, 7);
		Iterator iter=pathList.iterator();
		while(iter.hasNext()){
			Object temp=iter.next();
			int[] tempArray=(int[]) temp;
			for(int i:tempArray){
				System.out.print(i+" ");
			}
			System.out.println();
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