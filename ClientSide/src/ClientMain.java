import candidate.CandidatesList;
import service.ElectionService;
import vote.OTPService;
import vote.ResponseVote;
import vote.VoteService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientMain {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        try {
            // Get the RMI registry running on the server host at port 2001
            Registry registry = LocateRegistry.getRegistry("localhost", 2001);
            System.out.println("[Client] RMI registry found on port 2001");

            // Lookup the remote ElectionService object from the registry
            ElectionService electionService = (ElectionService) registry.lookup("ElectionService");
            System.out.println("[Client] ElectionService found in registry");

            // Query the list of candidates and print their names and pitches
            CandidatesList candidates = electionService.getCandidatesList();
            System.out.println(candidates.toString());

            Scanner scanner = new Scanner(System.in);
            ResponseVote response = null;
            int studentNumber = -1;
            String password = "";

            do {
                // Authenticate the user
                System.out.println(ANSI_YELLOW + "Enter your student number: " + ANSI_RESET);
                studentNumber = scanner.nextInt();
                System.out.println(ANSI_YELLOW + "Enter your password: " + ANSI_RESET);
                password = scanner.next();

                try {
                    response = electionService.getVoteMaterial(studentNumber, password);
                } catch (Exception e) {
                    System.err.println("[Client] Error found : " + e.getMessage());
                }
            } while (response == null);

            System.out.println(ANSI_YELLOW + "\nWelcome " + studentNumber + " !" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Now you can vote for each candidate by entering a rank between 1 and 3." + ANSI_RESET);

            OTPService otp = response.getOTP();
            VoteService voteService = response.getVoteMaterial();

            if (response.getOTP().isOTPValid()) {

                Map<Integer, Integer> rankForCandidates = new HashMap<>();
                candidates.forEach(candidate -> {
                    System.out.println(candidate.toString());
                    int candidateRank;
                    do {
                        System.out.print(ANSI_YELLOW + "Enter your vote for candidate " + candidate.getId() + " : " + ANSI_RESET);
                        candidateRank = scanner.nextInt();
                    } while (candidateRank < 1 || candidateRank > 3);
                    rankForCandidates.put(candidate.getId(), candidateRank);
                });

                boolean voteResult = voteService.vote(studentNumber, otp, rankForCandidates);

                if (voteResult) {
                    System.out.println("Vote successfully cast!" + ANSI_RESET);
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
            System.err.println("[Client] Error found : " + e.getMessage());
        }
    }
}
