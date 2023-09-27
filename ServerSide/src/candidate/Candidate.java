package candidate;

class Candidate {
    public static int nextId = 1;
    private final Integer id;
    private final String firstName;
    private final String lastName;

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
}
