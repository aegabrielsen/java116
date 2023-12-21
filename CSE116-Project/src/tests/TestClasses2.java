package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestClasses2 {



    @Test
    public void songTitleComparatorTest1() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        ratings.Song p2 = new ratings.Song("Only", "Nine Inch Nails", "9999");
        ratings.Song p3 = new ratings.Song("can't Stop", "Red Hot Chili Peppers", "2002");

        SongTitleComparator Compare = new SongTitleComparator();
        assertTrue(Compare.compare(p1, p2));
        assertFalse(Compare.compare(p1, p3));
        assertFalse(Compare.compare(p2, p3));
    }

    @Test
    public void bayesianAverageRatingTest3() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        assertEquals(5, p1.bayesianAverageRating(1000, 5), 0.0001);
        assertEquals(0.0, p1.bayesianAverageRating(-20, 5), 0.0001);
    }

    @Test
    public void bayesianAverageRatingTest3Movie() {
        ArrayList<String> cast = new ArrayList<String>(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"));
        ratings.Movie p1 = new ratings.Movie("The Lord of the Rings", cast);
        assertEquals(5, p1.bayesianAverageRating(1000, 5), 0.0001);
        assertEquals(0.0, p1.bayesianAverageRating(-20, 5), 0.0001);
    }


    @Test
    public void bayesianAverageRatingTest2() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        LinkedListNode first = new LinkedListNode<>(p1, null);
        assertEquals(0.0, p1.bayesianAverageRating(0, 0), 0.0001);

        ratings.Rating ratingtest = new ratings.Rating("Joe", 1);
        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 2);
        ratings.Rating ratingtest3 = new ratings.Rating("a", 3);
        ratings.Rating ratingtest4 = new ratings.Rating("aa", 4);
        ratings.Rating ratingtest5 = new ratings.Rating("aaa", 5);
        ratings.Rating ratingtest6 = new ratings.Rating("aaaa", 0);
        ratings.Rating ratingtest7 = new ratings.Rating("aaaaa", -1);
        ratings.Rating ratingtest8 = new ratings.Rating("aaaaaa", -5);
        ratings.Rating ratingtest9 = new ratings.Rating("aaaaaaa", 18);
        ratings.Rating ratingtest10 = new ratings.Rating("aaaaaaaa", 20);

        p1.addRating(ratingtest);
        p1.addRating(ratingtest2);
        p1.addRating(ratingtest3);
        p1.addRating(ratingtest4);
        p1.addRating(ratingtest5);
        p1.addRating(ratingtest6);
        p1.addRating(ratingtest7);
        p1.addRating(ratingtest8);
        p1.addRating(ratingtest9);
        p1.addRating(ratingtest10);
        assertEquals(3.0, p1.averageRating(), 0.0001);
        assertEquals(3, p1.bayesianAverageRating(3, 3), 0.0001);
        assertEquals(0.0, p1.bayesianAverageRating(-3, 3), 0.0001);
        assertEquals(0.0, p1.bayesianAverageRating(3, 6), 0.0001);
        assertEquals(0.0, p1.bayesianAverageRating(0, 0), 0.0001);
        assertEquals(3, p1.bayesianAverageRating(0, 4), 0.0001);
        assertEquals(0.0, p1.bayesianAverageRating(2, -30), 0.0001);
        // Code above is modified from linkedListTest2 in TestDataStructures1

    }
