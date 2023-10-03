package candidate;

import java.io.Serializable;

public class TextPitchCandidate extends Candidate implements Pitch, Serializable {
    private final String textPitch;

    public TextPitchCandidate(String firstName, String lastName, String textPitch) {
        super(firstName, lastName);
        this.textPitch = textPitch;

        System.out.println("[NEW] " + this);
    }

    @Override
    public String getPitch() {
        return textPitch;
    }

    @Override
    public String toString() {
        return String.format("Candidate %04d: %s (Text pitch : %s)", getId(), getFullName(), getPitch());
    }
}
