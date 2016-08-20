package test;

class Btree
{
	Btree left;
	Btree right;
	int val;	
	Btree(int val)
	{
		this.val=val;
	}
}

public class MirrorTree {
	
	boolean mirrorEquals(Btree left, Btree right) {
		  if (left == null || right == null) return left == null && right == null;
		  return left.val == right.val && mirrorEquals(left.left, right.right) && mirrorEquals(left.right, right.left);
		}

	public static void main(String args[])
	{
		Btree a=new Btree(8);
		Btree b=new Btree(7);
		Btree c=new Btree(7);
		Btree d=new Btree(5);
		Btree e=new Btree(4);
		Btree f=new Btree(4);
		Btree g=new Btree(5); 
		a.left=b;
		a.right=c;
		b.left=d;
		b.right=e;
		c.left=f;
		c.right=g;
		MirrorTree obj=new MirrorTree();
		boolean nir=obj.mirrorEquals(a.left,a.right);
		if(nir==true)
		{
			System.out.println("It is symmetric");
		}
		else{System.out.println("NOT symmetric");}
		int num=5;
		//String str=valueOf(num);
		System.out.println(String.valueOf(num));
	}
	
}
