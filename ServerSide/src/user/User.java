package user;

public class User {
    private Integer studentNumber;
    private String password;

    private boolean haveAlreadyVoted;

    public User(Integer studentNumber, String password) {
        this.studentNumber = studentNumber;
        this.password = password;
        this.haveAlreadyVoted = false;
    }
}
