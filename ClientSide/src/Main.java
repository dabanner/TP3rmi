import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Get the stub of the remote object

            // Query the list of candidates and for each print the name and pitch

            // Get the vote material with student number in parameter

            // Enter the password of the student and the server will check if the student is allowed to vote

            // Vote for a candidate

            // Get the confirmation of the vote

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
