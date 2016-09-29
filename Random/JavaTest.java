import java.util.*;

public class JavaTest{
	public static void testPrint(JavaTest obj){
		obj.print();
	}
	
	String name;
	public JavaTest(String name){
		this.name=name;
	}
	public void print(){
		System.out.println("This is obj: "+name);
	}
	
	public static void main(String args[]){
		JavaTest obj1=new JavaTest("Object1");
		testPrint(obj1);
	}
}