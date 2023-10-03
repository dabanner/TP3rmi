package vote;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class AuthenticationToken implements OTPService {
    private static final Duration VALIDITY_DURATION = Duration.ofMinutes(5);
    private final String oneTimePassword;
    private final LocalDateTime creationDateTime;


    public AuthenticationToken() {
        // Generate a random one-time password
        this.oneTimePassword = UUID.randomUUID().toString();
        this.creationDateTime = LocalDateTime.now();
    }

    @Override
    public String getOneTimePassword() {
        return oneTimePassword;
    }

    @Override
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @Override
    public boolean isOTPValid() {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.MINUTES.between(creationDateTime, now) <= VALIDITY_DURATION.toMinutes();
    }
}