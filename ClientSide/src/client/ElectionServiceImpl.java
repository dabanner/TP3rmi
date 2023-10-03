package client;


import candidate.CandidatesList;
import service.AuthenticationToken;

public interface ElectionServiceImpl {
    int isAllowedToVote(int studentNumber, String password);

    void getResults();

    CandidatesList getCandidates();

    boolean vote(int studentNumber, AuthenticationToken otp, CandidatesList candidates);
}