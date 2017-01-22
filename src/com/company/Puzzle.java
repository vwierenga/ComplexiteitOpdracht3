package com.company;

import java.util.*;

/**
 * Created by Vincent on 1/22/2017.
 */
public class Puzzle {
    private ArrayList<Node> nodes = new ArrayList<>();

    /**
     * Puzzle constructor
     */
    public Puzzle() {
        createMaze();
    }

    /**
     * Adds nodes to the nodes arraylist and creates routes between them
     */
    private void createMaze(){
        //Create nodes
        nodes.add(0, new Node(0, "blue"));
        nodes.add(1, new Node(1, "pink"));
        nodes.add(2, new Node(2, "black"));
        nodes.add(3, new Node(3, "green"));
        nodes.add(4, new Node(4, "green"));
        nodes.add(5, new Node(5, "green"));
        nodes.add(6, new Node(6, "orange"));
        nodes.add(7, new Node(7, "orange"));
        nodes.add(8, new Node(8, "pink"));
        nodes.add(9, new Node(9, "pink"));
        nodes.add(10, new Node(10, "black"));
        nodes.add(11, new Node(11, "orange"));
        nodes.add(12, new Node(12, "pink"));
        nodes.add(13, new Node(13, "orange"));
        nodes.add(14, new Node(14, "green"));
        nodes.add(15, new Node(15, "orange"));
        nodes.add(16, new Node(16, "green"));
        nodes.add(17, new Node(17, "green"));
        nodes.add(18, new Node(18, "black"));
        nodes.add(19, new Node(19, "orange"));
        nodes.add(20, new Node(20, "green"));
        nodes.add(21, new Node(21, "black"));
        nodes.add(22, new Node(22, "black"));


        //Add routes to the nodes
        nodes.get(1).addRoute(new Route("pink", nodes.get(4)));
        nodes.get(1).addRoute(new Route("black", nodes.get(5)));
        nodes.get(2).addRoute(new Route("green", nodes.get(6)));
        nodes.get(2).addRoute(new Route("pink", nodes.get(12)));
        nodes.get(3).addRoute(new Route("orange", nodes.get(1)));
        nodes.get(3).addRoute(new Route("orange", nodes.get(4)));
        nodes.get(4).addRoute(new Route("black", nodes.get(13)));
        nodes.get(5).addRoute(new Route("orange", nodes.get(9)));
        nodes.get(6).addRoute(new Route("green", nodes.get(9)));
        nodes.get(6).addRoute(new Route("pink", nodes.get(10)));
        nodes.get(7).addRoute(new Route("green", nodes.get(2)));
        nodes.get(8).addRoute(new Route("pink", nodes.get(3)));
        nodes.get(9).addRoute(new Route("green", nodes.get(4)));
        nodes.get(9).addRoute(new Route("black", nodes.get(14)));
        nodes.get(10).addRoute(new Route("green", nodes.get(15)));
        nodes.get(11).addRoute(new Route("pink", nodes.get(10)));
        nodes.get(11).addRoute(new Route("green", nodes.get(12)));
        nodes.get(12).addRoute(new Route("green", nodes.get(7)));
        nodes.get(13).addRoute(new Route("green", nodes.get(8)));
        nodes.get(13).addRoute(new Route("green", nodes.get(18)));
        nodes.get(14).addRoute(new Route("orange", nodes.get(20)));
        nodes.get(14).addRoute(new Route("green", nodes.get(0)));
        nodes.get(15).addRoute(new Route("pink", nodes.get(0)));
        nodes.get(15).addRoute(new Route("green", nodes.get(22)));
        nodes.get(16).addRoute(new Route("green", nodes.get(15)));
        nodes.get(17).addRoute(new Route("black", nodes.get(16)));
        nodes.get(17).addRoute(new Route("black", nodes.get(11)));
        nodes.get(17).addRoute(new Route("pink", nodes.get(12)));
        nodes.get(18).addRoute(new Route("orange", nodes.get(9)));
        nodes.get(18).addRoute(new Route("orange", nodes.get(20)));
        nodes.get(19).addRoute(new Route("green", nodes.get(18)));
        nodes.get(20).addRoute(new Route("black", nodes.get(19)));
        nodes.get(20).addRoute(new Route("orange", nodes.get(21)));
        nodes.get(21).addRoute(new Route("black", nodes.get(0)));
        nodes.get(21).addRoute(new Route("orange", nodes.get(22)));
        nodes.get(22).addRoute(new Route("orange", nodes.get(17)));
    }

    /**
     * Solver the maze
     * @return The solution to this maze
     */
    public LinkedList<State> solveMaze(){
        LinkedList<State> solution = dfs(new State(nodes.get(1), nodes.get(2)), new HashSet<>());
        for(State state : solution){
            System.out.println("PawnOne: " + state.getPawnOneLocation().getNumber() + " PawnTwo: " + state.getPawnTwoLocation().getNumber());
        }
        return solution;
    }

    /**
     * Search the maze for a solution
     * @param start The state to start the search from
     * @param visited A list with visited states
     * @return A list with the visited states from start till solution
     */
    private LinkedList<State> dfs(State start, Set<State> visited) {
        LinkedList<State> solution;
        visited.add(start);
        if (isGoalState(start)) { /* Solution found */
            solution = new LinkedList<State>();
            solution.add(start);
            return solution;
        } else {
            List<State> neighbours = start.getNeighbours();
            for(State neighbour : neighbours){
                if (!listContains(visited, neighbour)) {
                    solution = dfs(neighbour, visited);
                    if (goalIsReached(solution)) {
                        solution.addFirst(start);
                        return solution;
                    }
                }
            }
        }

        return new LinkedList<State>(); /* no Solution */
    }

    /**
     * Check if a state is the goal state
     * @param state A state
     * @return True if it is the goal state, false otherwise
     */
    private boolean isGoalState(State state){
        return (state.getPawnOneLocation().getNumber() == 0 || state.getPawnTwoLocation().getNumber() == 0);
    }

    /**
     * Check if the goal state is in the linked list
     * @param solution A linked list with states
     * @return True if the goal state is in the linked list, false otherwise
     */
    private boolean goalIsReached(LinkedList<State> solution){
        for (State state : solution){
            if (isGoalState(state)){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the list contains a certain state
     * @param list The list we're looking in
     * @param state The state we're searching for
     * @return True if the list contains the state, false otherwise
     */
    private boolean listContains(Set<State> list, State state){
        for(State listState : list){
            if(listState.getPawnOneLocation() == state.getPawnOneLocation() && listState.getPawnTwoLocation() == state.getPawnTwoLocation()){
                return true;
            }
        }
        return false;
    }

}
