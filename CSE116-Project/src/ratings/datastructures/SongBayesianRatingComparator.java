package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song a, Song b) {
        return a.bayesianAverageRating(2, 3) > b.bayesianAverageRating(2, 3);
    }
}


//
//    This class will inherit from the Comparator class with the generic type being Song
//        Override the compare method to take two references to Song objects and returns a boolean

//        This method returns true if the first parameter has a higher bayesian average than the second in,
//        and false otherwise (Including for Songs with the same bayesian average)

//        Use 2 extra ratings with value 3 for the bayesian averages

