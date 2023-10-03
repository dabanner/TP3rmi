package service;

import candidate.CandidatesList;
import candidate.TextPitchCandidate;
import candidate.VideoPitchCandidate;

public class ElectionService {
    public final CandidatesList candidateList = new CandidatesList();

    public ElectionService() {
        candidateList.add(new VideoPitchCandidate("John", "Doe", "https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        candidateList.add(new TextPitchCandidate("Emmanuel", "Macron", "En Marche !"));
        candidateList.add(new VideoPitchCandidate("Donald", "Trump", "https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        candidateList.add(new TextPitchCandidate("Jean-Luc", "Mélenchon", "La France Insoumise"));
        candidateList.add(new TextPitchCandidate("Marine", "Le Pen", "Rassemblement National"));
    }

    public CandidatesList getCandidates() {
        return candidateList;
    }
}
