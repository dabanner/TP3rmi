package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(12345, "password");
    }

    @Test
    void testGetStudentNumber() {
        assertEquals(12345, user.getStudentNumber());
    }

    @Test
    void testGetPassword() {
        assertEquals("password", user.getPassword());
    }
}
