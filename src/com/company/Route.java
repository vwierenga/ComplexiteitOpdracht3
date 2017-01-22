package com.company;

/**
 * Created by Vincent on 12/20/2016.
 */
public class Route {
    private String colour;
    private Node destination;

    /**
     * Route constructor
     * @param colour The colour of this route
     * @param destination The destination of this route
     */
    public Route(String colour, Node destination) {
        this.colour = colour;
        this.destination = destination;
    }

    /**
     * Get the colour of this route
     * @return The colour of this route
     */
    public String getColour() {
        return colour;
    }

    /**
     * Get the destination of this route
     * @return The destination of this route
     */
    public Node getDestination() {
        return destination;
    }
}
