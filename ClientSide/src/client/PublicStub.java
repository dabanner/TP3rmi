package client;

import java.rmi.RemoteException;
import java.util.List;
import client.ClientMain;
import client.ElectionService;
import client.candidate.Candidate;
import client.StubVotant;
import client.VoteReturnValue;

public class PublicStub {
    private final ElectionService electionService;

    public PublicStub(ElectionService electionService) {
        this.electionService = electionService;
    }

    public List<Candidate> getCandidates() throws RemoteException {
        // Call the remote method on the server to fetch candidates
        return electionService.getCandidates();
    }

    public VoteReturnValue getVoteMaterial(int studentNumber) throws RemoteException {
        VoteReturnValue response = new VoteReturnValue();
        response.stubVotant = new StubVotant(electionService);
        response.OTP = electionService.isAllowedToVote(studentNumber, response.stubVotant.password);
        return response;
    }

    public void getResults() throws RemoteException {
        electionService.getResults();
    }
}
