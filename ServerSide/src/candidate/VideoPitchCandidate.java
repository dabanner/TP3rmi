package candidate;

public class VideoPitchCandidate extends Candidate {

    private String videoPitchLink;

    public VideoPitchCandidate(String firstName, String lastName, String videoPitchLink) {
        super(firstName, lastName);
        this.videoPitchLink = videoPitchLink;
    }

    public String getVideoPitchLink() {
        return videoPitchLink;
    }

    @Override
    public String toString() {
        return String.format("%d: %s (Pitch video link :%s)", getId(), getFullName(), getVideoPitchLink());
    }
}
