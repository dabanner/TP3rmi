package client.candidate;

public class Candidate {
    public static int nextId = 1;
    private final Integer id;
    private final String firstName;
    private final String lastName;

    private final String pitch;

    public Candidate(String firstName, String lastName) {
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
    public String toString() {
        return String.format("%d: %s", id, getFullName());
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPitch() {
        return this.pitch;
    }
}
