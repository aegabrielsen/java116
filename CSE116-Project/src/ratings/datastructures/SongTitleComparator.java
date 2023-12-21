package ratings.datastructures;

import ratings.Song;

public class SongTitleComparator extends Comparator<Song> {
    @Override
    public boolean compare(Song a, Song b) {
        String firstTitle = a.getTitle();
        String secondTitle = b.getTitle();
        return firstTitle.compareToIgnoreCase(secondTitle) < 0;
    }
}
