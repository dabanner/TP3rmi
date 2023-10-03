package service;


import candidate.CandidatesList;
import user.UsersList;
import vote.ResponseVote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ElectionService extends Remote {
    String getElectionResults() throws RemoteException;

    CandidatesList getCandidatesList() throws RemoteException;

    UsersList getUsersList() throws RemoteException;

    ResponseVote getVoteMaterial(int studentNumber, String password) throws RemoteException, BadCredentialsException;
}