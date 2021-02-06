package list;

import java.util.*;
public class hashmap {
	public static void main(String args[]) {
		HashMap hm = new HashMap();
		hm.put("Gayatri", new Double(3434.34)); 
		hm.put("Harshini", new Double(123.22));
		hm.put("Abitha", new Double(1378.00));
		hm.put("Reshma", new Double(99.22));
		hm.put("Hello", new Double(-19.08));
		Set set = hm.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		double balance = ((Double)hm.get("Gayatri")).doubleValue();
		hm.put("Zara", new Double(balance + 1000));
		System.out.println("Gayatri's new balance: " +
				hm.get("Gayatri"));
	}
} 