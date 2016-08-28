import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class testMap {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("5", "ESPN");
		map.put("4", "Star");
		map.put("3", "Sky");
		map.put("8", "CN");
		//map.put("1", "TLC");
		map.put("9", "CC");
		
		Television obj = new Television(map);
		obj.printList();

	}

}
