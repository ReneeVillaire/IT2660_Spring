package com.company;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.random;

public class Main {

    public static void main(String[] args) {
        int maxNodes = 100000;

        System.out.println();
        System.out.println("Generating the graph of 100,000 nodes.");
        GraphGenerator generator = new GraphGenerator(maxNodes);
        generator.generate(true);
        var graph = generator.getGraph();
        System.out.println("Graph generation complete!");

        var randomIndex = (int)(random()*((maxNodes)));
        var randomData = graph.getVertexData(randomIndex);

        System.out.println();
        System.out.println("Random Vertex (Node Index, Node Value): (" + randomIndex + ", " + randomData + ")");
        var scanner = new Scanner(System.in);
        System.out.println("Please enter a number to search for: ");
        var num = scanner.nextInt();

        System.out.println();
        System.out.println("Breadth Search");
        graph.breadthFirstTraversal(num);

        System.out.println();
        System.out.println("Depth Search");
        graph.depthFirstTraversal(num);

        System.out.println();
        System.out.println("Dijstrka's Algorithm Search");
        graph.dijkstra(num);
    }
}
