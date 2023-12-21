package ratings;

import ratings.datastructures.Queue;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreesOfSeparation {

    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private Graph<String> graph = new Graph<>();
    private HashMap<String, Integer> distanceHashMap = new HashMap<>();
    private Queue<String> queue = new Queue<>();
    private ArrayList<String> visitedNodes = new ArrayList<String>();

    public DegreesOfSeparation(ArrayList<Movie> movies) {
        this.movies = movies;
    }
//    DegreesOfSeparation has a constructor that takes an ArrayList of Movies

    public int degreesOfSeparation(String castMemberA, String castMemberB) {
        clearInstanceVariables();
        populate();
        queue.enqueue(castMemberA);
        visitedNodes.add(castMemberA);
        if (!distanceHashMap.containsKey(castMemberA)) {
            return -1;
        } else {
            distanceHashMap.put(castMemberA, 0);
        }
        return checkDegree(castMemberB);



//        dequeue, go to all neighbors, check if you explored them, if you haven't then mark it as explored and enqueue
//        it then mark it as the distance +1.

//        return 0;
    }

    private int checkDegree(String castMemberB) {
        if (queue.getFront() == null) {
            return -1;
        }

        String currentCastMember = queue.dequeue();
        if (currentCastMember.equals(castMemberB)) {
            return distanceHashMap.get(currentCastMember);
        }
        ArrayList<String> currentCastMemberAdjacencyList = new ArrayList<>(graph.getAdjacencyList().get(currentCastMember));
        int distanceOfAdjacentNodes = distanceHashMap.get(currentCastMember) + 1;
        for (int i = 0; i < currentCastMemberAdjacencyList.size(); i++) {
            String newCastMember = currentCastMemberAdjacencyList.get(i);
            if (!visitedNodes.contains(newCastMember)) {
                visitedNodes.add(newCastMember);
                queue.enqueue(newCastMember);
                distanceHashMap.put(newCastMember, distanceOfAdjacentNodes);

            }

        }

        return checkDegree(castMemberB);
    }

    private void clearInstanceVariables () {
        visitedNodes.clear();
        queue.clearQueue();
        distanceHashMap.clear();
    }

    private void populate () {
        if (graph.getAdjacencyList().isEmpty()) {
            populateGraph();
        }
        if (distanceHashMap.isEmpty()) {
            populateDistanceHashMap();
        }
    }

    private void populateGraph () {
        for (int i = 0; i < this.movies.size(); i++) {
            ArrayList<String> castList = this.movies.get(i).getCast();
            if (castList.size() > 1) {
                for (int j = 0; j < castList.size() - 1; j++) {
                    for (int k = j + 1; k < castList.size(); k++) {
                        graph.addBidirectionalEdge(castList.get(j), castList.get(k));
//                        System.out.println(castList.get(j) + " " + castList.get(j + 1));
                    }
                }
            }
        }
    }

    private void populateDistanceHashMap () {
        for (int i = 0; i < this.movies.size(); i++) {
            ArrayList<String> castList = this.movies.get(i).getCast();
                for (int j = 0; j < castList.size(); j++) {
                    if (!this.distanceHashMap.containsKey(castList.get(j))){
                        this.distanceHashMap.put(castList.get(j), -1);
                    }
                }

        }
    }

//    The DegreesOfSeparation class has a method named degreesOfSeparation that takes 2 Strings and returns an int.
//    The inputs are the names of 2 cast members, and the method returns their degrees of separation. This number is how
//    many people need to be traversed to move from one person to the other where two people are connected if they
//    starred in a movie together. When computing the degrees of separation, only the Movies provided to the constructor
//    will be used. If the two cast members are not connected, or if one of them is not in any of the provided movies,
//    this method returns -1

//    Note: The degrees of separation of a person to themselves is 0. If two people have acted in a movie together,
//    their separation is 1. If two people were never in a movie together, their separation is the number of movies that
//    separate them. For example, in the data provided in movies.csv, Chris Pratt and Kevin Bacon have 2 degrees of
//    separation because Chris Pratt was in Moneyball with Brad Pitt and Brad Pitt was in Sleepers with Kevin Bacon
//    (Now, Chris Pratt was in The Guardians of the Galaxy Holiday Special with Kevin Bacon so their separation is 1,
//    but that movie is not in the movies.csv dataset)

//    Note: The movies.csv file provided in task 7 does not contain every single movie. Some of the degrees of
//    separation, and Bacon Numbers, might be slightly off


}
