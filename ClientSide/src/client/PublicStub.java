package client;

import java.rmi.RemoteException;
import java.util.List;
import client.ClientMain;
import client.ElectionService;
import client.candidate.Candidate;

public class PublicStub {
    private final ElectionService electionService;

    public PublicStub(ElectionService electionService) {
        this.electionService = electionService;
    }

    public List<Candidate> getCandidates() throws RemoteException {
        // Call the remote method on the server to fetch candidates
        return electionService.getCandidates();
    }

    public int getVoteMaterial(int studentNumber, String password) throws RemoteException {
        return electionService.isAllowedToVote(studentNumber, password);
    }

    public void getResults() throws RemoteException {
        electionService.getResults();
    }
}
