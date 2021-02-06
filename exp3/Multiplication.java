// Interface file
import java.rmi.*;

public interface Multiplication extends Remote {

	// declaration of remote methods

	public int multiply(int a, int b) throws RemoteException;
}