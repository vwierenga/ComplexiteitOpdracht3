package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Create nodes
        ArrayList<Node> nodes = new ArrayList<>();
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


        //Add routes
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

        LinkedList<State> solution = dfs(new State(nodes.get(1), nodes.get(2)), new HashSet<>());
        for(State state : solution){
            System.out.println("PawnOne: " + state.getPawnOneLocation().getNumber() + " PawnTwo: " + state.getPawnTwoLocation().getNumber());
        }

    }

    static LinkedList<State> dfs(State start, Set<State> bezocht) {
        //System.out.println("PawnOne: " + start.getPawnOneLocation().getNumber() + " PawnTwo: " + start.getPawnTwoLocation().getNumber());
        LinkedList<State> oplossing;
        bezocht.add(start);
        if (isGoalState(start)) { /* Gevonden */
            oplossing = new LinkedList<State>();
            oplossing.add(start);
            return oplossing;
        } else {
            List<State> buren = start.getNeighbours();
            for(State buur : buren){
                if (!listContains(bezocht, buur)) {
                    oplossing = dfs(buur, bezocht);
                    if (goalIsReached(oplossing)) {
                        oplossing.addFirst(start);
                        return oplossing;
                    }
                }
            }
        }

        /* bezocht.remove(start); */
        //System.out.println("No solution :(");
        return new LinkedList<State>(); /* geen oplossing */
    }

    static boolean isGoalState(State state){
        return (state.getPawnOneLocation().getNumber() == 0 || state.getPawnTwoLocation().getNumber() == 0);
    }

    static boolean goalIsReached(LinkedList<State> solution){
        for (State state : solution){
            if (isGoalState(state)){
                return true;
            }
        }
        return false;
    }

    static boolean listContains(Set<State> list, State state){
        for(State listState : list){
            if(listState.getPawnOneLocation() == state.getPawnOneLocation() && listState.getPawnTwoLocation() == state.getPawnTwoLocation()){
                return true;
            }
        }
        return false;
    }




}
