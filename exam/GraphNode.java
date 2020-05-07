package com.company;

import javax.swing.JOptionPane;

public class GraphNode {
    private int value;
    boolean pushed;
    public static int InitializedValue = Integer.MIN_VALUE;

    public GraphNode(int number) {
        value = number;
        pushed = false;
    }

    public GraphNode() {
        pushed = false;
        value = InitializedValue;
    }

    public String toString() {
        return ("Data is " + Integer.toString(value));
    }

    public GraphNode deepCopy() {
        GraphNode clone = new GraphNode(value);
        return clone;
    }

    public void setData(int number) { value = number; }
    public int getData() { return value; }
    public boolean visited() {
        return pushed;
    }
    public void setVisit(boolean value) {
        pushed = value;
    }
    public void printData() {
        System.out.println(value);
    }
}
