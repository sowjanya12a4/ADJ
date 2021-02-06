//RMI Client

import java.rmi.*;
import java.util.*;

public class RMIClient {
	public static void main(String args[]) throws Exception{

		int x,y,result;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first no:");
		x=sc.nextInt();
		System.out.println("Enter second no:");
		y=sc.nextInt();

		Multiplication mul=(Multiplication)Naming.lookup("rmi://localhost:1099/multiplicationServer");

		result=mul.multiply(x,y);

		System.out.println("Multiplication result:"+result);


	}
}