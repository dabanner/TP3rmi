import service.ElectionService;
import service.ElectionServicePublic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    public static void main(String[] args) {

        try {
            // We create an instance of our object
            ElectionService electionService = new ElectionServicePublic();
            System.out.println("[SERVER] ElectionService created !");

            Remote stub = UnicastRemoteObject.exportObject(electionService, 0);
            // We create our RMI registry
            Registry registry = LocateRegistry.createRegistry(2001);
            System.out.println("[SERVER] RMI registry created on port 2001 ...");

            // We bind our object to the name "MonOD"
            registry.rebind("ElectionService", stub);
            System.out.println("[SERVER] ElectionService bound in registry !");

        } catch (RemoteException e) {
            System.err.println("[SERVER] Exception starting RMI registry:");
        }
    }
}