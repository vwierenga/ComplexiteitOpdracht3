package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 12/20/2016.
 */
public class State {
    private Node pawnOneLocation;
    private Node pawnTwoLocation;

    /**
     * State constructor
     * @param pawnOneLocation The location of the first pawn
     * @param pawnTwoLocation The location of the second pawn
     */
    public State(Node pawnOneLocation, Node pawnTwoLocation) {
        this.pawnOneLocation = pawnOneLocation;
        this.pawnTwoLocation = pawnTwoLocation;
    }

    /**
     * Get the location of pawn one
     * @return The node pawn one is on
     */
    public Node getPawnOneLocation() {
        return pawnOneLocation;
    }

    /**
     * Get the location of pawn two
     * @return The node pawn two is on
     */
    public Node getPawnTwoLocation() {
        return pawnTwoLocation;
    }

    /**
     * Get all neighbours of this state
     * @return All possible states that can be accessed from this state
     */
    public ArrayList<State> getNeighbours(){
        ArrayList<State> neighbours = new ArrayList<>();
        ArrayList<Route> routes = pawnOneLocation.getRoutes(pawnTwoLocation.getColour());
        if(routes != null){
            for (Route route : routes){
                neighbours.add(new State(route.getDestination(), pawnTwoLocation));
            }
        }
        routes = pawnTwoLocation.getRoutes(pawnOneLocation.getColour());
        if(routes != null){
            for (Route route : routes){
                neighbours.add(new State(pawnOneLocation, route.getDestination()));
            }
        }
        return neighbours;
    }
}
