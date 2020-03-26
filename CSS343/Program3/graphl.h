// -------------------------------------------------- graphl.h --------------------------------------------------------

// Jordan Quigtar CSS 343 C

// February 6, 2020

// February 14, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - this is the header file of the GraphL class to declare all methods

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

#ifndef PROGRAM3_2_GRAPHL_H
#define PROGRAM3_2_GRAPHL_H

#include "nodedata.h"

static const int MAXNODES_DFS = 101;


/**
 * GraphL
 *
 * this is a class GraphL to hold data for a directed unweighted graph that is read in from a text
 * file it has data members to hold data for the adjacency list of a graph and the
 * size of how many vertex's there are in the graph. this graph class is used to implement
 * the depth first search algorithm for a graph.
 */
class GraphL {
public:

    /**
     * constructor
     *
     * initializes the graph's size to 0 and the adjacency list to be empty and
     * unvisited at all vertex's
     * @pre structs are correctly initialized and well formed
     * @post all data members are initiliazed
     */
    GraphL();

    /**
     * destructor
     *
     * cleans up and deletes all dynamically allocated memory
     * @pre adjacency list is correcly initialized and well formed
     * @post all dynamically allocated memory is deleted
     */
    ~GraphL();

    /**
     * buildGraph
     *
     * builds up graph node information and adjacency list of edges
     * between each node reading from a data file.
     * @param inFile
     * @pre assume the input data file has correctly formatted, valid data.
     *      in the form  first line tells the number of nodes, say n,
     *      followed by a text description of each of the 1 through n nodes,
     *      one description per line (50 chars max length).  After that, each
     *      line consists of 2 integers representing an edge. If there is an
     *      edge from node 1 to node 2, the data is: 1 2.  A zero for the first
     *      integer signifies the end of the data for that one graph. In the file,
     *      all the edges for the 1st node will be listed first, then all the edges
     *      for the 2nd node, etc. Take them as they come, no sorting. There may
     *      be several graphs, each having at most 100 nodes.
     * @post the adjacency list is correctly initialized and well formed
     */
    void buildGraph(ifstream& inFile);

    /**
     * displayGraph
     *
     * Displays each node information and edge in the graph
     * (e.g., the top portion of Figure 2 (c))
     * @pre the adjacency list is correctly initialized and well formed
     * @post each node's information and each of its edges are displayed to the console
     */
    void displayGraph();

    /**
     * depthFirstSearch
     *
     * Makes a depth-first search and displays each node
     * in depth-first order (e.g., the last line in Figure 2 (c))
     * @pre the adjacency list is correctly initialized and well formed
     * @post the depth-first search is displayed to the console in the correct order
     */
    void depthFirstSearch();

private:

    struct EdgeNode;      // forward reference for the compiler

    /**
     * GraphNode
     *
     * this is a struct for a ADT that holds a list of edgeNodes that are adjacent to the
     * GraphNode, and data information to describe the GraphNode
     */
    struct GraphNode {    // structs used for simplicity, use classes if desired

        EdgeNode* edgeHead = nullptr; // head of the list of edges

        NodeData* data = nullptr;     // data information about each node

        bool visited;

    };

    /**
     * EdgeNode
     *
     * this is a struct for an ADT that holds data for an adjacent node to a graph
     * node, and a pointer to another adjacent node to the graph node
     */
    struct EdgeNode {

        int adjGraphNode;  // subscript of the adjacent graph node

        EdgeNode* nextEdge = nullptr;

    };

    GraphNode adjacencyList[MAXNODES_DFS]; // array of GraphNodes

    int size;

    /**
     * depthFirstSearch
     *
     * this is a recursive helper function fo teh depthFirstSearch algorithm
     * that displays the correct depth-first search
     * @param node
     * @pre the node being passed in is a valid node in the graph and is the first node
     * @post correct depth-first search is displayed to the console
     */
    void depthFirstSearch(int node);
};


#endif //PROGRAM3_2_GRAPHL_H
