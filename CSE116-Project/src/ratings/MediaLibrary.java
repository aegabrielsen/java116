package ratings;

import java.util.ArrayList;
import java.util.List;

public class MediaLibrary {

    private ArrayList<Song> songs;
    private ArrayList<Movie> movies;
    public MediaLibrary() {
    }

    public void populateLibrary(String songsFilename, String moviesCastFilename, String moviesRatingsFilename) {
        this.songs = FileReader.readSongs(songsFilename);
        this.movies = FileReader.readMovieRatings(FileReader.readMovies(moviesCastFilename), moviesRatingsFilename);
    }

//    MediaLibrary has a constructor that takes no parameters
//    MediaLibrary has a method named populateLibrary that returns void and takes 3 Strings as parameters representing
//    filenames for songs with ratings, movies (title and cast), then movie ratings in this order. These three files
//    will match the three static methods you've written in your FileReader class. The expected behavior of this method
//    will match the expected behavior of those three methods. This method will read all the data from all three files
//    and store all of the Songs and Movies as part of the state of the MediaLibrary object

    public ArrayList<Ratable> topKRatables(int numberToReturn) {
        ArrayList<Ratable> tempRatables = new ArrayList<Ratable>();
        tempRatables.addAll(this.movies);
        tempRatables.addAll(this.songs);
//        if (this.movies.size() + this.songs.size() < numberToReturn) {
        if (tempRatables.size() < numberToReturn) {
            numberToReturn = this.movies.size() + this.songs.size();
        }
        ArrayList<Ratable> topK = new ArrayList<Ratable>();
//        ArrayList<Movie> tempMovies = new ArrayList<>(List.copyOf(this.movies));
//        ArrayList<Song> tempSongs = new ArrayList<>(List.copyOf(this.songs));


        for (int i = 0; i < numberToReturn; i++) {
            double top = 0;
            topK.add(new Ratable());
            for (int j = 0; j < tempRatables.size(); j++) {
                if (!topK.contains(tempRatables.get(j))) {
                    if (tempRatables.get(j).bayesianAverageRating(2, 3) > top) {
                        top = tempRatables.get(j).bayesianAverageRating(2, 3);
                        topK.set(i, tempRatables.get(j));

                    }
                }

            }
//            for (int j = 0; j < this.movies.size(); j++) {
//                if (!topK.contains(this.movies.get(j))) {
//                    if (this.movies.get(j).bayesianAverageRating(2, 3) > top) {
//                        top = this.movies.get(j).bayesianAverageRating(2, 3);
//                        topK.set(i, this.movies.get(j));
//
//                    }
//                }
//
//            }
//            for (int j = 0; j < this.songs.size(); j++) {
//                if (!topK.contains(this.songs.get(j))) {
//                    if (this.songs.get(j).bayesianAverageRating(2, 3) > top) {
//                        top = this.songs.get(j).bayesianAverageRating(2, 3);
//                        topK.set(i, this.songs.get(j));
//
//                    }
//                }
//
//            }
        }

        return topK;
    }

//    MediaLibrary has a method named topKRatables that takes an int and returns an ArrayList of Ratables. This method
//    will return the top k ratables that have been loaded using populateLibrary where k is the input int
//    (eg. topKRatables(10) returns a top 10 list). The ratables will be ranked by their bayesian average rating with
//    2 extra ratings of value 3 in decreasing order (eg. The Ratable with the highest bayesian average should be at
//    index 0). If k is greater than the number of Ratables, return all Ratables (eg. If k is 100 and there are only
//    3 Ratables in the library, return all 3).

//    Note: All these methods should be tested together. To test whether populateLibrary read the data properly, you
//    must call the topKRatables as there is no other way - that is defined in this document and can be used in testing
//    - to access the state of the MediaLibrary object
//    Note: Throughout your testing, you may assume that Songs and Movies have unique titles. When testing topKRatables,
//    if the returned ArrayList contains the correct titles in the correct order, your test should pass (ie. you don't
//    have to check any other instance variables like the ratings Linked List, song ids, artists, or cast members)

//            Note: You don't have to write tests where any 2 Songs or Movies have the same bayesian average rating.
//            This would be tedious to test since the order can depend on truncation errors and there would be multiple
//            correct orderings that would all be correct


}
