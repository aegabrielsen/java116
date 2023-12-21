package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class TestClasses1 {


    @Test
    public void songTest1() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        assertEquals("Can't Stop", p1.getTitle());
        assertEquals("Red Hot Chili Peppers", p1.getArtist());
        assertEquals("2002", p1.getSongID());
    }

    @Test
    public void songTest2() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        p1.setTitle("");
        p1.setArtist("");
        p1.setSongID("");
        assertEquals("", p1.getTitle());
        assertEquals("", p1.getArtist());
        assertEquals("", p1.getSongID());
    }
    @Test
    public void songTest3() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        p1.setTitle("Only");
        p1.setArtist("Nine Inch Nails");
        p1.setSongID("9999");
        assertEquals("Only", p1.getTitle());
        assertEquals("Nine Inch Nails", p1.getArtist());
        assertEquals("9999", p1.getSongID());
    }

    @Test
    public void ratingTest1() {
        ratings.Rating p1 = new ratings.Rating("Joe", 2);
        assertEquals("Joe", p1.getReviewerID());
        assertEquals(2, p1.getRating());
    }

    @Test
    public void ratingTest2() {
        ratings.Rating p1 = new ratings.Rating("Joe", 2);
        p1.setReviewerID("Bob");
        p1.setRating(3);
        assertEquals("Bob", p1.getReviewerID());
        assertEquals(3, p1.getRating());
    }
    @Test
    public void ratingTest3() {
        ratings.Rating p1 = new ratings.Rating("Joe", 7);
        assertEquals("Joe", p1.getReviewerID());
        assertEquals(-1, p1.getRating());
    }
    @Test
    public void ratingTest4() {
        ratings.Rating p1 = new ratings.Rating("Joe", 0);
        assertEquals("Joe", p1.getReviewerID());
        assertEquals(-1, p1.getRating());
    }

    @Test
    public void ratingTest5() {
        ratings.Rating p1 = new ratings.Rating("Joe", 2);
        p1.setReviewerID("Bob");
        p1.setRating(7);
        assertEquals("Bob", p1.getReviewerID());
        assertEquals(-1, p1.getRating());
    }
    @Test
    public void ratingTest6() {
        ratings.Rating p1 = new ratings.Rating("Joe", 2);
        p1.setReviewerID("Bob");
        p1.setRating(0);
        assertEquals("Bob", p1.getReviewerID());
        assertEquals(-1, p1.getRating());
    }
    @Test
    public void ratingTest7() {
        ratings.Rating p1 = new ratings.Rating("Joe", -100);
        assertEquals("Joe", p1.getReviewerID());
        assertEquals(-1, p1.getRating());
    }
    @Test
    public void ratingTest8() {
        ratings.Rating p1 = new ratings.Rating("Joe", 2);
        p1.setReviewerID("Bob");
        p1.setRating(-70);
        assertEquals("Bob", p1.getReviewerID());
        assertEquals(-1, p1.getRating());
    }

    @Test
    public void ratingTest9() {
        ratings.Rating p1 = new ratings.Rating("Joe", 100);
        assertEquals("Joe", p1.getReviewerID());
        assertEquals(-1, p1.getRating());
    }

    @Test
    public void ratingTest10() {
        ratings.Rating p1 = new ratings.Rating("", 100);
        assertEquals("", p1.getReviewerID());
        assertEquals(-1, p1.getRating());
    }

    @Test
    public void ratingTest11() {
        ratings.Rating p1 = new ratings.Rating("Joe", 100);
        assertEquals("Joe", p1.getReviewerID());
        p1.setReviewerID("");
        assertEquals("", p1.getReviewerID());
    }

    @Test
    public void ratingTest12() {
        ratings.Rating p1 = new ratings.Rating("Joe", 2);
        assertEquals("Joe", p1.getReviewerID());
        assertEquals(2, p1.getRating());
        p1.setReviewerID("");
        p1.setRating(3);
        assertEquals("", p1.getReviewerID());
        assertEquals(3, p1.getRating());
        p1.setReviewerID(" ");
        p1.setRating(4);
        assertEquals(" ", p1.getReviewerID());
        assertEquals(4, p1.getRating());

    }




    @Test
    public void reviewertest1() {
        ratings.Reviewer p1 = new ratings.Reviewer("Joe");
        assertEquals("Joe", p1.getReviewerID());
        ratings.Rating p2 = p1.rateSong(2);
        assertEquals(2, p2.getRating());

    }

    @Test
    public void reviewertest2() {
        ratings.Reviewer p1 = new ratings.Reviewer("Joe");
        assertEquals("Joe", p1.getReviewerID());
        ratings.Rating p2 = p1.rateSong(7);
        assertEquals(-1, p2.getRating());

    }

    @Test
    public void reviewertest3() {
        ratings.Reviewer p1 = new ratings.Reviewer("Joe");
        assertEquals("Joe", p1.getReviewerID());
        ratings.Rating p2 = p1.rateSong(100);
        assertEquals(-1, p2.getRating());

    }

    @Test
    public void reviewertest4() {
        ratings.Reviewer p1 = new ratings.Reviewer("Joe");
        assertEquals("Joe", p1.getReviewerID());
        ratings.Rating p2 = p1.rateSong(0);
        assertEquals(-1, p2.getRating());

    }

    @Test
    public void reviewertest5() {
        ratings.Reviewer p1 = new ratings.Reviewer("");
        assertEquals("", p1.getReviewerID());
        ratings.Rating p2 = p1.rateSong(0);
        assertEquals(-1, p2.getRating());
        assertEquals("", p2.getReviewerID());
    }
    @Test
    public void reviewertest6() {
        ratings.Reviewer p1 = new ratings.Reviewer("Joe");
        assertEquals("Joe", p1.getReviewerID());
        p1.setReviewerID("");
        assertEquals("", p1.getReviewerID());
    }
    @Test
    public void reviewertest7() {
        ratings.Reviewer p1 = new ratings.Reviewer("Joe");
        assertEquals("Joe", p1.getReviewerID());
        ratings.Rating p2 = p1.rateSong(0);
        assertEquals(-1, p2.getRating());
        p1.setReviewerID("");
        assertEquals("", p1.getReviewerID());
        p2.setReviewerID("");
        assertEquals("", p2.getReviewerID());
        ratings.Rating p3 = p1.rateSong(2);
        assertEquals(2, p3.getRating());
        assertEquals("", p3.getReviewerID());
    }


    @Test
    public void reviewertest8() {
        ratings.Reviewer p1 = new ratings.Reviewer("Joe");
        assertEquals("Joe", p1.getReviewerID());
        ratings.Rating p2 = p1.rateSong(2);
        assertEquals(2, p2.getRating());
        assertEquals("Joe", p1.getReviewerID());
        assertEquals(p1.getReviewerID(), p2.getReviewerID());
        p1.setReviewerID("");
        p2.setReviewerID("");
        assertEquals("", p1.getReviewerID());
        assertEquals("", p2.getReviewerID());
        assertEquals(p1.getReviewerID(), p2.getReviewerID());


    }

}
