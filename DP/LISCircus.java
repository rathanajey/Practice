import java.util.ArrayList;
import java.util.Collections;

class LISCircus{

	public ArrayList<Person> getLongestSeq(ArrayList<Person> persons){
		Collections.sort(persons);
		return helper(persons);
	}

	public ArrayList<Person> helper(ArrayList<Person> persons){

		ArrayList<ArrayList<Person>> solutions = new ArrayList<ArrayList<Person>>();

		getLongestSeqHelper(persons, solutions, 0);

		ArrayList<Person> maxList = null;		
		for(int i =0; i < solutions.size(); i++){
			maxList = getMaxList(maxList, solutions.get(i));
		}

		return maxList;
	}

	public void getLongestSeqHelper(ArrayList<Person> persons, ArrayList<ArrayList<Person>> solutions, int index){

		if(index >= persons.size()) return;

		ArrayList<Person> maxList = null;;

		for(int i=0; i < index; i++){
			if(persons.get(index).isAfter(persons.get(i))){
				maxList = getMaxList(maxList, solutions.get(i));
			}
		}

		ArrayList<Person> newSol = new ArrayList<Person>();

		if(maxList != null){
			newSol.addAll(maxList);
		}
		newSol.add(persons.get(index));

		solutions.add(newSol);

		getLongestSeqHelper(persons, solutions, index + 1);
	}

	public ArrayList<Person> getMaxList(ArrayList<Person> list1, ArrayList<Person> list2){
		if(list1 == null) return list2;
		if(list2 == null) return list1;

		return (list1.size() >= list2.size()) ? list1 : list2;
	}

	public static void main(String[] args){
		Person a1 = new Person(10, 100);
		Person a2 = new Person(15, 110);
		Person a3 = new Person(20, 120);
		Person a4 = new Person(25, 190);
		Person a5 = new Person(3, 140);
		Person a6 = new Person(5, 150);
		Person a7 = new Person(6, 160);

		ArrayList<Person> list = new ArrayList<Person>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		list.add(a6);
		list.add(a7);

		LISCircus obj = new LISCircus();

		list = obj.getLongestSeq(list);
		for(Person a: list){
			System.out.println(a.height);
		}
	}
}

class Person implements Comparable<Person>{
	Integer height;
	Integer weight;

	public Person(int height, int weight){
		this.height = height;
		this.weight = weight;
	}

	public boolean isAfter(Person b){
		if(this.height >= b.height && this.weight >= b.weight) return true;

		return false;
	}

	public int compareTo(Person person){
		if(this.height != person.height){
			return this.height.compareTo(person.height);
		}
		else{
			return this.weight.compareTo(person.weight);
		}
	}
}