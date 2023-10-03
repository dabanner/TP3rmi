package vote;

import java.io.Serial;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class AuthenticationToken implements OTPService, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final Duration VALIDITY_DURATION = Duration.ofMinutes(5);
    private final String oneTimePassword;
    private final LocalDateTime creationDateTime;

    public AuthenticationToken()  {
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