package client;

import client.candidate.Candidate;

import java.util.List;

public interface ElectionServiceImpl {
    int isAllowedToVote(int studentNumber, String password);

    void getResults();
    List<Candidate> getCandidates() ;

    boolean vote(int studentNumber, int otp, List<Candidate> candidates);
}