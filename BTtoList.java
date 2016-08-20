import java.util.*;
import java.util.Arrays;
import java.lang.Math;

class BTnode{
BTnode node1;
BTnode node2;
char value;

	public BTnode(char value){
		this.value=value;
	}
}

public class BTtoList{
	BTnode listHead;
	
	public void convert(BTnode root){
		BTnode head=convertBtnodetoList(root);
		//System.out.println("head node1 "+head.node1.value);
		head.node1.node2=null;
		head.node1=null;
		this.listHead=head;
	}
	
	public void concat(BTnode a, BTnode b){
		a.node2=b;
		b.node1=a;
	}
	
	public BTnode convertBtnodetoList(BTnode root){
			if(root==null) return null;
			
			BTnode pointer1=convertBtnodetoList(root.node1);
			BTnode pointer2=convertBtnodetoList(root.node2);
			
			if(pointer1==null && pointer2==null){
				root.node1=root;
				root.node2=root;
				return root;
			}
			
			BTnode tail=(pointer2==null)?null:pointer2.node1;
			
			if(pointer1==null){
				concat(pointer2.node1, root);
			}
			else concat(pointer1.node1,root);
			
			if(pointer2==null){
				concat(root,pointer1);
			}
			else concat(root,pointer2);
			
			if(pointer1!=null && pointer2!=null){
			concat(tail,pointer1);	
			}
			
			return (pointer1==null?root:pointer1);
		}
		
	public void print(){
		BTnode node=listHead;
		while(node!=null){
			System.out.print(node.value+" ");
			node=node.node2;
		}
	}	
		
	public static void main(String args[]){
		BTnode a=new BTnode('A');
		BTnode b=new BTnode('B');
		BTnode c=new BTnode('C');
		BTnode d=new BTnode('D');
		BTnode e=new BTnode('E');
		a.node1=b;
		a.node2=c;
		b.node2=d;
		c.node2=e;
		
		BTtoList obj=new BTtoList();
		//System.out.println("Initial BT:");
		//obj.print();
		obj.convert(a);
		System.out.println("Final list:");
		obj.print();
		//System.out.println(e.node1.value);
	}
}
