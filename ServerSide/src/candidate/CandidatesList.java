package candidate;

import java.util.HashSet;

public class CandidatesList extends HashSet<Candidate> {
    public CandidatesList() {
        super();
    }

    public static Candidate getCandidateById(int id) {
        for (Candidate candidate : this) {
            if (candidate.getId() == id) {
                return candidate;
            }
        }
        // If no candidate with the specified ID is found, return null or throw an exception
        return null;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("List of candidates : \n");
        for (Candidate candidate : this) {
            result.append("- ").append(candidate.toString()).append("\n");
        }
        return result.toString();
    }
}
