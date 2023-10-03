import candidate.CandidatesList;
import service.ElectionService;
import vote.AuthenticationToken;
import vote.ResponseVote;
import vote.VoteMaterial;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Get the RMI registry running on the server host at port 2001
            Registry registry = LocateRegistry.getRegistry("localhost", 2001);

            // Lookup the remote ElectionService object from the registry
            ElectionService electionService = (ElectionService) registry.lookup("ElectionService");

            // Query the list of candidates and print their names and pitches
            CandidatesList candidates = electionService.getCandidatesList();
            System.out.println(candidates.toString());

            Scanner scanner = new Scanner(System.in);

            // Authenticate the user
            System.out.print("Enter your student number: ");
            int studentNumber = scanner.nextInt();

            ResponseVote response = electionService.getVoteMaterial(studentNumber);
            AuthenticationToken otp = response.getOTP();

            if (response.getOTP().isOTPValid()) {

                VoteMaterial stubVotant = response.getVoteMaterial();
                System.out.print("Enter your vote: ");
                String candidateRank = scanner.next();
                boolean voteResult = stubVotant.vote(studentNumber, otp, candidates);

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

            // Print the election results
            electionService.getElectionResults();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
