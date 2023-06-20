//-----------------------------------------------------
// Title: Main class for the first question
// Authors: Burak Koç - Furkan Safa Altunyuva
// Section: 4
// Assignment: 3
// Description: This class simulates parking lots in edge weighted directed graph structure and calculates the payment for number of cars
//-----------------------------------------------------
package Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt(); //Stores the node count in the input
        int edgeCount = scanner.nextInt(); //Stores the edge count in the input
        int baseFee = scanner.nextInt(); //Stores the base fee in the input

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(nodeCount+1); //It creates nodeCount+1 vertices because desired output starts counting from 1. (The 0th vertex will have no functionality)

        scanner.nextLine(); //Skips to the next line in the input

        ArrayList<Integer> capacities = new ArrayList<>(); //An ArrayList that stores the capacities of each parking lot
        capacities.add(0); //It makes the capacity of the 0th parking lot to 0 because it must not have any capacity. (There is a 0 in the graph but has no functionality.)

        for (int i = 0; i < nodeCount; i++) { //Reads the input and adds the values into capacities ArrayList (Every parking lot has it capacity in its index)
            capacities.add(scanner.nextInt());
        }

        scanner.nextLine(); //Skips to the next line in the input

        for (int i = 0; i < edgeCount; i++) { //Adds edges in the input with their weights as their distances
            graph.addEdge(new DirectedEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
            scanner.nextLine();
        }

        int numOfCars = scanner.nextInt(); //Stores the number of cars in the input

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph, 1); //Starting Dijkstra's algorithm from the first node (parking lot)

        ArrayList<DirectedEdge> edgesOfDijkstra = new ArrayList<>(); //An ArrayList to store the edges from the Dijkstra's algorithm (I preferred to use Arraylist instead of array to access easily)

        for(int i = 0; i < dijkstra.edgeTo.length; i++){
            if(dijkstra.edgeTo[i] != null){ //There may exist null values but do not add them because they may cause problems when iterating over the list
                edgesOfDijkstra.add(dijkstra.edgeTo[i]);;
            }
        }

        ArrayList<Integer> result = new ArrayList<>(); //Creating an ArrayList to store the result values

        for(int i = 0; i < capacities.get(1); i++){ //The first parking lot will not add any edge weight because it starts from there (The results for the first parking lot is just baseFee value)
            result.add(baseFee);
            numOfCars--; //Decrease the count of cars because they are parked
        }

        boolean isCarCountExceedsCapacity = false; //A boolean to check that if the car count exceeds the whole capacity of the parking lot

        int currentCarCount = numOfCars; //Creating another value to store the current car count to prevent the confusion when subtracting (numOfCars is used in for-loop)

        int currIndex = 0; //Creating an integer value to store the current index to access the edgesOfDijkstra list's indices

        for(int j = 0; j < numOfCars; j++){

            if(currentCarCount==0) break; //If there are no car left, break the loop

            try { //If the number of cars exceeds the capacity, the below statement throws IndexOutOfBounds exception. (capacities.get(edgesOfDijkstra.get(currIndex).to())
                for (int i = 0; i < capacities.get(edgesOfDijkstra.get(currIndex).to()); i++) { //Iterate ((The "to" value of the "currIndex"th edgesOfDijkstra value)th index of capacities list) times
                    int sum = 0; //Creating a sum value because the intended parking may require several edges to be accessed

                    for (DirectedEdge edge : dijkstra.pathTo(edgesOfDijkstra.get(currIndex).to())) { //Finding the path from first parking lot to current parking lot and adding the edges' weights into sum
                        sum += edge.weight();
                    }

                    result.add(baseFee + sum); //Summing the baseFee and the sum value then adding the result to the "result" list
                    currentCarCount--; //Decreasing the current car count by one because loop is over
                }
            }
            catch (IndexOutOfBoundsException e){
                isCarCountExceedsCapacity = true; //If this boolean is true, it adds that much -1 to the end of the result list
            }
            currIndex++; //Increase the currIndex to get next edgesOfDijkstra item
        }

        Collections.sort(result); //First sort them because Dijkstra's algorithm may not give the intended order

        if(isCarCountExceedsCapacity){ //If there is a situation that car count is greater than the whole capacity, add -1 to the result list for each car that could not park
            for(int i = 0; i < currentCarCount; i++){
                result.add(-1);
            }
        }

        System.out.println(result); //Print the final result

    }

}
