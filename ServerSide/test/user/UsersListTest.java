package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UsersListTest {
    private UsersList usersList;
    private final User user1 = new User(12345, "password1");
    private final User user2 = new User(67890, "password2");

    @BeforeEach
    public void setUp() {
        usersList = new UsersList();

        usersList.add(user1);
        usersList.add(user2);
    }

    @Test
    void testAddUser() {
        assertEquals(2, usersList.size());
    }

    @Test
    void testToString() {
        String expectedToString = "List of users : \n" +
                "- User 67890: password2\n" +
                "- User 12345: password1\n";

        assertEquals(expectedToString, usersList.toString());
    }

    @Test
    void testAddUserAlreadyExists() {
        User user1Copy = new User(12345, "password1");
        assertFalse(usersList.add(user1Copy));
        assertFalse(usersList.add(user1));
        assertFalse(usersList.add(user2));
        assertEquals(2, usersList.size());
    }
}
