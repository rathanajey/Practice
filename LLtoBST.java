class LNode {

public int data;

public LNode next;

LNode(int newData) {

this.data = newData;

}

}

class Node {

int data;

Node left, right;

public Node(int item) {

data = item;

left = right = null;

}

}

class LinkedList {

LNode first;

LNode head;

LNode newNode;

public LinkedList() {

first = null;

}

public void insertAtBeginning(int x) {

newNode = new LNode(x);

if (first != null) {

newNode.next = first;

first = newNode;

head = first;

} else {

first = newNode;

head = first;

}

}

public void printList()

{

head = first;

while (first != null) {

System.out.print(first.data + " --> ");

first = first.next;

}

System.out.println("null");

first = head;

}

}

public class LLtoBST {

public static Node root;

//public static LNode first;

public static Node sortedListToBST(LNode first, int end) {

return sortedListToBST(first, 0, end);

}

public static Node sortedListToBST(LNode first, int start, int end) {

if (start > end)

return null;

int mid = (start + end) / 2;

Node leftNode = sortedListToBST(first, start, mid - 1);

Node root = new Node(first.data);

root.left = leftNode;

if (first.next != null) {

first.data = first.next.data;

first.next = first.next.next;

}

root.right = sortedListToBST(first, mid + 1, end);

return root;

}

public static void main(String... args) {

LinkedList list = new LinkedList();

int n = 0;

list.insertAtBeginning(7);

list.insertAtBeginning(6);

list.insertAtBeginning(5);

list.insertAtBeginning(4);

list.insertAtBeginning(3);

list.insertAtBeginning(2);

list.insertAtBeginning(1);

list.printList();

LNode first = list.head;

while (first != null) {

n++;

first = first.next;

}

first = list.head;

Node curr = sortedListToBST(first, n);

inorder(curr);

}

private static void inorder(Node curr) {

// TODO Auto-generated method stub

if(curr!=null)

{

inorder(curr.left);

System.out.println(curr.data);

inorder(curr.right);

}

}

}