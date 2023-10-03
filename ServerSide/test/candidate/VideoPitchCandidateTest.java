package candidate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoPitchCandidateTest {
    private VideoPitchCandidate candidate;

    @BeforeEach
    public void setUp() {
        candidate = new VideoPitchCandidate("Jane", "Smith", "https://www.youtube.com/watch?v=videoId");
    }

    @Test
    void testGetPitch() {
        String pitch = candidate.getPitch();
        assertEquals("https://www.youtube.com/watch?v=videoId", pitch);
    }
}