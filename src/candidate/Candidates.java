package candidate;
import java.util.ArrayList;

public class Candidates extends ArrayList<Candidate>{
    public Candidates(){
        super();
        for (int i = 1; i <= 100; i++) {
            //hash the i for id
            String firstName = "candidateFirst" + i;
            String lastName = "candidateLast" + i;
            this.add(new Candidate(firstName, lastName));
        }
    }
}
