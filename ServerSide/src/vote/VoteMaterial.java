package vote;

import candidate.Candidate;
import service.ElectionService;
import service.HasAlreadyVotedException;
import user.User;

import java.io.Serial;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class VoteMaterial extends UnicastRemoteObject implements VoteService, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private ElectionService electionService;

    public VoteMaterial(ElectionService electionService) throws RemoteException {
        super();
        this.electionService = electionService;
    }

    @Override
    public boolean vote(int studentNumber, OTPService otp, Map<Integer, Integer> candidates) throws HasAlreadyVotedException, RemoteException {
        User user = electionService.getUsersList().getUserByStudentNumber(studentNumber);

        if(user.hasVoted()) {
            throw new HasAlreadyVotedException("User with student number " + studentNumber + " has already voted.");
        }
        candidates.forEach((candidateId, candidateVote) -> {
            Candidate candidate = null;
            try {
                candidate = electionService.getCandidatesList().getCandidateById(candidateId);
            } catch (RemoteException e) {
                System.err.println("[SERVER] Error while getting candidate by id :" + candidateId);
            }
            assert candidate != null;
            candidate.addVote(candidateVote);
        });
        user.setHasVoted(true);
        return true;
    }
}