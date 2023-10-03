package user;

/**
 * A user can vote for a candidate.
 * If a user has already voted, he can't vote again.
 * A user is identified by his student number and his password.
 * If the user are a candidate, he can vote for himself.
 */
public class User {
    private Integer studentNumber;
    private String password;

    public User(Integer studentNumber, String password) {
        this.studentNumber = studentNumber;
        this.password = password;
        System.out.println("[Creation] " + this);
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("User %04d: %s", studentNumber, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return studentNumber.equals(user.studentNumber);
    }

    @Override
    public int hashCode() {
        return studentNumber.hashCode();
    }
}
