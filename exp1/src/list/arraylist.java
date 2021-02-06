package list;

import java.util.ArrayList;
public class arraylist {
	public static void main(String args[]) {
		ArrayList<String> obj = new ArrayList<String>();
		obj.add("Abitha");
		obj.add("Harshini");
		obj.add("lalitha");
		obj.add("Sruthi");
		obj.add("yojitha");
		System.out.println("Currently the array list has following elements:"+obj);
		obj.add(0, "gayatri");
		obj.add(1, "sravani");
		obj.remove("reshma");
		obj.remove("srujana");
		System.out.println("Current array list is:"+obj);
		obj.remove(1);
		System.out.println("Current array list is:"+obj);
	}
} 
