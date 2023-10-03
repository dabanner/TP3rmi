import candidate.CandidatesList;
import service.ElectionService;
import vote.OTPService;
import vote.ResponseVote;
import vote.VoteMaterial;
import vote.VoteService;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
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
            System.out.print("Enter your password: ");
            String supersecretpassword = scanner.next();

            ResponseVote response = electionService.getVoteMaterial(studentNumber, supersecretpassword);
            OTPService otp = response.getOTP();
            VoteService voteService = response.getVoteMaterial();

            if (response.getOTP().isOTPValid()) {

                Map<Integer, Integer> candidatess = new HashMap<>();
                candidates.forEach(candidate -> {
                    System.out.println(candidate.toString());
                    int candidateRank = -1;
                    do {
                        System.out.print("Enter your vote: ");
                        candidateRank = scanner.nextInt();
                    } while (candidateRank < 0 || candidateRank > 3);
                    candidatess.put(candidate.getId(), candidateRank);
                });

                boolean voteResult = voteService.vote(studentNumber, otp, candidatess);

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
            System.out.println("[Client] Error with the server");
        }
    }
}
