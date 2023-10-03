package vote;

import java.io.Serial;
import java.io.Serializable;

public class ResponseVote implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
