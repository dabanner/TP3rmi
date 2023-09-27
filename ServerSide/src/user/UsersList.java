package user;

import java.util.ArrayList;

public class UsersList extends ArrayList<User> {
    public UsersList() {
        super();
        for (int i = 1; i <= 100; i++) {
            // Create a unique password for each user
            String password = "user" + i;
            this.add(new User(i, password));
        }
    }
}
