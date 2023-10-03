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
        try {
            otp = new AuthenticationToken();
            voteMaterial = new VoteMaterial(null);
            responseVote = new ResponseVote(voteMaterial, otp);
        } catch (Exception e) {
            System.err.println("[SERVER] Error: " + e.getMessage());
        }
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