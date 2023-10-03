package vote;

import java.io.Serial;
import java.io.Serializable;

public class ResponseVote implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
