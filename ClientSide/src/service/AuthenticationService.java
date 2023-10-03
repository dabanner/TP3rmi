package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthenticationService extends Remote {
    boolean authenticate(String studentNumber, String password) throws RemoteException, BadCredentialsException;

    AuthenticationToken requestAuthenticationToken(Remote clientStub) throws RemoteException, BadCredentialsException, HasAlreadyVotedException;
}
