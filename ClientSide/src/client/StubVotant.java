package client;

import client.candidate.Candidate;

import java.util.List;

public class StubVotant {
    private final ElectionService electionService;

    public StubVotant(ElectionService electionService) {
        this.electionService = electionService;
    }

    public boolean Vote(int studentNumber, int OTP, List<Candidate> candidates) {
        // Call the remote method on the server to fetch candidates
        return electionService.vote(studentNumber, OTP, candidates);
    }

}

