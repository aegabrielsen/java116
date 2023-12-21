package ratings;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class FileReader {

    public static ArrayList<Song> readSongs(String filename) {
        HashMap<String, Song> songsHash = new HashMap<>();

        ArrayList<Song> songs = new ArrayList<Song>();
        ArrayList<String> lines = readFileHelper(filename);
        if (lines.isEmpty()) {
            return songs;
        }
//        lines.remove(0);
//        Above is to remove header (I think) but there is no header for the ratings.csv
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
//            "songID,artist,title,reviewerID,rating"
            String songID = splits.get(0);
            String artist = splits.get(1);
            String title = splits.get(2);
            String reviewerID = splits.get(3);
            int rating = Integer.parseInt(splits.get(4));
            Song song = new Song(title, artist, songID);
            Rating review = new Rating(reviewerID, rating);

            if (!songsHash.containsKey(songID)) {
                songsHash.put(songID, song);
            }
            songsHash.get(songID).addRating(review);

        }

        for (Song value : songsHash.values()) {
            songs.add(value);
        }

        return songs;

    }

    public static ArrayList<String> readFileHelper(String filename) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

//    A static method named readSongs that takes a String as a parameter and returns an ArrayList of Songs. Write tests
//    for this method in a test class named tests.TestFiles
//    The input String is the name of a file to be read. Test this method with a CSV file where each line matches the
//    format from the ratings.csv file that you can download from the song rating app
//    "songID,artist,title,reviewerID,rating"
//    The method will return an ArrayList of Songs containing all of the information from the input file. If a song
//    appears in the file more than once, this means that it has been rated by multiple reviewers. In this case,
//    only one Song object should be returned for that Song and it should contain all of the ratings from the file
//    If the input file does not exist, the method will return an empty ArrayList
//    The Songs in the returned ArrayList may appear in any order. Your tests must accept any order of the returned
//    Songs (This is much of the challenge in writing these tests)
//    The ratings for each Song must be in the order in which they appear in the file. When testing the Linked List of
//    Ratings for a Song, you can assume that they are in the same order in which they appear in the file
//    (This will make it simpler to test the Linked List)
//

//    public static ArrayList<Movie> readMovies(String filename) {
//        return new ArrayList<>();
//    }


    public static ArrayList<Movie> readMovies(String filename) {
//        HashMap<String, Movie> moviesHash = new HashMap<>();

        ArrayList<Movie> movies = new ArrayList<Movie>();
        ArrayList<String> lines = readFileHelper(filename);
        if (lines.isEmpty()) { return movies; }
//        lines.remove(0);
//        Above is to remove header (I think) but there is no header for the ratings.csv
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
//          "movieTitle,castMember0,castMember1,castMember2,etc"
            String movieTitle = splits.get(0);
            ArrayList<String> castMembers = new ArrayList<>();
            for (int i = 1; i < splits.size(); i++) {
                castMembers.add(splits.get(i));
            }
            Movie newMovie = new Movie(movieTitle, castMembers);
            movies.add(newMovie);
//            int rating = Integer.parseInt(splits.get(4));
//            Movie song = new Movie(title, artist, songID);
//            Rating review = new Rating(reviewerID, rating);

            /*
            if(!moviesHash.containsKey(songID)){
                moviesHash.put(songID, song);
            }
            moviesHash.get(songID).addRating(review);

        }

        for (Movie value : moviesHash.values()) {
            movies.add(value);
        }
        */


        }
        return movies;
    }

//    A static method named readMovies that takes a String as a parameter and returns and ArrayList of Movies. Write
//    tests for this method in the test class named tests.TestFiles
//    The input String is the name of a file to be read. Test this method with a CSV file where each line matches the
//    format from the movies.csv file that you can download above "movieTitle,castMember0,castMember1,castMember2,etc"
//    and there can be number of cast members, but there must be at least one cast member per movie
//    The method will return an ArrayList of Movies containing all of the information from the input file
//    If the input file does not exist, the method will return an empty ArrayList
//    The Movies in the returned ArrayList may appear in any order. Your tests must accept any order of the returned
//    Movies (This is much of the challenge in writing these tests)
//    The cast for each Movie must be in the ArrayList in the same order in which they appear in the line for that
//    movie. You should assume this order when testing the cast ArrayLists

// Task 7 code

    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> movies, String filename) {
        ArrayList<Movie> ratedMovies = new ArrayList<Movie>();
        ArrayList<String> lines = readFileHelper(filename);
        if (lines.isEmpty()) { return ratedMovies; }
//        lines.remove(0);
//        Above is to remove header (I think) but there is no header for the ratings.csv
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
//          "title,reviewerId,rating"
            String movieTitle = splits.get(0);
//            String movieReviewerId = splits.get(1);
//            int movieRating = Integer.parseInt(splits.get(2));
            Rating currentRating = new Rating(splits.get(1), Integer.parseInt(splits.get(2)));



            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getTitle().equals(movieTitle)) {
                    // title of movie at i is the same as the line we are looking at in the ratings file
                    movies.get(i).addRating(currentRating);
                    boolean movieAlreadyExists = false;
                    for (int j = 0; j < ratedMovies.size(); j++) {
                        if (movies.get(i).getTitle().equals(ratedMovies.get(j).getTitle())) {
                            movieAlreadyExists = true;
                        }
                    }
                    if (!movieAlreadyExists) {
                        ratedMovies.add(movies.get(i));
                    }

                }
            }

//            ArrayList<String> castMembers = new ArrayList<>();
//            for (int i = 1; i < splits.size(); i++) {
//                castMembers.add(splits.get(i));
//            }
//            Movie newMovie = new Movie(movieTitle, castMembers);
//            ratedMovies.add(newMovie);

        }
        return ratedMovies;
    }

//    A static method named readMovieRatings in the ratings.FileReader class that takes and ArrayList of Movies and a
//    String as parameters. The methods returns an ArrayList of Movies. Write tests for this method in the
//    tests.TestClasses3 class
//
//    The input ArrayList of Movies will contain Movie objects with their title and cast populated. These Movies should
//    not have any ratings added to them. When your program, runs, it is intended for this ArrayList to be provided by
//    your readMovies method
//    The input String is the name of a file to be read. Test this method with a CSV file where each line matches the
//    format from the movie_ratings.csv file that you can download above (ie. "title,reviewerId,rating")

//    The method will return an ArrayList of Movies containing all of the ratings read from the input file.
//    If a Movie from the input ArrayList does not have any ratings in the ratings file, it should not be included in
//    the output ArrayList.
//    If a Movie has been rated that is not included in the input ArrayList, the rating should be ignored
//    Movies will have unique titles. Any movies with identical titles have been removed from the source data. Do not
//    write tests where the input ArrayList contains multiple Movies with the same title
//    If the input file does not exist, the method will return an empty ArrayList
//    The Movies in the returned ArrayList may appear in any order. Your tests should accept any order of the returned
//    Movies
//    The ratings for each Movie must be in the order in which they appear in the file. When testing the Linked List of
//    Ratings for a Movie, you can assume that they in the same order in which they appear in the file (This will make it simpler to test the Linked List)



}