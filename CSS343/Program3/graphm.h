// -------------------------------------------------- graphm.h --------------------------------------------------------

// Jordan Quigtar CSS 343 C

// February 6, 2020

// February 14, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - this is the header file of the GraphM class to declare all methods

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

#ifndef PROGRAM3_1_GRAPHM_H
#define PROGRAM3_1_GRAPHM_H

#include "nodedata.h"
#include <climits>

static const int MAXNODES_DIJ = 101;

/**
 * GraphM
 *
 * this is the GraphM class to create a weighted directed graph that is read in from a text
 * file. it has data members to hold a cost array matrix, Dijkstra matrix, and the size or
 * number of vertexts in the graph. this Graph class is used to implement the Dijkstra
 * algorithm to find the shortest path from one vertex to another in a graph.
 */
class GraphM {
public:

    /**
     * constructor
     *
     * among others that need to be initialized, the data
     * member T is initialized to sets all dist to
     * infinity, sets all visited to false, and sets all path to 0.
     * @pre structs are correctly initialized and well formed
     * @post all data members are initiliazed
     */
    GraphM();

    /**
     * buildGraph
     *
     * builds up graph node information and adjacency matrix
     * of edges between each node reading from a data file.
     * @param inFile a file being read in to fill Graph
     * @pre assume the input data file has correctly formatted, valid data.
     *      in the form first line tells the number of nodes, say n, followed
     *      by a text description of each of the 1 through n nodes, one description
     *      per line (50 chars max length).  After that, each line consists of 3
     *      integers representing an edge. If there is an edge from node 1 to
     *      node 2 with a label of 10, the data is: 1 2 10.  If the first integer
     *      is zero, it means the end of the data for that one graph.
     *      There may be several graphs, each having at most 100 nodes
     * @post the graphs adjacency matrix will have been initialized
     */
    void buildGraph(ifstream& inFile);

    /**
     * insertEdge
     *
     * insert an edge into graph between two given nodes in the adjacency matrix
     * @param fromNode
     * @param toNode
     * @param weight
     * @pre this function assumes that 0 < fromNode/toNode < MAXNODES_DIJ
     *      it also assumes that weight > 0, and
     * @post the corresponding edge in the adjecency matrix is initialized
     */
    void insertEdge(int fromNode, int toNode, int weight);

    /**
     * removeEdge
     *
     * remove an edge between two given nodes in the adjacency matrix and resets
     * Dijkstra matrix since shortest paths may now have been changed
     * @param fromNode
     * @param toNode
     * @pre assumes that that 0 < fromNode/toNode < MAXNODES_DIJ
     * @post corresponding edge in adjacency matrix is set to infinity and
     *       T data is reset
     */
    void removeEdge(int fromNode, int toNode);

    /**
     * findShortestPath
     *
     * find the shortest path between every node to
     * every other node in the graph, i.e., TableType T is updated
     * with shortest path information
     * @pre the costa adjacency matrix is correctly initialized and well formed
     * @post the TableType T is updated with shortest path information
     *       including cost and previous vertex in path as well as whether or not the
     *       vertext has been visited by the algorithm
     */
    void findShortestPath();

    /**
     * displayAll
     *
     * uses couts to demonstrate that the algorithm works
     * properly. For the data in Figure 1, it will produce the sample
     * output.
     * @pre findShortestPath algorithm has worked and TableType T is correctly initialized and
     *      well formed
     * @post the data is correclty printed to the console in the form given from figure
     *       1 on homework assignment 3
     */
    void displayAll() const;

    /**
     * display
     *
     *
     * uses couts to display the shortest distance with path
     * info between the fromNode to toNode. For the data in Figure
     * 1, a call of G.display(1,4) is going to produce the following
     * output (similar to):
     * 1       4      50          1   3   2   4
     *
     * Aurora and 85th
     *
     * Woodland Park Zoo
     *
     * Green Lake Starbucks
     *
     * Troll under Aurora bridge
     * @param from
     * @param to
     * @pre TableType T is correctly initialized and well formed
     * @post the correct data is displayed to the console
     */
    void display(int from, int to) const;

private:
    /**
     * TableType
     *
     * This is a struct to of a ADT that holds data for whether or not a vertex
     * has been visited or not in the dijkstra algorithm, shortest distance known so
     * far from the source, and the previous node in the path of minimum distance.
     */
    struct TableType {

        bool visited;          // whether node has been visited

        int dist;              // shortest distance from source known so far

        int path;              // previous node in path of min dist

    };

    NodeData data[MAXNODES_DIJ];              // data for graph nodes

    int C[MAXNODES_DIJ][MAXNODES_DIJ];            // Cost array, the adjacency matrix

    int size;                             // number of nodes in the graph

    TableType T[MAXNODES_DIJ][MAXNODES_DIJ];      // stores visited, distance, path

    /**
     * getPath
     *
     * this is a helper method for display and displayAll that recursively prints the path
     * from the beginning node from to the ending node to
     * @param from
     * @param to
     * @pre TableType T is correctly initialized and well formed
     * @post
     */
    void getPath(int from, int to)const;

    /**
     * displayHelper
     *
     * this is helper method for the display function that prints the data
     * for each vertex along a path from the beginning node from to the ending node to
     * @param from
     * @param to
     * @pre TableType T is correctly initialized and well formed
     *      data array for graph nodes data is correctly initialized and well formed
     * @post the data for each vertex along a path is printed to the console
     */
    void displayHelper(int from, int to) const;
};


#endif //PROGRAM3_1_GRAPHM_H
