package list;

import java.util.Hashtable;
import java.util.Map;
class hashtable{
	public static void main(String args[]){
		Hashtable<Integer,String> hm=new Hashtable<Integer,String>();
		hm.put(100,"harshini");
		hm.put(102,"reshma");
		hm.put(101,"abitha");
		hm.put(103,"kumari");
		for(Map.Entry m:hm.entrySet()){
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}
} 
