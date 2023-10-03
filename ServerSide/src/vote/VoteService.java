package vote;

import candidate.CandidatesList;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VoteService extends Remote {
    boolean vote(int studentNumber, AuthenticationToken otp, CandidatesList candidates)
            throws HasAlreadyVotedException, RemoteException;
}
