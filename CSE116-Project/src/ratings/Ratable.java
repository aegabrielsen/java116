package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {

//    Remove all functionality related to title and ratings from the Song class and add to the Ratable class.
//    This includes title and ratings (LinkedListNode of Ratings) instance variables and all of the following methods
    public String title;
    public LinkedListNode<Rating> ratingList = null;

//    getTitle
//            setTitle

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//    addRating
//            getRatings
//    averageRating
//            removeRatingByReviewer


    public void addRating(Rating newRating) {
        if (this.ratingList == null) {
            this.ratingList = new LinkedListNode<>(newRating, null);
        } else {
            this.ratingList.append(newRating);
        }
//            A public method named addRating that takes a [reference to a] an object of type Rating as a parameter
//            (The type of the input is Rating) and returns void
//
//            This method will be called when a Reviewer rates this Song. All added Ratings
//            will be stored in a Linked List
//            as an instance variable
//            This method will append new ratings to the end of the linked list


    }

//    public LinkedListNode getRatings() {
    public LinkedListNode<Rating> getRatings() {

        if (this.ratingList == null) {
            return null;
        } else {
            return this.ratingList;
        }


//            A public method named getRatings that takes no parameters and returns a LinkedListNode of Ratings
//
//            This method returns the head of a Linked List containing all Ratings that have been added to this Song
//            The returned Linked List must return the Ratings in the order in which they were added. For example,
//            the first Rating that was added must be the first value in the list
//            If no ratings have been added, this method will return null


    }

//    public void setRatings(LinkedListNode newNode) {
//        if (this.ratingList == null) {
//            this.ratingList = newNode;
//        } else {
//            this.ratingList = newNode;
//        }
//
////            A public method named setRatings that takes a LinkedListNode of Ratings and returns void
////
////            This is a setter that replaces the stored linked list of ratings (The instance variable) with
////            the one provided as a parameter
//
//    }

    public double averageRating() {
        double sum = 0.0;
        double total = 0.0;
        if (this.ratingList == null) {
            return 0.0;
        } else {
            return this.averageRatingHelper(this.ratingList, sum, total);
        }

//            A public method named averageRating that takes no parameters and returns a double
//
//            This method returns the average of all the Rating of this Song
//            If the list is empty, the method returns 0.0
//            Any invalid rating, ratings of -1, will be ignored during this calculation
    }

    private double averageRatingHelper(LinkedListNode currentNode, double sum, double total) {
        if (currentNode == null) {
            return sum / total;
        } else {
            ratings.Rating ratingCheck = (Rating) currentNode.getValue();
            if (ratingCheck.getRating() > 0 && ratingCheck.getRating() < 6) {
                sum += ratingCheck.getRating();
                total += 1.0;
                return averageRatingHelper(currentNode.getNext(), sum, total);
            } else {
                return averageRatingHelper(currentNode.getNext(), sum, total);
            }
        }
    }

    public void removeRatingByReviewer(Reviewer reviewer) {
        String reviewerName = reviewer.getReviewerID();
        LinkedListNode<Rating> temp = this.ratingList, prev = null;
        Rating tempRating = (Rating) this.ratingList.getValue();
        if (temp != null && tempRating.getReviewerID().equals(reviewerName)) {
            this.ratingList = temp.getNext();
            return;
        }
        while (temp != null && !temp.getValue().getReviewerID().equals(reviewerName)) {
            prev = temp;
            temp = temp.getNext();
        }
        if (temp == null) {
            return;
        }
        prev.setNext(temp.getNext());
//                if (temp.getNext() == null) {
//                    prev.setNext(null);
//                }

//            A public method named removeRatingByReviewer that takes a Reviewer as a parameter and returns void
//
//            This method will remove a Rating made for this Song by the given Reviewer
//            If the reviewer did not rate this song, this method has no effect
//            If the linked list contains multiple ratings by the reviewer, the method only removes the first instance
//            from the list (ie. the method does not have to handle removing multiple ratings in a single call)
    }

    public double bayesianAverageRating (int num, int val) {

        if (num < 0) {
            return 0.0;
        }
        double sum = 0.0;
        double total = 0.0;
        if (val > 0 && val < 6) {
            sum = val * num;
            total = num;
        } else {
            return 0.0;
        }
        if (this.ratingList == null) {
            if (total > 0.0) {
                return sum / total;
            } else {
                return 0.0;
            }
        } else {
            return this.averageRatingHelper(this.ratingList, sum, total);
        }
/*
    A method named bayesianAverageRating that takes 2 ints and returns a double:
    The first parameter is a number of extra ratings
    The second parameter is the value of the extra ratings

    The method return the average rating of the song if the extra ratings were added. Note that you are not actually
    adding the ratings to the Song. You are only using the extra ratings in your computation of the average

    Example: If the song has ratings of 4 and 5 and this method is called with parameters 2 and 3
    (2 extra ratings of value 3), then the bayesian average is (4+5+3+3)/4 == 3.75 instead of the regular average of 4.5

    If a Song has no ratings and this method is called with 0 additional ratings, return 0.0

    If the input is invalid, the method will return 0.0. The input is invalid if the value of the extra ratings is
    anything other than 1, 2, 3, 4, or 5 OR the number of extra ratings is negative
*/
    }

}
