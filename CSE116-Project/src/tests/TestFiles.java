package tests;

import org.junit.Test;
import ratings.*;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestFiles {

    private void compareSongs(Song expected, Song actual){
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getArtist(), actual.getArtist());
        assertEquals(expected.getSongID(), actual.getSongID());
        assertEquals(expected.averageRating(), actual.averageRating(), 0.0001);

        compareSongsRatingsLinkedList(expected, actual);
    }

    private void compareSongsRatingsLinkedList(Song expected, Song actual){
        assertNotNull(expected.getRatings());
        assertNotNull(actual.getRatings());
        LinkedListNode<Rating> expectedHead = new LinkedListNode<Rating>(expected.getRatings().getValue(), expected.getRatings().getNext());
        LinkedListNode<Rating> actualHead = new LinkedListNode<Rating>(actual.getRatings().getValue(), actual.getRatings().getNext());
        compareSongsRatingsLinkedListHelper(expectedHead, actualHead);
    }

    private void compareSongsRatingsLinkedListHelper (LinkedListNode<Rating> expected, LinkedListNode<Rating> actual) {
//        Rating expectedRating = new Rating(expected.getValue().getReviewerID(), expected.getValue().getRating());
//        Rating actualRating = new Rating(actual.getValue().getReviewerID(), actual.getValue().getRating());
        assertEquals(expected.getValue().getReviewerID(), actual.getValue().getReviewerID());
        assertEquals(expected.getValue().getRating(), actual.getValue().getRating());
        //assert that next will both be not null
        assertFalse((expected.getNext() != null) ^ (actual.getNext() != null));
        if (expected.getNext() != null) {
            compareSongsRatingsLinkedListHelper(expected.getNext(), actual.getNext());
        }
    }

    private void compareSongsArrays(ArrayList<Song> expected, ArrayList<Song> actual){
        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < actual.size(); j++) {
                if (expected.get(i).getSongID().equals(actual.get(j).getSongID())) {
                    compareSongs(expected.get(i), actual.get(j));
                }
            }
        }
    }
    @Test
    public void testSingleSong(){
        String filename = "data/songs_test_1.csv";
        ArrayList<Song> actual = FileReader.readSongs(filename);
        assertFalse(actual.isEmpty());
        ArrayList<Song> expected = new ArrayList<Song>();
//        3ZOEytgrvLwQaqXreDs2Jx,Red Hot Chili Peppers,Can't Stop,30,5
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "3ZOEytgrvLwQaqXreDs2Jx");
        Rating review = new Rating("30", 5);
        song1.addRating(review);
        expected.add(song1);

        compareSongsArrays(expected, actual);
    }
    @Test
    public void testNoFile(){
        String filename = "data/ghost_file";
        ArrayList<Song> actual = FileReader.readSongs(filename);
        assertTrue(actual.isEmpty());
    }
    @Test
    public void testMultipleSongs(){
        String filename = "data/songs_test_2.csv";
        ArrayList<Song> actual = FileReader.readSongs(filename);
        ArrayList<Song> expected = new ArrayList<Song>();
//        3ZOEytgrvLwQaqXreDs2Jx,Red Hot Chili Peppers,Can't Stop,30,5
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "3ZOEytgrvLwQaqXreDs2Jx");
        Rating review = new Rating("30", 5);
        song1.addRating(review);
        expected.add(song1);
//        2mlGPkAx4kwF8Df0GlScsC,Jack Stauber,ButterCup,123,4
        Song song2 = new Song("ButterCup", "Jack Stauber", "2mlGPkAx4kwF8Df0GlScsC");
        Rating review2 = new Rating("123", 4);
        song2.addRating(review2);
        expected.add(song2);



        compareSongsArrays(expected, actual);
    }
    @Test
    public void testMultipleSongs2(){
        String filename = "data/songs_test_4.csv";
        ArrayList<Song> actual = FileReader.readSongs(filename);
        ArrayList<Song> expected = new ArrayList<Song>();
//        3ZOEytgrvLwQaqXreDs2Jx,Red Hot Chili Peppers,Can't Stop,30,5
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "3ZOEytgrvLwQaqXreDs2Jx");
        Rating review = new Rating("30", 5);
        song1.addRating(review);
        expected.add(song1);

        Rating review3 = new Rating("204", 5);
        song1.addRating(review3);
//        2mlGPkAx4kwF8Df0GlScsC,Jack Stauber,ButterCup,123,4
        Song song2 = new Song("ButterCup", "Jack Stauber", "2mlGPkAx4kwF8Df0GlScsC");
        Rating review2 = new Rating("123", 4);
        song2.addRating(review2);
        expected.add(song2);

