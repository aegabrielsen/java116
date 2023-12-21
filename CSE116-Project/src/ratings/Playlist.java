package ratings;

import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

public class Playlist {

//    Create a Playlist class in the ratings package with the following functionality. This class will use a Binary
//    Search Tree (BST) to store a playlist of Songs in sorted order.
//
//    A constructor that takes a Comparator of Songs
//    You will use this Comparator in BST to sort the Songs of the Playlist. You should create any instance variables
//    you'll need when this constructor is called


    private BinaryTreeNode<Song> root;
    private Comparator<Song> comparator;

    private LinkedListNode<Song> sortedList;

    public Playlist(Comparator<Song> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.sortedList = null;
    }

    //    A method named getSongTree that takes no parameters and returns the ratings.datastructures.BinaryTreeNode of Songs
//    that is the root node of your BST
    public BinaryTreeNode<Song> getSongTree() {
        return this.root;
    }

    //    A method named addSong that takes a reference to a Song and returns void
//    This method will add the Song to the Playlist by inserting it into a BST with the comparator from the constructor
//    Note that you are allowed to use the BST code provided in lecture

    public void addSong(Song value) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(value, null, null);
        } else {
            this.insertHelper(this.root, value);
        }
    }

    private void insertHelper(BinaryTreeNode<Song> node, Song toInsert) {
        if (this.comparator.compare(toInsert, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            // ties go right
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }

    public boolean find(Song value) {
        if (this.root == null) {
            return false;
        } else {
            return findHelper(this.root, value);
        }
    }

    private boolean findHelper(BinaryTreeNode<Song> node, Song toFind) {
        if (this.comparator.compare(toFind, node.getValue())) {
            if (node.getLeft() == null) {
                return false;
            } else {
                return findHelper(node.getLeft(), toFind);
            }
        } else if (this.comparator.compare(node.getValue(), toFind)) {
            if (node.getRight() == null) {
                return false;
            } else {
                return findHelper(node.getRight(), toFind);
            }
        } else {
            return true;
        }
    }



//    private LinkedListNode<Song> songList = null;
//
//    public Playlist(Comparator<Song> compareInPlaylist) {
//    }

/*
    public static double treeSum(BinaryTreeNode<Thingamabob> tree) {
        if (tree == null) {
            return 0.0;
        } else {
            double leftResult = treeSum(tree.getLeft());
            double rightResult = treeSum(tree.getRight());
            double nodeValue = tree.getValue().getTheNumber();
            return leftResult + rightResult + nodeValue;

        }
    }
    */

//

//

//
//    A method named getSongList that takes a BinaryTreeNode of Songs as a parameter and returns a
//    ratings.datastructures.LinkedListNode of Songs
//    This method traverses the tree from the parameter and returns all the Songs in the tree in a Linked List in sorted
//    order (Assuming the parameter is the root of a BST)
//    Note: This method is expected to contain the majority of the difficulty of this task
//    You should write the next method before this one
    public LinkedListNode<Song> getSongList (BinaryTreeNode<Song> node) {
        if (node != null) {
//            String out = "";
            getSongList(node.getLeft());
            if (this.sortedList == null) {
                this.sortedList = new LinkedListNode<>(node.getValue(), null);
            } else {
                this.sortedList.append(node.getValue());
            }
            getSongList(node.getRight());
//            return out;
            return this.sortedList;
        } else {
            return null;
        }
    }

//
//    A method named getSongList that takes no parameters and returns a ratings.datastructures.LinkedListNode of Songs
//    This method traverses your BST and returns all the Songs in the tree in a Linked List in sorted order
//    This method should be one line since you can call your other getSongList method with the root of your BST as
//    the argument
//    This is the method that you tested earlier in this task. You should write this method while writing the other
//    getSongList method so you can run your tests and utilize the debugger while writing your code

    public LinkedListNode<Song> getSongList () {
        if (this.sortedList != null) {
            this.sortedList = null;
        }
        return getSongList(this.root);
    }

}
