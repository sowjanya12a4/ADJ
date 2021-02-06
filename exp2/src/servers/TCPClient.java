package servers;
import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
public class TCPClient{
	public static void main(String[] args) throws UnknownHostException,IOException{
		Socket s=new Socket("localhost",1801);
		if(s.isConnected())
		{
			System.out.println("Connected");
		}
		System.out.println("Enter size of array:");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int a[]=new int[n];
		System.out.println("Enter element to array:");
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		dout.writeInt(n);
		for(int i=0;i<n;i++)
		{
			int r = scanner.nextInt();;
			dout.writeInt(r);
		}
		System.out.println("Data Sent");
		DataInputStream din=new DataInputStream(s.getInputStream());
		int r;
		System.out.println("Receiving Minimum and Maximum elements....");
		for(int i=0;i<2;i++)
		{
			r=din.readInt();
			System.out.print(r+" ");
		}
		//r=din.readInt();
		//System.out.print(r+" ");
		s.close();

	}
}