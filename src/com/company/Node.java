package com.company;

import java.util.ArrayList;

/**
 * Created by Vincent on 12/20/2016.
 */
public class Node {
    private int number; //23 == finish
    private String colour;
    private ArrayList<Route> routes = new ArrayList<>();

    public Node(int number, String colour) {
        this.number = number;
        this.colour = colour;
    }

    public Node(int number, String colour, ArrayList<Route> routes) {
        this.number = number;
        this.colour = colour;
        this.routes = routes;
    }

    public int getNumber() {
        return number;
    }

    public String getColour() {
        return colour;
    }

    public ArrayList<Route> getRoutes() {
        return new ArrayList<>(routes);
    }

    public ArrayList<Route> getRoutes(String colour) {
        ArrayList<Route> routesWithThisColour = new ArrayList<>();
        for (Route route : routes){
            if(route.getColour().equalsIgnoreCase(colour)){
                routesWithThisColour.add(route);
            }
        }
        return routesWithThisColour;
    }

    public void addRoute(Route route) {
        if(route != null) {
            this.routes.add(route);
        }
    }
}
