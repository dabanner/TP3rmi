package candidate;

public class TextPitchCandidate extends Candidate{

    private String textPitch;

    public TextPitchCandidate(String firstName, String lastName, String textPitch) {
        super(firstName, lastName);
    }

    public String getTextPitch() {
        return textPitch;
    }

    @Override
    public String toString() {
        return String.format("%d: %s (Text pitch :%s)", getId(), getFullName(), getTextPitch());
    }
}
