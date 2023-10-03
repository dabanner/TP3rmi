package candidate;

public class VideoPitchCandidate extends Candidate implements Pitch {
    private final String videoPitchLink;

    public VideoPitchCandidate(String firstName, String lastName, String videoPitchLink) {
        super(firstName, lastName);
        this.videoPitchLink = videoPitchLink;

        System.out.println("[Creation] " + this);
    }

    @Override
    public String getPitch() {
        return videoPitchLink;
    }

    @Override
    public String toString() {
        return String.format("Candidate %04d: %s (Pitch video link : %s)", getId(), getFullName(), getPitch());
    }
}
