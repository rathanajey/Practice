public class RearrangeList{
	/* get mid point of list. Set it as head. Reverse the list.
	Once reversed, just join the nodes in the alternating order.
	Check whether current 1 is already pointing to current 2 to exit the list!!!
	*/

	public Node rearrangeList(Node head){
		if(head==null){
			return null;
		}
		if(head.next==null){
			return head;
		}
		Node fast=head, slow=head;
		if(fast.next==null){
			System.out.println("Fast is null");
		}
		while(fast!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		Node list1Head=head;
		Node list2Head=slow;
		list2Head=reverseList(slow);
		Node current1=list1Head, prev1=list1Head;
		Node current2=list2Head, prev2=list2Head;
		Node temp1, temp2;
		while(current1.next!=current2){
			//System.out.println("current 1 = "+current1.value +" current2 = "+current2.value);
			temp1=current1.next;
			current1.next=current2;
			//System.out.println("current 1.next = "+temp1.value +" current2.next = "+current2.next.value);
			temp2=current2.next;
			current2.next=temp1;
			current1=temp1;
			current2=temp2;
		}
		return head;
	}

	public Node reverseList(Node head){
		if(head.next==null){
			return head;
		}
		Node previous=head;
		Node current=head.next;
		head.next=null;
		Node temp=null;
		while(current!=null){
			temp=current.next;
			current.next=previous;
			previous=current;
			current=temp;
		}
		return previous;
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
		//Node fifteen=new Node(15);
		//one.setLeft(two);
		one.setNext(two);
		//two.setLeft(four);
		two.setNext(three);
		//three.setLeft(six);
		three.setNext(four);
		//four.setLeft(eight);
		four.setNext(five);
		//five.setLeft(ten);
		five.setNext(six);
		//six.setLeft(twelve);
		six.setNext(seven);
		//seven.setLeft(fourteen);
		seven.setNext(eight);
		eight.setNext(nine);
		nine.setNext(ten);
		ten.setNext(eleven);
		eleven.setNext(twelve);
		twelve.setNext(thirteen);
		thirteen.setNext(fourteen);
		//fourteen.setNext(fifteen);

		RearrangeList obj=new RearrangeList();
		Node node=obj.rearrangeList(one);
		while(node!=null){
			System.out.print(node.value+", ");
			node=node.next;
		}
	}
}

class Node{
	Node next;
	int value;

	Node(int value){
		this.value=value;
	}

	void setNext(Node next){
		this.next=next;
	}

}