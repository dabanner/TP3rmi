package candidate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidatesListTest {
    private CandidatesList candidatesList;
    private final Candidate candidate1 = new Candidate("John", "Doe");
    private final Candidate candidate2 = new Candidate("Jane", "Smith");

    @BeforeEach
    public void setUp() {
        candidatesList = new CandidatesList();

        assertTrue(candidatesList.add(candidate1));
        assertTrue(candidatesList.add(candidate2));
    }

    @Test
    void testAddCandidate() {
        assertEquals(2, candidatesList.size());
    }

    @Test
    void testToString() {
        String expectedToString = "List of candidates : \n" +
                "- Candidate 0001: John Doe\n" +
                "- Candidate 0002: Jane Smith\n";

        assertEquals(expectedToString, candidatesList.toString());
    }

    @Test
    void testAddCandidateAlreadyExists() {
        assertFalse(candidatesList.add(candidate1));
        assertEquals(2, candidatesList.size());
    }
}