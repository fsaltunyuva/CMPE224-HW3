package Q2;//-----------------------------------------------------
// Title: Main class for the secomd question
// Authors: Burak Koç - Furkan Safa Altunyuva
// Section: 4
// Assignment: 3
// Description: This class simulates busses, their routes, stations according
// to time with edge weighted graphs in most efficient way.
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // Number of stations
        int M = scanner.nextInt(); // Number of buses

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(N + 1);
        ArrayList<CircularLL> values = new ArrayList<CircularLL>();
        ArrayList<ArrayList<DirectedEdge>> edgesReal = new ArrayList<>();


        //take values for each bus
        for (int i = 0; i < M; i++) {

            //for each value create a new circular linked list
            values.add(new CircularLL());

            int firstStation; //starter station
            int t = scanner.nextInt(); // Number of stations visited by the bus
            int prevStation = scanner.nextInt(); // take first station
            firstStation = prevStation;
            int currentStation;

            for (int j = 1; j < t; j++) {
                currentStation = scanner.nextInt(); // take other stations
                values.get(i).add(prevStation);
                edgesReal.add(new ArrayList<DirectedEdge>());
                graph.addEdge(new DirectedEdge(prevStation, currentStation, 1)); // Add stations as an edge with weight 1
                prevStation = currentStation;

            }
            values.get(i).add(prevStation);
            edgesReal.add(new ArrayList<DirectedEdge>());
            graph.addEdge(new DirectedEdge(prevStation, firstStation, 1)); // Add the edge that connects last station to first station
        }



        // Find sgortest paths using Dijkstra
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph, 1);

        //ArrayList for storing edges on graph
        ArrayList<Iterable<DirectedEdge>> edges = new ArrayList<>();

        // ArrayList for storing stations which has no paths
        ArrayList<Integer> noPathStations = new ArrayList<>();

        //from 2. station to last station
        for (int i = 2; i <= N; i++) {

            //check every station if there is a path
            if (dijkstra.hasPathTo(i)) {
                //add edge to edges array
                edges.add(dijkstra.pathTo(i));
            } else {
                //add station to noPathStations array
                noPathStations.add(i);
            }
        }

        //create array for stations for time by time
        CircularLL.Node[] currStations = new CircularLL.Node[M];

        for (int i = 0; i < currStations.length; i++) {
            currStations[i] = values.get(i).head;
        }
        int a = 0;
        for (Iterable<DirectedEdge> de :
                edges) {
            de.forEach(edgesReal.get(a)::add);
            a++;
        }

        int targetStation = 2;

        //Value for preventing error caused by pathless stations
        int minusValue =2;

        //for each station simulate the path with time
        while (targetStation <= 8) {

            //If there is no path print -1
            if (noPathStations.contains(targetStation)){
                System.out.print("-1 ");
                targetStation++;
                minusValue++;
                continue;
            }
            //start timer as 0
            int timer = 0;

            // every bus starts on their first station
            for (int i = 0; i < currStations.length; i++) {
                currStations[i] = values.get(i).head;
            }

            int length = edgesReal.get(targetStation - minusValue).size();


            for (int i = length - 1; i >= 0; i--) {

                //setting the target station values
                int from = edgesReal.get(targetStation - minusValue).get(i).from();
                int to = edgesReal.get(targetStation - minusValue).get(i).to();


                boolean isFound = false;

                //loop for finding the right bus
                while (!isFound) {

                    for (int j = 0; j < currStations.length; j++) {

                        if (currStations[j].data == from && currStations[j].next.data == to) {

                            isFound = true;
                            break;
                        }
                    }
                    //if there is no bus at current time
                    //increase the time and
                    timer++;
                    for (int k = 0; k < currStations.length; k++) {
                        //move each bus 1 station forward
                        currStations[k] = currStations[k].next;
                    }

                }
            }

            if (timer != 0) {
                System.out.print(timer + " ");
            } else {
                System.out.print("-1 ");
            }


            targetStation++;

        }
    }
}
