//program for server application 
import java.rmi.*;
import java.rmi.registry.*;
public class Server
{
    public static void main(String args[])
    {
        try
        {
            // Create an object of the interface
            FloodFill obj = new FloodFillQuery();

            // rmiregistry within the server JVM with 
            // port number 1900 
            LocateRegistry.createRegistry(1900);

            // Binds the remote object by the name
            Naming.rebind("rmi://localhost:1900"+ "/flood",obj);
            System.out.println("Server started");
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
} 