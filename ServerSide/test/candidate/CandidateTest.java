package candidate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CandidateTest {
    private final static Candidate candidate = new Candidate("John", "Doe");

    @Test
    void testGetId() {
        assertEquals(1, candidate.getId());
    }

    @Test
    void testGetFullName() {
        assertEquals("John Doe", candidate.getFullName());
    }

    @Test
    void testToString() {
        String expectedToString = "Candidate 0001: John Doe";
        assertEquals(expectedToString, candidate.toString());
    }

    @Test
    void testNextIdIncremented() {
        Candidate anotherCandidate = new Candidate("Jane", "Smith");
        assertEquals(candidate.getId() + 1, anotherCandidate.getId());
    }
}
