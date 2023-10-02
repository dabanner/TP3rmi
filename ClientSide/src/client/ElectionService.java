package client;

import client.candidate.Candidate;

import java.util.List;

public class ElectionService implements ElectionServiceImpl {
    @Override
    public List<Candidate> getCandidates() {
        return null;
    }

    @Override
    public boolean vote(int studentNumber, int otp, List<Candidate> candidates) {
        return false;
    }

    @Override
    public int isAllowedToVote(int studentNumber, String password) {
        return 0;
    }

    @Override
    public void getResults() {

    }
}