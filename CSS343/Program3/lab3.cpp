//---------------------------------------------------------------------------
// lab3.cpp
//---------------------------------------------------------------------------
// This code tests the basic functionality of the classes to perform
// Dijkstra's algorihms and depth-first search for CSS 343 Lab 3.
// It is not meant to exhaustively test the class. 
//
// Assumptions:
//   -- students can follow the directions to interface with this file
//   -- text files "data31.txt" and "data32.txt" are formatted as described 
//   -- Data file "dataUWB.txt" provides an additional data set for part 3;
//---------------------------------------------------------------------------

#include <iostream>
#include <fstream>
#include "graphl.h"
#include "graphm.h"
using namespace std;

int main() {
    cout << "----------Part1----------" << endl;
    // part 1
	ifstream infile1("data31.txt");
	if (!infile1) {
		cout << "File could not be opened." << endl;
		return 1;
	}

	//for each graph, find the shortest path from every node to all other nodes
	for (;;){
		GraphM G;
		G.buildGraph(infile1);
		if (infile1.eof())
			break;
		G.findShortestPath();
		G.displayAll();              // display shortest distance, path to cout
		G.display(3, 1);              // display path from node 3 to 1 to cout
		G.display(1, 2);
		G.display(1, 4);
		G.removeEdge(3, 2);     //testing removeEdge Function and reprinting
		G.findShortestPath();
		G.displayAll();
		G.display(3,2);
	}

	cout << endl;
	cout << "----------Part2----------" << endl;
//	 part 2
	ifstream infile2("data32.txt");
	if (!infile2) {
		cout << "File could not be opened." << endl;
		return 1;
	}

	//for each graph, find the depth-first search ordering
	for (;;) {
        GraphL G;
        G.buildGraph(infile2);
        if (infile2.eof())
            break;
        G.displayGraph();
        G.depthFirstSearch();    // find and display depth-first ordering to cout
    }

    cout << "----------Part3----------" << endl;
    //	 part 3
    ifstream infile3("dataUWB.txt");        //using dataUWB.txt file given from professor
    if (!infile3) {
        cout << "File could not be opened." << endl;
        return 1;
    }

    //for each graph, find the shortest path from every node to all other nodes
    for (;;){
        GraphM G;
        G.buildGraph(infile3);
        if (infile3.eof())
            break;
        G.findShortestPath();
        G.displayAll();              // display shortest distance, path to cout
        G.display(3, 1);             // display path from node 3 to 1 to cout
        G.display(1, 2);             // display path from node 1 to 2 to cout
        G.display(1, 4);             // display path from node 1 to 4 to cout
    }

	cout << endl;
	return 0;
}