/*
    @Test
    public void bayesianAverageRatingNewTest1() {
        ArrayList<String> cast = new ArrayList<String>(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"));
        ratings.Movie p1 = new ratings.Movie("The Lord of the Rings", cast);
        ratings.Rating ratingtest = new ratings.Rating("Joe", 1);
        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 2);
        ratings.Rating ratingtest3 = new ratings.Rating("a", 3);
        p1.addRating(ratingtest);
        p1.addRating(ratingtest2);
        p1.addRating(ratingtest3);
        assertEquals(2, p1.bayesianAverageRating(3, 2), 0.0001);
        assertEquals(3.2, p1.bayesianAverageRating(2, 5), 0.0001);
        assertEquals(0.0, p1.bayesianAverageRating(-2, 5), 0.0001);
        assertEquals(2, p1.bayesianAverageRating(2, -5), 0.0001);
        assertEquals(0.0, p1.bayesianAverageRating(-2, -5), 0.0001);
    }

    @Test
    public void bayesianAverageRatingNewTest2() {
        ArrayList<String> cast = new ArrayList<String>(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"));
        ratings.Movie p1 = new ratings.Movie("The Lord of the Rings", cast);
        ratings.Rating ratingtest = new ratings.Rating("Joe", -1);
        ratings.Rating ratingtest2 = new ratings.Rating("Bob", -2);
        ratings.Rating ratingtest3 = new ratings.Rating("a", -3);
        p1.addRating(ratingtest);
        p1.addRating(ratingtest2);
        p1.addRating(ratingtest3);
        assertEquals(2, p1.bayesianAverageRating(3, 2), 0.0001);
        assertEquals(5, p1.bayesianAverageRating(2, 5), 0.0001);
    }
*/
    @Test
    public void movieNewTest1() {

        ArrayList<String> cast = new ArrayList<String>(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"));
        ratings.Movie p1 = new ratings.Movie("The Lord of the Rings", cast);
        assertEquals("The Lord of the Rings", p1.getTitle());
        assertEquals(3, p1.getCast().size());
        assertTrue("Elijah Wood".equalsIgnoreCase(p1.getCast().get(0)));
        assertTrue("Ian McKellen".equalsIgnoreCase(p1.getCast().get(1)));
        assertTrue("Viggo Mortensen".equalsIgnoreCase(p1.getCast().get(2)));
    }
    @Test
    public void movieNewTest2() {

        ArrayList<String> cast = new ArrayList<String>(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"));
        ratings.Movie p1 = new ratings.Movie("The Lord of the Rings", cast);
        assertEquals("The Lord of the Rings", p1.getTitle());
        assertTrue("Elijah Wood".equalsIgnoreCase(p1.getCast().get(0)));
    }


//    bayesian_bad_on_no_fake_ratings
//
//    extra_bayesian_rating
//
//    missing_last_cast_member




/*
    @Test
    public void bayesianAverageRatingTest1() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        LinkedListNode first = new LinkedListNode<>(p1, null);

        ratings.Song p2 = (Song) first.getValue();
        assertEquals("Can't Stop", p2.getTitle());
        assertEquals("Red Hot Chili Peppers", p2.getArtist());
        assertEquals("2002", p2.getSongID());

        assertEquals(3.0, p1.bayesianAverageRating(2,3), 0.0001);
        ratings.Rating ratingtest = new ratings.Rating("Joe", 2);
        p1.addRating(ratingtest);
        ratings.Rating firstRating = (Rating) p1.getRatings().getValue();
        assertEquals("Joe", firstRating.getReviewerID());
        assertEquals(2, firstRating.getRating());
        assertNull(p1.getRatings().getNext());
//      test for first element in linked list

        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 3);
        p1.addRating(ratingtest2);
        ratings.Rating secondRating = (Rating) p1.getRatings().getNext().getValue();
        assertEquals("Joe", firstRating.getReviewerID());
        assertEquals(2, firstRating.getRating());
//        assertNull(p1.getRatings().getNext());
        assertEquals("Bob", secondRating.getReviewerID());
        assertEquals(3, secondRating.getRating());
        assertNull(p1.getRatings().getNext().getNext());
//      test for second element in linked list

//        ratings.Rating ratingtest3 = new ratings.Rating("Tom", 0);
//        LinkedListNode<Rating> newNode = new LinkedListNode<>(ratingtest3, null);
//        p1.setRatings(newNode);

//        ratings.Rating newHeadRating = (Rating) p1.getRatings().getValue();
//        assertEquals("Tom", newHeadRating.getReviewerID());
//        assertEquals(-1, newHeadRating.getRating());
//        assertNull(p1.getRatings().getNext());
//      new head of list

//        p1.addRating(ratingtest);
//        p1.addRating(ratingtest2);
//        ratings.Rating newRatingSecond = (Rating) p1.getRatings().getNext().getValue();
//        ratings.Rating newRatingThird = (Rating) p1.getRatings().getNext().getNext().getValue();
//
//        assertEquals("Joe", newRatingSecond.getReviewerID());
//        assertEquals(2, newRatingSecond.getRating());
//        assertEquals("Bob", newRatingThird.getReviewerID());
//        assertEquals(3, newRatingThird.getRating());
//        assertNull(p1.getRatings().getNext().getNext().getNext());
        //      adding original two back

        assertEquals(2.5, p1.bayesianAverageRating(10,6), 0.0001);
        assertEquals(4, p1.bayesianAverageRating(3,5), 0.0001);
//      testing average rating

    }
    */




    /*
    @Test
    public void movieTest1() {
        ArrayList<String> cast = new ArrayList<String>(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"));
        ratings.Movie p1 = new ratings.Movie("The Lord of the Rings", cast);
        assertEquals("The Lord of the Rings", p1.getTitle());
        assertEquals(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"), p1.getCast());
        // TODO Check individual items in the array?
    }
*/
/*
    @Test
    public void bayesianAverageRatingTest1Movie() {
        ArrayList<String> cast = new ArrayList<String>(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"));
        ratings.Movie p1 = new ratings.Movie("The Lord of the Rings", cast);

        LinkedListNode first = new LinkedListNode<>(p1, null);

//        ratings.Song p2 = (Song) first.getValue();
//        assertEquals("Can't Stop", p2.getTitle());
//        assertEquals("Red Hot Chili Peppers", p2.getArtist());
//        assertEquals("2002", p2.getSongID());

        assertEquals(3.0, p1.bayesianAverageRating(2,3), 0.0001);
        ratings.Rating ratingtest = new ratings.Rating("Joe", 2);
        p1.addRating(ratingtest);
        ratings.Rating firstRating = (Rating) p1.getRatings().getValue();
        assertEquals("Joe", firstRating.getReviewerID());
        assertEquals(2, firstRating.getRating());
        assertNull(p1.getRatings().getNext());
//      test for first element in linked list

        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 3);
        p1.addRating(ratingtest2);
        ratings.Rating secondRating = (Rating) p1.getRatings().getNext().getValue();
        assertEquals("Joe", firstRating.getReviewerID());
        assertEquals(2, firstRating.getRating());
//        assertNull(p1.getRatings().getNext());
        assertEquals("Bob", secondRating.getReviewerID());
        assertEquals(3, secondRating.getRating());
        assertNull(p1.getRatings().getNext().getNext());
//      test for second element in linked list

//        ratings.Rating ratingtest3 = new ratings.Rating("Tom", 0);
//        LinkedListNode<Rating> newNode = new LinkedListNode<>(ratingtest3, null);
//        p1.setRatings(newNode);
//
//        ratings.Rating newHeadRating = (Rating) p1.getRatings().getValue();
//        assertEquals("Tom", newHeadRating.getReviewerID());
//        assertEquals(-1, newHeadRating.getRating());
//        assertNull(p1.getRatings().getNext());
////      new head of list
//
//        p1.addRating(ratingtest);
//        p1.addRating(ratingtest2);
//        ratings.Rating newRatingSecond = (Rating) p1.getRatings().getNext().getValue();
//        ratings.Rating newRatingThird = (Rating) p1.getRatings().getNext().getNext().getValue();
//
//        assertEquals("Joe", newRatingSecond.getReviewerID());
//        assertEquals(2, newRatingSecond.getRating());
//        assertEquals("Bob", newRatingThird.getReviewerID());
//        assertEquals(3, newRatingThird.getRating());
//        assertNull(p1.getRatings().getNext().getNext().getNext());
        //      adding original two back

        assertEquals(2.5, p1.bayesianAverageRating(10,6), 0.0001);
        assertEquals(4, p1.bayesianAverageRating(3,5), 0.0001);
//      testing average rating

    }
    @Test
    public void bayesianAverageRatingTest2Movie() {
        ArrayList<String> cast = new ArrayList<String>(Arrays.asList("Elijah Wood", "Ian McKellen", "Viggo Mortensen"));
        ratings.Movie p1 = new ratings.Movie("The Lord of the Rings", cast);
        LinkedListNode first = new LinkedListNode<>(p1, null);
        assertEquals(0.0, p1.bayesianAverageRating(0, 0), 0.0001);

        ratings.Rating ratingtest = new ratings.Rating("Joe", 1);
        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 2);
        ratings.Rating ratingtest3 = new ratings.Rating("a", 3);
        ratings.Rating ratingtest4 = new ratings.Rating("aa", 4);
        ratings.Rating ratingtest5 = new ratings.Rating("aaa", 5);
        ratings.Rating ratingtest6 = new ratings.Rating("aaaa", 0);
        ratings.Rating ratingtest7 = new ratings.Rating("aaaaa", -1);
        ratings.Rating ratingtest8 = new ratings.Rating("aaaaaa", -5);
        ratings.Rating ratingtest9 = new ratings.Rating("aaaaaaa", 18);
        ratings.Rating ratingtest10 = new ratings.Rating("aaaaaaaa", 20);

        p1.addRating(ratingtest);
        p1.addRating(ratingtest2);
        p1.addRating(ratingtest3);
        p1.addRating(ratingtest4);
        p1.addRating(ratingtest5);
        p1.addRating(ratingtest6);
        p1.addRating(ratingtest7);
        p1.addRating(ratingtest8);
        p1.addRating(ratingtest9);
        p1.addRating(ratingtest10);
        assertEquals(3.75, p1.bayesianAverageRating(3, 5), 0.0001);
        // Code above is modified from linkedListTest2 in TestDataStructures1

    }

    */


    /*
    @Test
    public void songBayesianRatingTest1() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        ratings.Song p2 = new ratings.Song("Only", "Nine Inch Nails", "9999");

        LinkedListNode first = new LinkedListNode<>(p1, null);
        assertEquals(0.0, p1.bayesianAverageRating(0, 0), 0.0001);

        ratings.Rating ratingtest = new ratings.Rating("Joe", 1);
        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 2);
        ratings.Rating ratingtest3 = new ratings.Rating("a", 3);
        ratings.Rating ratingtest4 = new ratings.Rating("aa", 4);
        ratings.Rating ratingtest5 = new ratings.Rating("aaa", 5);
        ratings.Rating ratingtest6 = new ratings.Rating("aaaa", 0);
        ratings.Rating ratingtest7 = new ratings.Rating("aaaaa", -1);
        ratings.Rating ratingtest8 = new ratings.Rating("aaaaaa", -5);
        ratings.Rating ratingtest9 = new ratings.Rating("aaaaaaa", 18);
        ratings.Rating ratingtest10 = new ratings.Rating("aaaaaaaa", 20);

        p1.addRating(ratingtest);
        p1.addRating(ratingtest2);
        p1.addRating(ratingtest3);
        p1.addRating(ratingtest4);
        p1.addRating(ratingtest5);
        p1.addRating(ratingtest6);
        p1.addRating(ratingtest7);
        p1.addRating(ratingtest8);
        p1.addRating(ratingtest9);
        p1.addRating(ratingtest10);
        assertEquals(3.75, p1.bayesianAverageRating(3, 5), 0.0001);

        LinkedListNode second = new LinkedListNode<>(p2, null);
        assertEquals(0.0, p2.bayesianAverageRating(0, 0), 0.0001);

//        ratings.Rating ratingtest = new ratings.Rating("Joe", 1);
//        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 2);
//        ratings.Rating ratingtest3 = new ratings.Rating("a", 3);
//        ratings.Rating ratingtest4 = new ratings.Rating("aa", 4);
//        ratings.Rating ratingtest5 = new ratings.Rating("aaa", 5);
//        ratings.Rating ratingtest6 = new ratings.Rating("aaaa", 0);
//        ratings.Rating ratingtest7 = new ratings.Rating("aaaaa", -1);
//        ratings.Rating ratingtest8 = new ratings.Rating("aaaaaa", -5);
//        ratings.Rating ratingtest9 = new ratings.Rating("aaaaaaa", 18);
//        ratings.Rating ratingtest10 = new ratings.Rating("aaaaaaaa", 20);

        p2.addRating(ratingtest);
        p2.addRating(ratingtest2);
        p2.addRating(ratingtest3);
        p2.addRating(ratingtest4);
        p2.addRating(ratingtest5);
        p2.addRating(ratingtest6);
        p2.addRating(ratingtest7);
        p2.addRating(ratingtest8);
        p2.addRating(ratingtest9);
        p2.addRating(ratingtest10);
        assertEquals(3.75, p2.bayesianAverageRating(3, 5), 0.0001);

        SongBayesianRatingComparator Compare = new SongBayesianRatingComparator();
        assertFalse(Compare.compare(p1, p2));
        ratings.Rating ratingtest11 = new ratings.Rating("extra", 5);
        p1.addRating(ratingtest11);
        assertTrue(Compare.compare(p1, p2));

    }
*/


}
