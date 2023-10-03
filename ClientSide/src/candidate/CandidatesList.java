package candidate;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;

public class CandidatesList extends HashSet<Candidate> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    public CandidatesList() {
        super();
    }

    public Candidate getCandidateById(int id) {
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
