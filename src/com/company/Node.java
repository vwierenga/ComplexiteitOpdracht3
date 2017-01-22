package com.company;

import java.util.ArrayList;

/**
 * Created by Vincent on 12/20/2016.
 */
public class Node {
    private int number; //0 == finish
    private String colour;
    private ArrayList<Route> routes = new ArrayList<>();

    /**
     * Node constructor
     * @param number The number of the node
     * @param colour The colour of the node
     */
    public Node(int number, String colour) {
        this.number = number;
        this.colour = colour;
    }

    /**
     * Node constructor 
     * @param number The number of the node
     * @param colour The colour of the node
     * @param routes The routes from this node
     */
    public Node(int number, String colour, ArrayList<Route> routes) {
        this.number = number;
        this.colour = colour;
        this.routes = routes;
    }

    /**
     * Get the number of this node
     * @return The number of this node
     */
    public int getNumber() {
        return number;
    }

    /**
     * Get the colour of this node
     * @return The colour of this node
     */
    public String getColour() {
        return colour;
    }

    /**
     * Get all routes from this node
     * @return All routes from this node
     */
    public ArrayList<Route> getRoutes() {
        return new ArrayList<>(routes);
    }

    /**
     * Get all routes from this node with a certain color
     * @param colour The colour of the routes
     * @return All routes from this node with a certain color
     */
    public ArrayList<Route> getRoutes(String colour) {
        ArrayList<Route> routesWithThisColour = new ArrayList<>();
        for (Route route : routes){
            if(route.getColour().equalsIgnoreCase(colour)){
                routesWithThisColour.add(route);
            }
        }
        return routesWithThisColour;
    }

    /**
     * Add a route to this node
     * @param route A route that starts at this node
     */
    public void addRoute(Route route) {
        if(route != null) {
            this.routes.add(route);
        }
    }
}
