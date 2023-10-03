package service;


import candidate.CandidatesList;
import vote.ResponseVote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ElectionService extends Remote {
    void getElectionResults() throws RemoteException;

    CandidatesList getCandidatesList() throws RemoteException;

    ResponseVote getVoteMaterial(int studentNumber, String password) throws RemoteException, BadCredentialsException;
}