package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
import client.candidate.Candidate;
import client.VoteReturnValue;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Get the RMI registry running on the server host at port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the remote ElectionService object from the registry
            ElectionService electionService = (ElectionService) registry.lookup("ElectionService");

            PublicStub publicStub = new PublicStub(electionService);
            // Query the list of candidates and print their names and pitches
            List<Candidate> candidates = publicStub.getCandidates();
            for (Candidate candidate : candidates) {
                System.out.println("Candidate: " + candidate.getFullName());
                if (candidate.getPitch() != null) {
                    System.out.println("Pitch: " + candidate.getPitch());
                }
            }

            Scanner scanner = new Scanner(System.in);

            // Authenticate the user
            System.out.print("Enter your student number: ");
            int studentNumber = scanner.nextInt();
            System.out.print("Enter your password: ");
            String password = scanner.next();

            VoteReturnValue response = publicStub.getVoteMaterial(studentNumber);
            int OTP = response.OTP;

            if (OTP!= 0) {

                StubVotant stubVotant = new StubVotant(electionService);
                System.out.print("Enter your vote: ");
                String candidateRank = scanner.next();
                boolean voteResult = stubVotant.Vote(studentNumber, OTP, candidates);

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
            publicStub.getResults();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
