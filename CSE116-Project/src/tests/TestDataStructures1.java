package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

import static org.junit.Assert.*;

public class TestDataStructures1 {

    @Test
    public void linkedListTest1() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        LinkedListNode first = new LinkedListNode<>(p1, null);
//        System.out.println(first.getValue());

        ratings.Song p2 = (Song) first.getValue();
//        System.out.println(p2.getTitle());
        assertEquals("Can't Stop", p2.getTitle());
        assertEquals("Red Hot Chili Peppers", p2.getArtist());
        assertEquals("2002", p2.getSongID());

        assertNull(p1.getRatings());
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

        ratings.Rating ratingtest3 = new ratings.Rating("Tom", 0);
        LinkedListNode newNode = new LinkedListNode<>(ratingtest3, null);
        p1.setRatings(newNode);

        ratings.Rating newHeadRating = (Rating) p1.getRatings().getValue();
        assertEquals("Tom", newHeadRating.getReviewerID());
        assertEquals(-1, newHeadRating.getRating());
        assertNull(p1.getRatings().getNext());
//      new head of list

        p1.addRating(ratingtest);
        p1.addRating(ratingtest2);
        ratings.Rating newRatingSecond = (Rating) p1.getRatings().getNext().getValue();
        ratings.Rating newRatingThird = (Rating) p1.getRatings().getNext().getNext().getValue();

        assertEquals("Joe", newRatingSecond.getReviewerID());
        assertEquals(2, newRatingSecond.getRating());
        assertEquals("Bob", newRatingThird.getReviewerID());
        assertEquals(3, newRatingThird.getRating());
        assertNull(p1.getRatings().getNext().getNext().getNext());
        //      adding original two back

        assertEquals(2.5, p1.averageRating(), 0.0001);
//      testing average rating

    }

    @Test
    public void linkedListTest2() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        LinkedListNode first = new LinkedListNode<>(p1, null);
        assertEquals(0.0, p1.averageRating(), 0.0001);

//        ratings.Rating ratingtest = new ratings.Rating("Joe", 2);
//        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 4);
//        for (int i = 0; i < 100; i++) {
//            p1.addRating(ratingtest);
//            p1.addRating(ratingtest2);
//        }
//        assertEquals(3.0, p1.averageRating(), 0.0001);
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
    }



    @Test
    public void linkedListTest3() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
//        LinkedListNode first = new LinkedListNode<>(p1, null);
//        assertEquals(0.0, p1.averageRating(), 0.0001);

        ratings.Rating ratingtest = new ratings.Rating("Joe", 2);
        p1.addRating(ratingtest);
        ratings.Rating firstRating = (Rating) p1.getRatings().getValue();
        assertEquals("Joe", firstRating.getReviewerID());
        assertEquals(2, firstRating.getRating());
        ratings.Reviewer testReviewer = new ratings.Reviewer("Joe");
        p1.removeRatingByReviewer(testReviewer);
        assertNull(p1.getRatings());


    }    @Test
    public void linkedListTest4() {
        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");


        ratings.Rating ratingtest = new ratings.Rating("Joe", 2);
        p1.addRating(ratingtest);
        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 3);
        p1.addRating(ratingtest2);
        ratings.Rating ratingtest3 = new ratings.Rating("Tom", 4);
        p1.addRating(ratingtest3);
        ratings.Rating firstRating = (Rating) p1.getRatings().getValue();
        ratings.Rating secondRating = (Rating) p1.getRatings().getNext().getValue();
        ratings.Rating thirdRating = (Rating) p1.getRatings().getNext().getNext().getValue();
        assertEquals("Joe", firstRating.getReviewerID());
        assertEquals(2, firstRating.getRating());
        assertEquals("Bob", secondRating.getReviewerID());
        assertEquals(3, secondRating.getRating());
        assertEquals("Tom", thirdRating.getReviewerID());
        assertEquals(4, thirdRating.getRating());


        ratings.Reviewer testReviewer = new ratings.Reviewer("Joe");
        p1.removeRatingByReviewer(testReviewer);
        if(p1.getRatings() != null) {
            firstRating = (Rating) p1.getRatings().getValue();
            secondRating = (Rating) p1.getRatings().getNext().getValue();
            assertEquals(firstRating.getReviewerID(), "Bob");
            assertEquals(firstRating.getRating(), 3);
            assertEquals(secondRating.getReviewerID(), "Tom");
            assertEquals(secondRating.getRating(), 4);
            assertNull(p1.getRatings().getNext().getNext());
        } else {
            assertNotNull(p1.getRatings());
        }
