package candidate;

import java.io.Serial;
import java.io.Serializable;

/**
 * A candidate is a person who is running for an elected position.
 */
public class Candidate implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public static int nextId = 1;
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private int votes;

    protected Candidate(String firstName, String lastName) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.votes = 0;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void addVote(int number) {
        votes += number;
    }

    public int getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "Candidate " + String.format("%04d", id) + ": " + getFullName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        return id.equals(candidate.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}