package vote;

public class ResponseVote {
    private final VoteService voteMaterial;
    private final OTPService otp;

    public ResponseVote(VoteService voteMaterial, OTPService otp) {
        this.voteMaterial = voteMaterial;
        this.otp = otp;
    }

    public VoteService getVoteMaterial() {
        return voteMaterial;
    }

    public OTPService getOTP() {
        return otp;
    }
}
