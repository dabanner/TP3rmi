package voteDTO;

class singularVote {
    private final int candidateID;
    private final int voteCount;

    public singularVote(int candidateID, int voteCount) {
        this.candidateID = candidateID;
        this.voteCount = voteCount;
    }
}

public class voteDTO implements java.io.Serializable{
    private final singularVote[] votes;

    public voteDTO(String votes) {
        String[] votesArray = votes.split(";");
        this.votes = new singularVote[votesArray.length];
        for (int i = 0; i < votesArray.length; i++) {
            String[] vote = votesArray[i].split(",");
            this.votes[i] = new singularVote(Integer.parseInt(vote[0]), Integer.parseInt(vote[1]));
        }
    }

    public singularVote[] getVotes() {
        return votes;
    }
}
