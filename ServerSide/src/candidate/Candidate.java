package candidate;

/**
 * A candidate is a person who is running for an elected position.
 */
public class Candidate {
    public static int nextId = 1;
    private final Integer id;
    private final String firstName;
    private final String lastName;

    protected Candidate(String firstName, String lastName) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
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