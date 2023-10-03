package candidate;

import java.util.HashSet;

public class CandidatesList extends HashSet<Candidate> {
    public CandidatesList() {
        super();
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
