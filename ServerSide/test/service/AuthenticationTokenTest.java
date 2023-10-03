package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationTokenTest {
    private AuthenticationToken authenticationToken;

    @BeforeEach
    public void setUp() {
        authenticationToken = new AuthenticationToken();
    }

    @Test
    void testGetOneTimePassword() {
        String oneTimePassword = authenticationToken.getOneTimePassword();
        assertNotNull(oneTimePassword);
    }

    @Test
    void testOneTimePasswordFormat() {
        String oneTimePassword = authenticationToken.getOneTimePassword();
        assertTrue(oneTimePassword.matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}"));
    }

    @Test
    void testGeneratedPasswordIsRandom() {
        AuthenticationToken anotherAuthenticationToken = new AuthenticationToken();
        assertNotEquals(authenticationToken.getOneTimePassword(), anotherAuthenticationToken.getOneTimePassword());
    }

    @Test
    void testGetCreationDateTime() {
        LocalDateTime creationDateTime = authenticationToken.getCreationDateTime();
        assertNotNull(creationDateTime);
    }

    @Test
    void testCreationDateTimeIsReasonable() {
        LocalDateTime creationDateTime = authenticationToken.getCreationDateTime();
        LocalDateTime now = LocalDateTime.now();
        assertTrue(creationDateTime.isBefore(now) || creationDateTime.isEqual(now));
    }

    @Test
    void testIsOTPValid() {
        AuthenticationToken authenticationToken = new AuthenticationToken();
        assertTrue(authenticationToken.isOTPValid());
    }
}