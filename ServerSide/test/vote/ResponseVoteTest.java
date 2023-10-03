package vote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseVoteTest {
    private ResponseVote responseVote;
    private VoteMaterial voteMaterial;
    private OTPService otp;

    @BeforeEach
    public void setUp() {
        voteMaterial = new VoteMaterial();
        otp = new AuthenticationToken();
        responseVote = new ResponseVote(voteMaterial, otp);
    }

    @Test
    void testGetVoteMaterial() {
        assertEquals(voteMaterial, responseVote.getVoteMaterial());
    }

    @Test
    void testGetOTP() {
        assertEquals(otp, responseVote.getOTP());
    }
}