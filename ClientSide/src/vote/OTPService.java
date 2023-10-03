package vote;

import java.time.LocalDateTime;

public interface OTPService {
    String getOneTimePassword();

    LocalDateTime getCreationDateTime();

    boolean isOTPValid();
}
