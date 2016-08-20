import java.util.Arrays;

import java.util.Comparator;

public class BiggestNumber {

public static void main(String[] args) {

Integer a[] = { 5,52,31,72,7, 3 };

Arrays.sort(a, new Comparator<Integer>() {

@Override

public int compare(Integer o1, Integer o2) {
	for (int i : a) {

System.out.println(i+" ");

}
	int i=(o2 + "" + o1).compareTo(o1 + "" + o2);
	System.out.println("Comparison of "+o1+" and "+o2+" = "+i);
return i;

}

});

String result = "";

for (int i : a) {

result += i;

}

System.out.println(result);

}

}