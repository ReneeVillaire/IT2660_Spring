package com.company;

import static java.lang.Math.*;

public class GraphGenerator {
    private Graph graph;
    private int verticeCount;

    //constants
    private final static int MinNodeValue = 1;
    private final static int MaxNodeValue = 300000;

    private final static int MinEdgeConnection = 1;
    private final static int MaxEdgeConnection = 5;

    public GraphGenerator(int numberOfVertices) {
        verticeCount = numberOfVertices;
        graph = new Graph(numberOfVertices);
    }

    public void generate(boolean weighted) {
        for(var idx = 0; idx < verticeCount; idx++) {
            var nodeValue = getRandomInt(MinNodeValue, MaxNodeValue);
            graph.insertVertex(idx, nodeValue);
        }

        for(var idx = 0; idx < verticeCount; idx++) {
            var edgeCount = getRandomInt(MinEdgeConnection, MaxEdgeConnection);
            connectNodes(idx, edgeCount, weighted);
        }
    }

    public Graph getGraph() { return graph; }

    private int getRandomInt(int minRange, int maxRange) {
        int value = (int)(random()*((maxRange-minRange)))+minRange;
        return value;
    }

    private void connectNodes(int sourceNodeIdx, int edgeCount, boolean weighted) {
        int edgeWeight = 1; //default edgeWeight

        //tracking arrays - we do not want to repeat nodes nor use the sourceNode
        //going to an acyclic graph
        int[] usedNodes = new int[edgeCount + 1];

        for(var idx = 0; idx < edgeCount + 1; idx++)
            usedNodes[idx] = Integer.MIN_VALUE;

        usedNodes[0] = sourceNodeIdx;
        int[] weights = new int[edgeCount];

        for(var count = 0; count < edgeCount; count++) {
            var possibleTargetNode = getRandomInt(1, verticeCount);

            while(isNodeUsed(usedNodes, possibleTargetNode))
                possibleTargetNode = getRandomInt(1, verticeCount);

            usedNodes[count+1] = possibleTargetNode;

            if(weighted)
                edgeWeight = getRandomInt(1, MaxEdgeConnection * 2);

            weights[count] = edgeWeight;
        }

        //make the connections
        for(var idx = 0; idx < edgeCount; idx++) {
            var targetNode = usedNodes[idx+1];
            var edge = weights[idx];
            graph.insertEdge(sourceNodeIdx, targetNode, edge);
        }
    }

    private boolean isNodeUsed(int[] nodes, int targetNode) {
        boolean used = false;

        for(var idx = 0; idx < nodes.length; idx++) {
            if(nodes[idx] != Integer.MIN_VALUE) {
                if(nodes[idx] == targetNode) {
                    used = true;
                    break;
                }
            }
        }

        return used;
    }
}
