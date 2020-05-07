package com.company;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.Queue;

public class Graph {
    GraphNode vertex[];
    int edge[][];
    int max;
    int numberOfVertices;

    private static final int InitializedValue = Integer.MAX_VALUE;

    public Graph(int n) {
        vertex = new GraphNode[n];
        edge = new int[n][n];
        max = n;
        numberOfVertices = 0;
        initEdgeArray();
    }

    private void initEdgeArray() {
        for(var i = 0; i < max; i++) {
            for(var j=0; j < max; j++) {
                edge[i][j] = InitializedValue;
            }
        }
    }

    public boolean insertVertex(int vertexNumber, int data) {
        if(vertexNumber >= max)
            return false;

        vertex[vertexNumber] = new GraphNode(data);
        numberOfVertices++;
        return true;
    }

    public boolean insertEdge(int sourceVertex, int targetVertex, int edgeWeight) {
        if(vertex[sourceVertex].getData() == GraphNode.InitializedValue ||
                vertex[targetVertex].getData() == GraphNode.InitializedValue)
            return false;

        edge[sourceVertex][targetVertex] = edgeWeight;
        return true;
    }

    public void showVertex(int number) {
        System.out.println(vertex[number]);
    }
    public int getVertexData(int vertexNumber) { return vertex[vertexNumber].getData(); }

    public void showEdges(int vertexNumber) {
        for(var column = 0; column < numberOfVertices; column++) {
            if(edge[vertexNumber][column] > 0)
                System.out.println(vertexNumber + " ," + column);
        }
    }

    public void depthFirstTraversal(int searchValue) {
        int v;
        int nodeCount = 0;
        boolean found = false;
        Stack<Integer> stack = new Stack<Integer>();

        unvisitNodes();
        stack.push(0);
        vertex[0].setVisit(true);
        nodeCount++;

        //visit all the descendants
        while(!stack.empty()) {
            v = stack.pop();
            nodeCount++;

            if(vertex[v].getData() == searchValue) {
                found = true;
                break;
            }

            for(var column = 0; column < numberOfVertices; column++) {
                if(edge[v][column] > 0 && !vertex[column].visited()) {
                    stack.push(column);
                    vertex[column].setVisit(true);
                }
            }
        }

        //the path is unweighted (all set to one) so the path
        //is equal to the number of nodes visited.
        printReport(searchValue, nodeCount, nodeCount, found);
    }

    public void breadthFirstTraversal(int searchValue) {
        int v;
        int nodeCount = 0;
        boolean found = false;
        Queue<Integer> queue = new LinkedList<Integer>();

        unvisitNodes();
        queue.add(0);
        vertex[0].setVisit(true);
        nodeCount++;

        //visit all the descendants
        while(!queue.isEmpty()) {
            v = queue.remove();
            nodeCount++;

            if(vertex[v].getData() == searchValue) {
                found = true;
                break;
            }

            for(var column=0; column < numberOfVertices; column++) {
                if(edge[v][column] > 0 && !vertex[column].visited()) {
                    queue.add(column);
                    vertex[column].setVisit(true);
                }
            }
        }

        printReport(searchValue, nodeCount, nodeCount, found);
    }

    public void dijkstra(int searchValue) {
        boolean found = false;
        int nodeCount = 0;
        int distance = 0;
        unvisitNodes();

        //initial value for the 0th node in the graph
        vertex[0].setVisit(true);

        for(var idx = 0; idx < numberOfVertices; idx++) {
            var min = minDistance(idx);

            //if the min comes back as InitializedValue, there is NO CONNECTION
            if(min != InitializedValue) {
                distance += min;
                nodeCount++;

                if(vertex[idx].getData() == searchValue) {
                    found = true;
                    break;
                }
            }
        }

        printReport(searchValue, nodeCount, distance, found);
    }

    private int minDistance(int currentNodeIdx) {
        int minIdx = InitializedValue;
        int minDist = InitializedValue;

        for(var idx = 0; idx < numberOfVertices; idx++) {
            var edgeValue = edge[currentNodeIdx][idx];

            if(edgeValue != InitializedValue &&  !vertex[idx].visited()) {
                if(edgeValue < minDist) {
                    minDist = edgeValue;
                    minIdx = idx;
                }
            }
        }

        return minIdx;
    }

    private void unvisitNodes() {
        for(var idx = 0; idx < numberOfVertices; idx++) {
            if (vertex[idx].getData() != GraphNode.InitializedValue)
                vertex[idx].setVisit(false);
        }
    }

    private void printReport(int value, int nodeCount, int path, boolean found) {
        if(found) {
            System.out.println(value + " was found!");
            System.out.println("Path length: " + path);
            System.out.println("Nodes visited: " + nodeCount);
        }
        else {
            System.out.println(value + " was not found!");
        }
    }
}
