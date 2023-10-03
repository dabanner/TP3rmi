package candidate;

public class TextPitchCandidate extends Candidate implements Pitch {
    private final String textPitch;

    public TextPitchCandidate(String firstName, String lastName, String textPitch) {
        super(firstName, lastName);
        this.textPitch = textPitch;

        System.out.println("[Creation] " + this);
    }

    @Override
    public String getPitch() {
        return textPitch;
    }

    @Override
    public String toString() {
        return String.format("User %04d: %s (Text pitch : %s)", getId(), getFullName(), getPitch());
    }
}
