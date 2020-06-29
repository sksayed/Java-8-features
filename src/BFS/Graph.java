package BFS;

// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph {
    private String name;
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(intToStringMaping(s) + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    private String intToStringMaping(int number) {
        String asd ="";
        switch (number) {
            case 0:
                asd = "h";
            break;
            case 1:
                asd = "c";
            break;
            case 2:
                asd = "a";
            break;
            case 3:
                asd = "g";
            break;
            case 4:
                asd = "b";
            break;
            case 5:
                asd = "k";
            break;
            case 6:
                asd = "d";
            break;
            case 7:
                asd = "e";
            break;
        }
        return asd ;
    }


    // Driver method to
    public static void main(String args[]) {
        Graph g = new Graph(8);

        g.addEdge(0, 1);//H to C
        g.addEdge(1, 2);//C to A
        g.addEdge(1, 3);//C to G
        g.addEdge(2, 4);//A to B
        g.addEdge(3, 5);//G to K
        g.addEdge(4, 6);//B to D
        g.addEdge(4, 7);//B to E

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex H)");

        g.BFS(0);
    }
}