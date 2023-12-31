package vote;

import candidate.Candidate;
import candidate.CandidatesList;
import service.HasAlreadyVotedException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface VoteService extends Remote {

    /**
     * Vote for a candidate in the election
     *
     * @param studentNumber     The student number of the voter
     * @param otp               The one time password of the voter
     * @param rankForCandidates The rank for each candidate
     * @return True if the vote was successful, false otherwise
     * @throws HasAlreadyVotedException If the voter has already voted
     * @throws RemoteException          If an error occurs during the remote call
     */
    boolean vote(int studentNumber, OTPService otp, Map<Candidate, Integer> rankForCandidates)
            throws HasAlreadyVotedException, RemoteException;
}
