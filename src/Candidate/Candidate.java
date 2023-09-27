package TP3.src.Candidate;


class candidate {
    private Integer id;
    private String firstName;
    private String lastName;
    public candidate(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
