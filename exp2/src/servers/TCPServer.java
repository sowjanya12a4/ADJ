package servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TCPServer{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(1801);
		Socket s = ss.accept();
		System.out.println("Server ready");
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		int n=din.readInt();
		int a[]=new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i]=din.readInt();
		}
		Arrays.sort(a);
		// for(i=0;i<n;i++)
		// {
		// out.writeInt(a[i]);
		// }
		out.writeInt(a[0]);
		out.writeInt(a[a.length - 1]);
		System.out.println("\nData Sent");
		s.close();
		ss.close();

	}
}