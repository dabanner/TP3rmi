package service;


import candidate.CandidatesList;
import vote.OTPService;
import vote.ResponseVote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface ElectionService extends Remote {
    void getElectionResults() throws RemoteException;

    CandidatesList getCandidatesList() throws RemoteException;

    ResponseVote getVoteMaterial(int studentNumber) throws RemoteException, BadCredentialsException;

    boolean vote(int studentNumber, OTPService otp, Map<Integer, Integer> candidates)
            throws HasAlreadyVotedException, RemoteException;
}