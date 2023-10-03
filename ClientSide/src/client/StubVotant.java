package client;

import candidate.CandidatesList;
import service.AuthenticationToken;
import service.ElectionService;
import java.util.Scanner;

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

    public boolean Vote(int studentNumber, String otp, CandidatesList candidates) {
        // Call the remote method on the server to fetch candidates
        return electionService.vote(studentNumber, otp, candidates);
    }

}

