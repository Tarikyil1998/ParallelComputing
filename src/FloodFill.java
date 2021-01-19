import java.rmi.*;
//Remote Interface
public interface FloodFill extends Remote {
    int[][] run(int[][] input) throws RemoteException;
    void fillArea(int[][] screen, int x, int y, int original, int fill) throws RemoteException;
}