//
//
//        ratings.Reviewer testReviewer2 = new ratings.Reviewer("Bob");
//        p1.removeRatingByReviewer(testReviewer2);
//        firstRating = (Rating) p1.getRatings().getValue();
//        assertEquals(firstRating.getReviewerID(), "Tom");
//        assertEquals(firstRating.getRating(), 4);
//        assertNull(p1.getRatings().getNext());



    }
//        @Test
//    public void linkedListTest5() {
//        ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");
//
//        ratings.Rating ratingtest = new ratings.Rating("Joe", 2);
//        p1.addRating(ratingtest);
//        p1.addRating(ratingtest);
//        ratings.Rating ratingtest2 = new ratings.Rating("Bob", 3);
//        p1.addRating(ratingtest2);
//        ratings.Rating ratingtest3 = new ratings.Rating("Tom", 4);
//        p1.addRating(ratingtest3);
//        ratings.Rating firstRating = (Rating) p1.getRatings().getValue();
//        ratings.Rating secondRating = (Rating) p1.getRatings().getNext().getValue();
//        ratings.Rating thirdRating = (Rating) p1.getRatings().getNext().getNext().getValue();
//        ratings.Rating fourthRating = (Rating) p1.getRatings().getNext().getNext().getNext().getValue();
//        assertEquals("Joe", firstRating.getReviewerID());
//        assertEquals(2, firstRating.getRating());
//        assertEquals("Joe", secondRating.getReviewerID());
//        assertEquals(2, secondRating.getRating());
//        assertEquals("Bob", thirdRating.getReviewerID());
//        assertEquals(3, thirdRating.getRating());
//        assertEquals("Tom", fourthRating.getReviewerID());
//        assertEquals(4, fourthRating.getRating());
//        assertNull(p1.getRatings().getNext().getNext().getNext().getNext());
//
//        ratings.Reviewer testReviewer = new ratings.Reviewer("Joe");
//        p1.removeRatingByReviewer(testReviewer);
//        firstRating = (Rating) p1.getRatings().getValue();
//        secondRating = (Rating) p1.getRatings().getNext().getValue();
//        thirdRating = (Rating) p1.getRatings().getNext().getNext().getValue();
//            assertEquals("Joe", firstRating.getReviewerID());
//            assertEquals(2, firstRating.getRating());
//            assertEquals("Bob", secondRating.getReviewerID());
//            assertEquals(3, secondRating.getRating());
//            assertEquals("Tom", thirdRating.getReviewerID());
//            assertEquals(4, thirdRating.getRating());
//            assertNull(p1.getRatings().getNext().getNext().getNext());
//
//
//    }


  @Test
public void linkedListTest6() {
      ratings.Song p1 = new ratings.Song("Can't Stop", "Red Hot Chili Peppers", "2002");


      ratings.Rating ratingtest = new ratings.Rating("Joe", 2);
      p1.addRating(ratingtest);
      ratings.Rating ratingtest2 = new ratings.Rating("Bob", 3);
      p1.addRating(ratingtest2);
      ratings.Rating ratingtest3 = new ratings.Rating("Tom", 4);
      p1.addRating(ratingtest3);
      ratings.Rating firstRating = (Rating) p1.getRatings().getValue();
      ratings.Rating secondRating = (Rating) p1.getRatings().getNext().getValue();
      ratings.Rating thirdRating = (Rating) p1.getRatings().getNext().getNext().getValue();
      assertEquals("Joe", firstRating.getReviewerID());
      assertEquals(2, firstRating.getRating());
      assertEquals("Bob", secondRating.getReviewerID());
      assertEquals(3, secondRating.getRating());
      assertEquals("Tom", thirdRating.getReviewerID());
      assertEquals(4, thirdRating.getRating());

      ratings.Reviewer testReviewer = new ratings.Reviewer("Tom");
      p1.removeRatingByReviewer(testReviewer);
      if(p1.getRatings() != null) {
          firstRating = (Rating) p1.getRatings().getValue();
          secondRating = (Rating) p1.getRatings().getNext().getValue();
          assertEquals(firstRating.getReviewerID(), "Joe");
          assertEquals(firstRating.getRating(), 2);
          assertEquals(secondRating.getReviewerID(), "Bob");
          assertEquals(secondRating.getRating(), 3);
          assertNull(p1.getRatings().getNext().getNext());
      } else {
          assertNotNull(p1.getRatings());
      }

}

}


//