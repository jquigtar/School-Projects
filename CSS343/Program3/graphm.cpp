// ------------------------------------------------- graphm.cpp -------------------------------------------------------

// Jordan Quigtar CSS 343 C

// February 6, 2020

// February 14, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - this is the implementation file of the GraphM class

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

#include "graphm.h"


GraphM::GraphM() {
    for(int i = 1; i < MAXNODES_DIJ; i++){
        for(int j = 1; j < MAXNODES_DIJ; j++){// do not use first column and first row
            T[i][j].visited = false;    //set all to unvisited
            T[i][j].dist = INT_MAX;     //set all distances to infinity
            T[i][j].path = 0;           //keep paths from '0' node to show it has not been initialized
            C[i][j] = INT_MAX;          //set all distances to infinity
        }
    }
    size = 0;   //no vertex's in graph yet
}

void GraphM::buildGraph(ifstream &inFile) {
    inFile >> size; //first line is size
    for(int i = 0; i <= size; i++){     //move cursor then read in data for each vertex
        data[i].setData(inFile);
    }

    while(!inFile.eof()){   //if end of file is reached
        int from, weight, to;
        inFile >> from >> weight >> to; // each edge read in this order
        if(from != 0){  //have not reached end of data for graph
            insertEdge(from, weight, to);   //insert into cost adjacency matrix
        }else{  // if you have reached 0 then that is the end of first graph in file
            break;
        }
    }
}

void GraphM::insertEdge(int fromNode, int toNode, int weight) {
    C[fromNode][toNode] = weight;   //insert weight to corresponding spot in cost adjacency matrix
}

void GraphM::removeEdge(int fromNode, int toNode) {
    C[fromNode][toNode] = INT_MAX; // set distance to infinity since there is no more edge
    for(int i = 1; i <= size; i++){ //reset Dijkstra matrix since shortest paths may have changed
        for(int j = 1; j <= size; j++){
            T[i][j].visited = false;
            T[i][j].dist = INT_MAX;
            T[i][j].path = 0;
        }
    }
}

void GraphM::findShortestPath() {
    for (int source = 1; source <= size; source++) {    //start at each vetex
        T[source][source].dist = 0;         //vertex distance to self is 0
        T[source][source].path = source;    //came from itself
        T[source][source].visited = true;   //set to visited

        for (int i = 1; i <= size; i++) {   //setting distance to all direct edges from source
            if (C[source][i] != INT_MAX) {
                T[source][i].dist = C[source][i];
                T[source][i].path = source;
            }
        }


        for (int i = 1; i <= size; i++) {   //finding next shortest distance/path
            int v = 0;
            int shortestDistance = INT_MAX;
            for (int j = 1; j <= size; j++) {   //checking each vertex for shortest path from source
                if (T[source][j].dist != INT_MAX) { //path exists
                    if (T[source][j].dist < shortestDistance) { //is the shortest path
                        if (!T[source][j].visited) {    //has not yet been visited
                            v = j;  //j i shortest path
                            shortestDistance = T[source][j].dist;   //set to compare
                        }
                    }
                }
            }
            if (v != 0){    // if all vertex's and paths have not been visited
                T[source][v].visited = true;    //now have visited this vertex


                for (int w = 1; w <= size; w++) {   // checking adjacent edges from v
                    if (C[v][w] != INT_MAX) {   //if edge exists
                        if (!T[source][w].visited) {    //and has not beeen visited
                            shortestDistance = min(T[source][w].dist, T[source][v].dist + C[v][w]); //find shortest path
                            if (shortestDistance == T[source][v].dist + C[v][w]) {  //if changed from previous value
                                T[source][w].path = v;  //set that this path has come from v
                            }
                            T[source][w].dist = shortestDistance;   //set path to w as path from v

                        }
                    }
                }
            }
        }
    }
}

void GraphM::displayAll() const {
    cout << "Description        From Node   To Node    Dijkstra's   path" << endl;
    for(int i = 1; i <= size; i++){ //for each vertex
        cout << data[i] << endl;    //description
        for(int j = 1; j <= size; j++){ //checking if possible to all other vertex's
            if(j != i){ // if path is not from vertex to same vertex
                cout << "                   " <<  i << "           " << j;  // from...to
                if(T[i][j].dist != INT_MAX) {
                    cout << "          " << T[i][j].dist;   //prints cost
                }else{
                    cout << "          ---";    //cost is infinity
                }
                cout << "           ";
                getPath(i,j);   //prints path if found
                cout << endl;
            }
        }
        cout << endl;
    }
}

void GraphM::getPath(int from, int to) const {
    if(T[from][to].dist == INT_MAX){    //base if path does not exist
        return;
    }else if(from == to){   //base if beginning of path
        cout << from << " ";
    }else{
        getPath(from, T[from][to].path);    //recursing back through path
        cout << to << " ";  //popping and printing each vertex visited
    }
}

void GraphM::display(int from, int to) const {
    if(T[from][to].dist != INT_MAX) {   //if path exists and is not infinite
        cout << from << "          " << to << "          " << T[from][to].dist << "          ";
        getPath(from, to);  //printing path if found
        cout << endl;
        displayHelper(from, to);    //printing out descriptions of path
        cout << endl;
    }else{  //no path exists
        cout << from << "          " << to << "          ---" << endl;
    }
}

void GraphM::displayHelper(int from, int to) const {    //same logic as getPath
    if(T[from][to].dist == INT_MAX){
        return;
    }else if(from == to){
        cout << data[from] << endl;
    }else{
        displayHelper(from, T[from][to].path);
        cout << data[to] << endl;
    }
}
