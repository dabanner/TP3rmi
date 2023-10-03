package client;

import client.candidate.Candidate;
//import scanner
import java.util.Scanner;
import java.util.List;

public class StubVotant {
    private final ElectionService electionService;
    public final String password;

    public StubVotant(ElectionService electionService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.next();
        scanner.close();
        this.password = password;
        this.electionService = electionService;
    }

    public boolean Vote(int studentNumber, int OTP, List<Candidate> candidates) {
        // Call the remote method on the server to fetch candidates
        return electionService.vote(studentNumber, OTP, candidates);
    }

}

