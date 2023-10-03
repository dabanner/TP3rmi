package candidate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextPitchCandidateTest {
    private TextPitchCandidate candidate;

    @BeforeEach
    public void setUp() {
        candidate = new TextPitchCandidate("John", "Doe", "Vote for me because...");
    }

    @Test
    void testGetPitch() {
        String pitch = candidate.getPitch();
        assertEquals("Vote for me because...", pitch);
    }
}
