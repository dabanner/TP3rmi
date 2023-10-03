package vote;

public class ResponseVote {
    private final VoteMaterial voteMaterial;
    private final AuthenticationToken otp;

    public ResponseVote(VoteMaterial voteMaterial, AuthenticationToken otp) {
        this.voteMaterial = voteMaterial;
        this.otp = otp;
    }

    public VoteMaterial getVoteMaterial() {
        return voteMaterial;
    }

    public AuthenticationToken getOTP() {
        return otp;
    }
}
