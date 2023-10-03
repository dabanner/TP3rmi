package vote;

import candidate.CandidatesList;
import service.HasAlreadyVotedException;

import java.rmi.RemoteException;

public class VoteMaterial implements VoteService {
    public VoteMaterial() {
        // Empty I think
    }

    @Override
    public boolean vote(int studentNumber, OTPService otp, CandidatesList candidates) throws HasAlreadyVotedException, RemoteException {
        return false;
    }
}