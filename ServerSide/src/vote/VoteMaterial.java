package vote;

import candidate.Candidate;
import candidate.CandidatesList;
import service.HasAlreadyVotedException;

import java.rmi.RemoteException;
import java.util.Map;

public class VoteMaterial implements VoteService {
    public VoteMaterial() {
        // Empty I think
    }

    @Override
    public boolean vote(int studentNumber, OTPService otp, Map<Integer, Integer> candidates) throws HasAlreadyVotedException, RemoteException {
        candidates.forEach((candidateId, candidateVote) -> {
            Candidate candidate = CandidatesList.getCandidateById(candidateId);
            assert candidate != null;
            candidate.addVote(candidateVote);
        });
        return true;
    }
}
