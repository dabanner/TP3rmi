package client;

import candidate.CandidatesList;

import java.rmi.RemoteException;

public class PublicStub {
    private final ElectionService electionService;

    public PublicStub(ElectionService electionService) {
        this.electionService = electionService;
    }

    public CandidatesList getCandidates() throws RemoteException {
        // Call the remote method on the server to fetch candidates
        return electionService.getCandidates();
    }

    public VoteReturnValue getVoteMaterial(int studentNumber) throws RemoteException {
        VoteReturnValue response = new VoteReturnValue();
        response.stubVotant = new StubVotant(electionService);
        response.otp = electionService.isAllowedToVote(studentNumber, response.stubVotant.password);
        return response;
    }

    public void getResults() throws RemoteException {
        electionService.getResults();
    }
}