//        4cOdK2wGLETKBW3PvgPWqT,Rick Astley,Never Gonna Give You Up,244,5
        Song song3 = new Song("Never Gonna Give You Up", "Rick Astley", "4cOdK2wGLETKBW3PvgPWqT");
        Rating review4 = new Rating("244", 5);
        song3.addRating(review4);
        expected.add(song3);



        compareSongsArrays(expected, actual);
    }
    @Test
    public void testDuplicateSong(){
        String filename = "data/songs_test_3.csv";
        ArrayList<Song> actual = FileReader.readSongs(filename);
        ArrayList<Song> expected = new ArrayList<Song>();
//        3ZOEytgrvLwQaqXreDs2Jx,Red Hot Chili Peppers,Can't Stop,30,5
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "3ZOEytgrvLwQaqXreDs2Jx");
        Rating review = new Rating("30", 5);
        song1.addRating(review);
        expected.add(song1);
        Song song2 = new Song("ButterCup", "Jack Stauber", "2mlGPkAx4kwF8Df0GlScsC");
        Rating review2 = new Rating("123", 4);
        song2.addRating(review2);
        expected.add(song2);

        //3ZOEytgrvLwQaqXreDs2Jx,Red Hot Chili Peppers,Can't Stop,204,5
//        Song song3 = new Song("Can't Stop", "Red Hot Chili Peppers", "3ZOEytgrvLwQaqXreDs2Jx");
        Rating review3 = new Rating("204", 5);
        song1.addRating(review3);
//        expected.add(song3);

        compareSongsArrays(expected, actual);
    }

    //movie test methods
    private void compareMovies(ArrayList<String> expected, ArrayList<String> actual){
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i),actual.get(i));
        }

//        compareSongsRatingsLinkedList(expected, actual);
    }

    private void compareMoviesArrays(ArrayList<Movie> expected, ArrayList<Movie> actual){
        assertEquals(expected.size(), actual.size());
        int count = 0;

        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < actual.size(); j++) {
                if (expected.get(i).getTitle().equals(actual.get(j).getTitle())) {
                    compareMovies(expected.get(i).getCast(), actual.get(j).getCast());
                    count++;
                }
            }
        }
        assertEquals(count, expected.size());
    }

    @Test
    public void testSingleMovie(){
        String filename = "data/movies_test_1.csv";
        ArrayList<Movie> actual = FileReader.readMovies(filename);
        assertFalse(actual.isEmpty());
        ArrayList<Movie> expected = new ArrayList<Movie>();
//        Toy Story,Tom Hanks,Tim Allen,Don Rickles,Wallace Shawn,John Ratzenberger,Annie Potts,John Morris,
//        Laurie Metcalf,R. Lee Ermey,Penn Jillette
        ArrayList<String> expectedCastArray = new ArrayList<String>(Arrays.asList("Tom Hanks","Tim Allen","Don Rickles",
                "Wallace Shawn","John Ratzenberger","Annie Potts","John Morris","Laurie Metcalf","R. Lee Ermey",
                "Penn Jillette"));
        Movie movie1 = new Movie("Toy Story", expectedCastArray);
//        Rating review = new Rating("30", 5);
//        song1.addRating(review);
        expected.add(movie1);

        compareMoviesArrays(expected, actual);
    }
    @Test
    public void testNoFileMovie(){
        String filename = "data/ghost_file";
        ArrayList<Movie> actual = FileReader.readMovies(filename);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testMultipleMovies(){
        String filename = "data/movies_test_2.csv";
        ArrayList<Movie> actual = FileReader.readMovies(filename);
        assertFalse(actual.isEmpty());
        ArrayList<Movie> expected = new ArrayList<Movie>();
//        Toy Story,Tom Hanks,Tim Allen,Don Rickles,Wallace Shawn,John Ratzenberger,Annie Potts,John Morris,
//        Laurie Metcalf,R. Lee Ermey,Penn Jillette
        ArrayList<String> expectedCastArray = new ArrayList<String>(Arrays.asList("Tom Hanks","Tim Allen","Don Rickles",
                "Wallace Shawn","John Ratzenberger","Annie Potts","John Morris","Laurie Metcalf","R. Lee Ermey",
                "Penn Jillette"));
        Movie movie1 = new Movie("Toy Story", expectedCastArray);

        //Jumanji,Robin Williams,Jonathan Hyde,Kirsten Dunst,Bonnie Hunt,Bebe Neuwirth,David Alan Grier,Patricia Clarkson,James Handy,Malcolm Stewart,Darryl Henriques
        ArrayList<String> expectedCastArray2 = new ArrayList<String>(Arrays.asList("Robin Williams","Jonathan Hyde",
                "Kirsten Dunst","Bonnie Hunt","Bebe Neuwirth","David Alan Grier","Patricia Clarkson","James Handy",
                "Malcolm Stewart","Darryl Henriques"));
        Movie movie2 = new Movie("Jumanji", expectedCastArray2);

//        Father of the Bride Part II,Steve Martin,Diane Keaton,Martin Short,Kimberly Williams-Paisley,George Newbern,Kieran Culkin,BD Wong,Peter Michael Goetz,Kate McGregor-Stewart,Jane Adams,Eugene Levy,Lori Alan
        ArrayList<String> expectedCastArray3 = new ArrayList<String>(Arrays.asList("Steve Martin","Diane Keaton","Martin Short","Kimberly Williams-Paisley","George Newbern","Kieran Culkin","BD Wong","Peter Michael Goetz","Kate McGregor-Stewart","Jane Adams","Eugene Levy","Lori Alan"));
        Movie movie3 = new Movie("Father of the Bride Part II", expectedCastArray3);

        expected.add(movie1);
        expected.add(movie2);
        expected.add(movie3);

        compareMoviesArrays(expected, actual);
    }
}
