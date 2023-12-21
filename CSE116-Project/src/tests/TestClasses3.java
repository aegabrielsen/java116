package tests;

import org.junit.Test;
import ratings.*;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static ratings.FileReader.readMovieRatings;
import static ratings.FileReader.readMovies;

public class TestClasses3 {

    private void compareMoviesRatingsLinkedList(Movie expected, Movie actual){
        assertNotNull(expected.getRatings());
        assertNotNull(actual.getRatings());
        LinkedListNode<Rating> expectedHead = new LinkedListNode<Rating>(expected.getRatings().getValue(), expected.getRatings().getNext());
        LinkedListNode<Rating> actualHead = new LinkedListNode<Rating>(actual.getRatings().getValue(), actual.getRatings().getNext());
        compareMoviesRatingsLinkedListHelper(expectedHead, actualHead);
    }

    private void compareMoviesRatingsLinkedListHelper (LinkedListNode<Rating> expected, LinkedListNode<Rating> actual) {
//        Rating expectedRating = new Rating(expected.getValue().getReviewerID(), expected.getValue().getRating());
//        Rating actualRating = new Rating(actual.getValue().getReviewerID(), actual.getValue().getRating());
        assertEquals(expected.getValue().getReviewerID(), actual.getValue().getReviewerID());
        assertEquals(expected.getValue().getRating(), actual.getValue().getRating());
        //assert that next will both be not null
        assertFalse((expected.getNext() != null) ^ (actual.getNext() != null));
        if (expected.getNext() != null) {
            compareMoviesRatingsLinkedListHelper(expected.getNext(), actual.getNext());
        }
    }
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
                    compareMoviesRatingsLinkedList(expected.get(i), actual.get(j));
                    count++;
                }
            }
        }
        assertEquals(count, expected.size());
    }
    @Test
    public void test1() {
//        readMovieRatings(readMovies("movies_test_task_7_1"), "data/movies_test_task_7_1_ratings");

        ArrayList<Movie> actual = readMovieRatings(readMovies("data/movies_test_task_7_1.csv"), "data/movies_test_task_7_1_ratings.csv");
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

//        Toy Story,1,2
//        Jumanji,2,4
//        Father of the Bride Part II,55,3
        movie1.addRating(new Rating("1", 2));
        movie2.addRating(new Rating("2", 4));
        movie3.addRating(new Rating("55", 3));
        movie3.addRating(new Rating("44", 2));

        expected.add(movie1);
        expected.add(movie2);
        expected.add(movie3);

        compareMoviesArrays(expected, actual);

    }

    @Test
    public void testNoFile(){
        String filename = "data/ghost_file";
        ArrayList<Movie> actual = FileReader.readMovieRatings(readMovies("data/movies_test_task_7_1.csv"), filename);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testTopK1(){
        ArrayList<Ratable> expected = new ArrayList<>();
//        3ZOEytgrvLwQaqXreDs2Jx,Red Hot Chili Peppers,Can't Stop,30,5
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "3ZOEytgrvLwQaqXreDs2Jx");
        Rating review = new Rating("30", 5);
        song1.addRating(review);

        Rating review3 = new Rating("204", 5);
        song1.addRating(review3);
//        2mlGPkAx4kwF8Df0GlScsC,Jack Stauber,ButterCup,123,4
        Song song2 = new Song("ButterCup", "Jack Stauber", "2mlGPkAx4kwF8Df0GlScsC");
        Rating review2 = new Rating("123", 4);
        song2.addRating(review2);

//        4cOdK2wGLETKBW3PvgPWqT,Rick Astley,Never Gonna Give You Up,244,5
        Song song3 = new Song("Never Gonna Give You Up", "Rick Astley", "4cOdK2wGLETKBW3PvgPWqT");
        Rating review4 = new Rating("244", 5);
        song3.addRating(review4);


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

//        Toy Story,1,2
//        Jumanji,2,4
//        Father of the Bride Part II,55,3
        movie1.addRating(new Rating("1", 2));
        movie2.addRating(new Rating("2", 4));
        movie3.addRating(new Rating("55", 3));
        movie3.addRating(new Rating("44", 2));

        expected.add(song1);
        expected.add(song3);
        expected.add(song2);
        expected.add(movie2);

        expected.add(movie3);
        expected.add(movie1);

        String filename1 = "data/songs_test_5.csv";
        String filename2 = "data/movies_test_task_7_1.csv";
        String filename3 = "data/movies_test_task_7_1_ratings.csv";


        MediaLibrary library = new MediaLibrary();
        library.populateLibrary(filename1, filename2, filename3);
        ArrayList<Ratable> actual = new ArrayList<>(library.topKRatables(6));
        assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getTitle(), expected.get(i).getTitle());
//            assertTrue(actual.contains(expected.get(i).getTitle()));
            System.out.println(actual.get(i).bayesianAverageRating(2,3) + actual.get(i).getTitle() + " " + expected.get(i).bayesianAverageRating(2,3));
        }
    }

    @Test
    public void testTopK2(){
        ArrayList<Ratable> expected = new ArrayList<>();
//        3ZOEytgrvLwQaqXreDs2Jx,Red Hot Chili Peppers,Can't Stop,30,5
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "3ZOEytgrvLwQaqXreDs2Jx");
        Rating review = new Rating("30", 5);
        song1.addRating(review);

        Rating review3 = new Rating("204", 5);
        song1.addRating(review3);
//        2mlGPkAx4kwF8Df0GlScsC,Jack Stauber,ButterCup,123,4
        Song song2 = new Song("ButterCup", "Jack Stauber", "2mlGPkAx4kwF8Df0GlScsC");
        Rating review2 = new Rating("123", 4);
        song2.addRating(review2);

//        4cOdK2wGLETKBW3PvgPWqT,Rick Astley,Never Gonna Give You Up,244,5
        Song song3 = new Song("Never Gonna Give You Up", "Rick Astley", "4cOdK2wGLETKBW3PvgPWqT");
        Rating review4 = new Rating("244", 5);
        song3.addRating(review4);


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

//        Toy Story,1,2
//        Jumanji,2,4
//        Father of the Bride Part II,55,3
        movie1.addRating(new Rating("1", 2));
        movie2.addRating(new Rating("2", 4));
        movie3.addRating(new Rating("55", 3));
        movie3.addRating(new Rating("44", 2));

        expected.add(song1);
        expected.add(song3);
//        expected.add(song2);
//        expected.add(movie2);

//        expected.add(movie3);
//        expected.add(movie1);

        String filename1 = "data/songs_test_5.csv";
        String filename2 = "data/movies_test_task_7_1.csv";
        String filename3 = "data/movies_test_task_7_1_ratings.csv";


        MediaLibrary library = new MediaLibrary();
        library.populateLibrary(filename1, filename2, filename3);
        ArrayList<Ratable> actual = new ArrayList<>(library.topKRatables(2));
        assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getTitle(), expected.get(i).getTitle());
//            assertTrue(actual.contains(expected.get(i).getTitle()));
            System.out.println(actual.get(i).bayesianAverageRating(2,3) + actual.get(i).getTitle() + " " + expected.get(i).bayesianAverageRating(2,3));
        }
    }
}