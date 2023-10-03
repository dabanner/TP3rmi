package service;

import user.User;
import user.UsersList;

public class UserService {

    public UsersList usersList;

    public UserService() {
        usersList = new UsersList();
    }

    public boolean addUser(int studentNumber, String password) {
        if (usersList.contains(new User(studentNumber, password))) {
            return false;
        }
        usersList.add(new User(studentNumber, password));
        return true;
    }
}
