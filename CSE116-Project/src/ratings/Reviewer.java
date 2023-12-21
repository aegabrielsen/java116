package ratings;

public class Reviewer {

    private String reviewer;
    public Reviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewerID() {
        return this.reviewer;
    }
    public void setReviewerID(String reviewer) {
        this.reviewer = reviewer;
    }

    public Rating rateSong(int rating){
        return new Rating(this.reviewer, rating);
    }

}
