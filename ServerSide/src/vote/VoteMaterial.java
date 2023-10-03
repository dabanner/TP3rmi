package vote;

import candidate.Candidate;
import candidate.CandidatesList;
import service.HasAlreadyVotedException;
import user.User;
import user.UsersList;

import java.rmi.RemoteException;
import java.util.Map;

public class VoteMaterial implements VoteService {
    private final UsersList userlist = new UsersList();

    public VoteMaterial() {
        // Empty I think
    }

    @Override
    public boolean vote(int studentNumber, OTPService otp, Map<Integer, Integer> candidates) throws HasAlreadyVotedException, RemoteException {
        User user = this.userlist.getUserByStudentNumber(studentNumber);
        if (user != null) {
            if (user.hasVoted) {
                throw new HasAlreadyVotedException("User has already voted");
            }
            candidates.forEach((candidateId, candidateVote) -> {
                Candidate candidate = CandidatesList.getCandidateById(candidateId);
                assert candidate != null;
                candidate.addVote(candidateVote);
            });
            user.hasVoted = true;
            return true;
        } else {
            throw new RemoteException("User not found");
        }
    }
}
