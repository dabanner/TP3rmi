package vote;

public class ResponseVote {
    private final VoteMaterial voteMaterial;
    private final OTPService otp;

    public ResponseVote(VoteMaterial voteMaterial, OTPService otp) {
        this.voteMaterial = voteMaterial;
        this.otp = otp;
    }

    public VoteMaterial getVoteMaterial() {
        return voteMaterial;
    }

    public OTPService getOTP() {
        return otp;
    }
}
