import candidate.CandidatesList;
import client.StubVotant;
import client.VoteReturnValue;
import service.ElectionService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Get the RMI registry running on the server host at port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the remote ElectionService object from the registry
            ElectionService electionService = (ElectionService) registry.lookup("ElectionService");

            // Query the list of candidates and print their names and pitches
            CandidatesList candidates = electionService.getCandidates();
            System.out.println(candidates.toString());

            Scanner scanner = new Scanner(System.in);

            // Authenticate the user
            System.out.print("Enter your student number: ");
            int studentNumber = scanner.nextInt();
            VoteReturnValue response = electionService.getVoteMaterial(studentNumber);

            if (response.otp.isOTPValid()) {

                StubVotant stubVotant = response.stubVotant;
                System.out.print("Enter your vote: ");
                String candidateRank = scanner.next();
                boolean voteResult = stubVotant.Vote(studentNumber, response.otp.getOneTimePassword(), candidates);

                if (voteResult) {
                    System.out.println("Vote successfully cast!");
                } else {
                    System.out.println("Failed to cast your vote. Please try again.");
                }
            } else {
                System.out.println("You are not allowed to vote.");
            }

            // Close the scanner and handle exceptions as needed
            scanner.close();
            electionService.getResults();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
