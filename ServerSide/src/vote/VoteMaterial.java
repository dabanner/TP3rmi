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
    public boolean vote(int studentNumber, OTPService otp, Map<Candidate, Integer> candidates) throws HasAlreadyVotedException, RemoteException {
        User user = electionService.getUsersList().getUserByStudentNumber(studentNumber);
        if (!otp.isOTPValid()) {
            throw new RemoteException("OTP is not valid.");
        }
        if (user.hasVoted()) {
            throw new HasAlreadyVotedException("User with student number " + studentNumber + " has already voted.");
        }
        candidates.forEach(Candidate::addVote);

        user.setHasVoted(true);
        return true;
    }
}