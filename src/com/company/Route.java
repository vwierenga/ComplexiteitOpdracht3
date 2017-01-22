package com.company;

/**
 * Created by Vincent on 12/20/2016.
 */
public class Route {
    private String colour;
    private Node destination;

    public Route(String colour, Node destination) {
        this.colour = colour;
        this.destination = destination;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }
}
