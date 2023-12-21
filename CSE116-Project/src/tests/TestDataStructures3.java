package tests;

import org.junit.Test;
import ratings.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
public class TestDataStructures3 {
//    @Test
//    public void testSimpleGraph(){
//        String filename = "data/movies_graph_test_1.csv";
//        ArrayList<Movie> actual = FileReader.readMovies(filename);
//        assertFalse(actual.isEmpty());
//        Graph<String> graph = new Graph<>();
//        /*
//        ArrayList<Movie> expected = new ArrayList<Movie>();
////        Toy Story,Tom Hanks,Tim Allen,Don Rickles,Wallace Shawn,John Ratzenberger,Annie Potts,John Morris,
////        Laurie Metcalf,R. Lee Ermey,Penn Jillette
//        ArrayList<String> expectedCastArray = new ArrayList<String>(Arrays.asList("Tom Hanks","Tim Allen","Don Rickles",
//                "Wallace Shawn","John Ratzenberger","Annie Potts","John Morris","Laurie Metcalf","R. Lee Ermey",
//                "Penn Jillette"));
//        Movie movie1 = new Movie("Toy Story", expectedCastArray);
////        Rating review = new Rating("30", 5);
////        song1.addRating(review);
//        expected.add(movie1);
//
//        compareMoviesArrays(expected, actual);
//        */
//        for (int i = 0; i < actual.size(); i++) {
//            ArrayList<String> castList = actual.get(i).getCast();
//            if (castList.size() > 1) {
//                for (int j = 0; j < castList.size() - 1; j++) {
//                    for (int k = j + 1; k < castList.size(); k++) {
//                        graph.addBidirectionalEdge(castList.get(j), castList.get(k));
//                        System.out.println(castList.get(j) + " " + castList.get(j + 1));
//                    }
//                }
//            }
//        }
//        HashMap<String, ArrayList<String>> testGraph = graph.getAdjacencyList();
//
//        for (String i : testGraph.keySet()) {
//            System.out.println("key: " + i + " value: " + testGraph.get(i));
//        }
//    }
    @Test
    public void testSimpleGraph2(){
        String filename = "data/movies_graph_test_1.csv";
        ArrayList<Movie> actual = FileReader.readMovies(filename);
        assertFalse(actual.isEmpty());

        DegreesOfSeparation DegreesBetweenTwoActors = new DegreesOfSeparation(actual);


        // Movie 1,Bob,Tom,Jon
        // Movie 2,Tom,Jon,Sam
        // Movie 3,Sam,Ron
        // Movie 4,Ron
        assertEquals(0, DegreesBetweenTwoActors.degreesOfSeparation("Bob", "Bob"));
        assertEquals(1, DegreesBetweenTwoActors.degreesOfSeparation("Bob", "Tom"));
        assertEquals(2, DegreesBetweenTwoActors.degreesOfSeparation("Bob", "Sam"));
        assertEquals(3, DegreesBetweenTwoActors.degreesOfSeparation("Bob", "Ron"));
        assertEquals(-1, DegreesBetweenTwoActors.degreesOfSeparation("Bob", "Steve"));



//        Graph<String> graph = new Graph<>();

//        for (int i = 0; i < actual.size(); i++) {
//            ArrayList<String> castList = actual.get(i).getCast();
//            if (castList.size() > 1) {
//                for (int j = 0; j < castList.size() - 1; j++) {
//                    for (int k = j + 1; k < castList.size(); k++) {
//                        graph.addBidirectionalEdge(castList.get(j), castList.get(k));
//                        System.out.println(castList.get(j) + " " + castList.get(j + 1));
//                    }
//                }
//            }
//        }
//        HashMap<String, ArrayList<String>> testGraph = graph.getAdjacencyList();

//        for (String i : testGraph.keySet()) {
//            System.out.println("key: " + i + " value: " + testGraph.get(i));
//        }
    }
}
