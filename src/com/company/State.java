package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 12/20/2016.
 */
public class State {
    private Node pawnOneLocation;
    private Node pawnTwoLocation;

    public State(Node pawnOneLocation, Node pawnTwoLocation) {
        this.pawnOneLocation = pawnOneLocation;
        this.pawnTwoLocation = pawnTwoLocation;
    }

    public void setPawnOneLocation(Node pawnOneLocation) {
        this.pawnOneLocation = pawnOneLocation;
    }

    public void setPawnTwoLocation(Node pawnTwoLocation) {
        this.pawnTwoLocation = pawnTwoLocation;
    }

    public Node getPawnOneLocation() {
        return pawnOneLocation;
    }

    public Node getPawnTwoLocation() {
        return pawnTwoLocation;
    }

    public ArrayList<State> getNeighbours(){
        System.out.println("Neighbours for: " + pawnOneLocation.getNumber() + " " + pawnTwoLocation.getNumber());
        ArrayList<State> neighbours = new ArrayList<>();
        ArrayList<Route> routes = pawnOneLocation.getRoutes(pawnTwoLocation.getColour());
        if(routes != null){
            System.out.println("Pawn One:");
            for (Route route : routes){
                System.out.println("PawnOne: " + route.getDestination().getNumber() + " PawnTwo: " + pawnTwoLocation.getNumber());
                neighbours.add(new State(route.getDestination(), pawnTwoLocation));
            }
        }
        routes = pawnTwoLocation.getRoutes(pawnOneLocation.getColour());
        if(routes != null){
            System.out.println("Pawn Two:");
            for (Route route : routes){
                System.out.println("PawnOne: " + pawnOneLocation.getNumber() + " PawnTwo: " + route.getDestination().getNumber());
                neighbours.add(new State(pawnOneLocation, route.getDestination()));
            }
        }
        System.out.println(" ");
        return neighbours;
    }
}
