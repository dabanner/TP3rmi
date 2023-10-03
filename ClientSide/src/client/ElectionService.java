package client;

import candidate.CandidatesList;
import service.AuthenticationToken;

public class ElectionService implements ElectionServiceImpl {
    @Override
    public CandidatesList getCandidates() {
        return new CandidatesList();
    }

    @Override
    public boolean vote(int studentNumber, AuthenticationToken otp, CandidatesList candidates) {
        return false;
    }

    @Override
    public int isAllowedToVote(int studentNumber, String password) {
        return 0;
    }

    @Override
    public void getResults() {
        System.out.println("Results are not available yet.");
    }
}