package service;

import candidate.CandidatesList;
import candidate.TextPitchCandidate;
import candidate.VideoPitchCandidate;
import vote.ResponseVote;
import vote.VoteMaterial;
import user.User;
import user.UsersList;
import vote.AuthenticationToken;

import java.rmi.RemoteException;

public class ElectionServicePublic implements ElectionService {
    public final CandidatesList candidateList = new CandidatesList();
    private final UsersList usersList = new UsersList();

    public ElectionServicePublic() {
        // Hardcoded candidates list
        candidateList.add(new VideoPitchCandidate("John", "Doe", "https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        candidateList.add(new TextPitchCandidate("Emmanuel", "Macron", "En Marche !"));
        candidateList.add(new VideoPitchCandidate("Donald", "Trump", "https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        candidateList.add(new TextPitchCandidate("Jean-Luc", "Mélenchon", "La France Insoumise"));
        candidateList.add(new TextPitchCandidate("Marine", "Le Pen", "Rassemblement National"));

        // Hardcoded users list
        usersList.add(new User(123456, "123456"));
        usersList.add(new User(654321, "654321"));
        usersList.add(new User(111111, "111111"));
    }

    @Override
    public void getElectionResults() throws RemoteException {
        System.out.println("Results are not available yet.");
    }

    @Override
    public CandidatesList getCandidatesList() throws RemoteException {
        return this.candidateList;
    }

    @Override
    public ResponseVote getVoteMaterial(int studentNumber, String password) throws RemoteException, BadCredentialsException {
        if (!usersList.containsUser(studentNumber)) {
            throw new BadCredentialsException("Student number " + studentNumber + " is not registered !");
        }
        // Check password of the student with the studentNumber

        User user = usersList.getUserByStudentNumber(studentNumber);
        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("Wrong password for student number " + studentNumber + " !");
        }

        // If OK return a VoteMaterial object with OTP
        if (false) {
            return new ResponseVote(new VoteMaterial(), new AuthenticationToken());
        }
        // Else throw BadCredentialsException

        return null;
    }
}
