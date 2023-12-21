package tests;

import org.junit.Test;
import ratings.Playlist;
import ratings.Song;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;

public class TestDataStructures2 {


//    ratings.Playlist - Create a Playlist class and test the following functionality
//
//    A constructor that takes as a parameter a reference to an object of type Comparator<Song>.
//            In your testing, you can pass either a new SongTitleComparator or a new SongBayesianRatingComparator:

    @Test
    public void playlistTest1 () {
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        SongTitleComparator titleComparator = new SongTitleComparator();
        Playlist playlistByTitle = new Playlist(titleComparator);
        assertNull(playlistByTitle.getSongTree());
        playlistByTitle.addSong(song1);
        assertEquals("Can't Stop", playlistByTitle.getSongTree().getValue().getTitle());

    }
    @Test
    public void playlistTest2 () {
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        Song song2 = new Song("Only", "Nine Inch Nails", "9999");
        Song song3 = new Song("Money", "Pink Floyd", "1234");
        Song song4 = new Song("Beef Rap", "MF DOOM", "1");
        SongTitleComparator titleComparator = new SongTitleComparator();
        Playlist playlistByTitle = new Playlist(titleComparator);
        playlistByTitle.addSong(song1);
        playlistByTitle.addSong(song2);
        playlistByTitle.addSong(song3);
        playlistByTitle.addSong(song4);
        assertEquals("Can't Stop", playlistByTitle.getSongTree().getValue().getTitle());
        assertEquals("Beef Rap", playlistByTitle.getSongTree().getLeft().getValue().getTitle());
        assertEquals("Only", playlistByTitle.getSongTree().getRight().getValue().getTitle());
        assertEquals("Money", playlistByTitle.getSongTree().getRight().getLeft().getValue().getTitle());

    }
    @Test
    public void playlistTest3 () {
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        Song song2 = new Song("Only", "Nine Inch Nails", "9999");
        Song song3 = new Song("Money", "Pink Floyd", "1234");
        Song song4 = new Song("Beef Rap", "MF DOOM", "1");
        SongTitleComparator titleComparator = new SongTitleComparator();
        Playlist playlistByTitle = new Playlist(titleComparator);
        playlistByTitle.addSong(song1);
        playlistByTitle.addSong(song2);
        playlistByTitle.addSong(song3);
        playlistByTitle.addSong(song4);
        assertNotNull(playlistByTitle.getSongList());
        assertNotNull(playlistByTitle.getSongList().getNext());
        assertNotNull(playlistByTitle.getSongList().getNext().getNext());
        assertNotNull(playlistByTitle.getSongList().getNext().getNext().getNext());
        assertEquals("Beef Rap", playlistByTitle.getSongList().getValue().getTitle());
        assertEquals("Can't Stop", playlistByTitle.getSongList().getNext().getValue().getTitle());
        assertEquals("Money", playlistByTitle.getSongList().getNext().getNext().getValue().getTitle());
        assertEquals("Only", playlistByTitle.getSongList().getNext().getNext().getNext().getValue().getTitle());
    }
    @Test
    public void playlistTest4 () {
        Song song1 = new Song("Can't Stop", "Red Hot Chili Peppers", "2002");
        Song song2 = new Song("Only", "Nine Inch Nails", "9999");
        Song song3 = new Song("Money", "Pink Floyd", "1234");
        Song song4 = new Song("Beef Rap", "MF DOOM", "1");
        SongTitleComparator titleComparator = new SongTitleComparator();
        Playlist playlistByTitle = new Playlist(titleComparator);
        playlistByTitle.addSong(song1);
        playlistByTitle.addSong(song2);
        playlistByTitle.addSong(song3);
        playlistByTitle.addSong(song4);
        assertNotNull(playlistByTitle.getSongList());
        assertNotNull(playlistByTitle.getSongList().getNext());
        assertNotNull(playlistByTitle.getSongList().getNext().getNext());
        assertNotNull(playlistByTitle.getSongList().getNext().getNext().getNext());
//        LinkedListNode getSongListLinkedList = new LinkedListNode<>(playlistByTitle.getSongList());
//        playlistByTitle.getSongList();
        assertEquals("Beef Rap", playlistByTitle.getSongList().getValue().getTitle());
        assertEquals("Can't Stop", playlistByTitle.getSongList().getNext().getValue().getTitle());
        assertEquals("Money", playlistByTitle.getSongList().getNext().getNext().getValue().getTitle());
        assertEquals("Only", playlistByTitle.getSongList().getNext().getNext().getNext().getValue().getTitle());
        assertNull(playlistByTitle.getSongList().getNext().getNext().getNext().getNext());
//        assertEquals("Money", playlistByTitle.getSongList().getNext().getNext().getNext().getNext().getNext().getValue().getTitle());
    }

//    A method named addSong that takes a reference to a Song as a parameter and returns void

//    A method named getSongList that takes no parameters and returns a LinkedListNode of Songs
//
//    The returned node will be the head of a linked list containing all the Songs that were added in sorted order according to the comparator provided to the constructor
//
//    If you provided a SongTitleComparator, the Songs will be sorted alphabetically
//
//    If you provided a SongBayesianRatingComparator, the Songs will be sorted in decreasing order
//    (The highest rated songs first) according to their bayesian average rating with 2 fake ratings of 3 being added.

//    For either comparator, you do not need to write any tests where two songs will be tied in the ordering
//    (eg. you don't have to write a test where 2 songs have the same bayesian average ratings)
//
//    The returned Songs might be different song objects, but they will contain the same title, artist,
//            and ratings as the Songs that were added (eg. You must check the values of the Songs and not rely
//            on comparing the references with ==)

//    If no songs have been added to the Playlist, this method returns null

}
