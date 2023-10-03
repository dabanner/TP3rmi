package service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class AuthenticationToken {
    private static final Duration VALIDITY_DURATION = Duration.ofMinutes(10);
    private final String oneTimePassword;
    private final LocalDateTime creationDateTime;


    public AuthenticationToken() {
        // Generate a random one-time password
        this.oneTimePassword = UUID.randomUUID().toString();
        this.creationDateTime = LocalDateTime.now();
    }

    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public boolean isOTPValid() {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.MINUTES.between(creationDateTime, now) <= VALIDITY_DURATION.toMinutes();
    }
}