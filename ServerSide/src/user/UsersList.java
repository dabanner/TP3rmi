package user;

import java.util.HashSet;

public class UsersList extends HashSet<User> {
    public UsersList() {
        super();
    }

    public boolean containsUser(int studentNumber) {
        for (User user : this) {
            if (user.getStudentNumber() == studentNumber) {
                return true;
            }
        }
        return false;
    }

    public User getUserByStudentNumber(int studentNumber) {
        for (User user : this) {
            if (user.getStudentNumber() == studentNumber) {
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("List of users : \n");
        for (User user : this) {
            result.append("- ").append(user.toString()).append("\n");
        }
        return result.toString();
    }
}
