import service.ElectionService;
import service.ElectionServicePublic;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        // Add to RMI registry
        try {
            // We create an instance of our object
            ElectionService electionService = new ElectionServicePublic();
            System.out.println("[SERVER] ElectionService created !");

            // We create our RMI registry
            Registry reg = LocateRegistry.createRegistry(2001);
            System.out.println("[SERVER] RMI registry created on port 2001 ...");

            // We bind our object to the name "MonOD"
            reg.rebind("ElectionService", electionService);
            System.out.println("[SERVER] ElectionService bound in registry !");

        } catch (Exception e) {
            System.err.println("[SERVER] Exception starting RMI registry:");
            e.printStackTrace();
        }
    }
}