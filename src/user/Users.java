package user;
//import User class


import java.util.ArrayList;

public class Users extends ArrayList<User> {
    public Users(){
        super();
        for (int i = 1; i <= 100; i++) {
            //hash the i for id
            String password = "user" + i;
            this.add(new User(i, password));
        }
    }
}
