package basic.collections.vodesign.lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String [] args){
		List<String> totalList = new ArrayList<>();
		
		List<String> subList1 = new ArrayList<>();
		subList1.add("A");
		subList1.add("B");
		subList1.add("C");
		subList1.add("D");
		
		List<String> subList2 = new ArrayList<>();
		subList2.add("1");
		subList2.add("2");
		subList2.add("3");
		subList2.add("4");
		
		totalList.addAll(subList1);
		totalList.addAll(subList2);
		
		for(String s : totalList){
			System.out.println(s);
		}
	}
}
