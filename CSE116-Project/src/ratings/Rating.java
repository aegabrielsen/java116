package ratings;

public class Rating {

    private String reviewer;
    private int rating;
    public Rating(String reviewer, int rating) {
        this.reviewer = reviewer;
        if (rating > 5 || rating < 1) {
            this.rating = -1;
        } else {
            this.rating = rating;
        }
    }

    public String getReviewerID() {
        return this.reviewer;
    }
    public void setReviewerID(String reviewer) {
        this.reviewer = reviewer;
    }

    public int getRating() {
        return this.rating;
    }
    public void setRating(int rating) {
        if (rating > 5 || rating < 1) {
            this.rating = -1;
        } else {
            this.rating = rating;
        }
    }


//    public static void main(String[] args) {
//
//        Rating p1 = new Rating("Joe", 2);
//        System.out.println(p1.getRating());
//
//    }
}
