package ratings;

import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;

public class Movie extends Ratable {
    private ArrayList<String> cast = new ArrayList<String>();

    public Movie(String title, ArrayList<String> cast) {
//        this.title = title;
        setTitle(title);
        this.cast = cast;
    }

//    A Method named getTitle that takes no parameters and returns the title String given in the constructor
//    eg. In your tests, call the constructor to create a Movie object, then call getTitle and assert that it returned
//    the same String you gave the constructor

//    public String getTitle() {
//        return this.title;
//    }


//    A Method named getCast that takes no parameters and returns an ArrayList with the same cast members that were
//    provided to the constructor
//    This method might not return the same exact ArrayList provided to the constructor, but it will contain the same
//    names in the same order. However, the names might not have the same combination of upper/lower-case letters.
//    Any String in the returned ArrayList containing the correct letters should be considered correct regardless of
//    upper/lower-case
//    Example: In the constructor, you provide the ArrayList ["Chris Pratt", "Zoe Saldana", "Dave Bautista"].
//    All of the following are correct outputs ["Chris Pratt", "Zoe Saldana", "Dave Bautista"],
//    ["chris pratt", "zoe saldana", "dave bautista"], and ["CHRIS pratt", "ZoE SalDANA", "dAVE bautistA"]
//    Note that the String class has a method named equalsIgnoreCase that will prove useful when testing this method
    public ArrayList<String> getCast() {
    return this.cast;
}

    public void setRatings(LinkedListNode<Rating> newNode) {
        if (this.ratingList == null) {
            this.ratingList = newNode;
        } else {
            this.ratingList = newNode;
        }

//            A public method named setRatings that takes a LinkedListNode of Ratings and returns void
//
//            This is a setter that replaces the stored linked list of ratings (The instance variable) with
//            the one provided as a parameter

    }

}
