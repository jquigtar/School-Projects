// ------------------------------------------------- graphl.cpp -------------------------------------------------------

// Jordan Quigtar CSS 343 C

// February 6, 2020

// February 14, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - this is the implementation file of the GraphL class

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

#include "graphl.h"

GraphL::GraphL() {  //structs set nullptrs
    size = 0;   //0 vertex's in graph
    for(int i = 0; i < MAXNODES_DFS; i++){  //each data is unvisisted
        adjacencyList[i].visited = false;
    }
}

GraphL::~GraphL() {
    for (int i = 0; i <= size; i++) {   //from beginning to size have all been allocated
        delete adjacencyList[i].data;   //deleting description data
        adjacencyList[i].data = nullptr;
        if (adjacencyList[i].edgeHead != nullptr) { //if edges were initialized
            EdgeNode *current = adjacencyList[i].edgeHead;
            while (current != nullptr) {
                EdgeNode *temp = current;       //store to delete
                current = current->nextEdge;    //move to next
                delete temp;                    //delete previous
                temp = nullptr;
            }
        }
    }
}

void GraphL::buildGraph(ifstream &inFile) {
    inFile >> size;     //first line is size
    for(int i = 0; i <= size; i++) {    //setting each vertex description
        adjacencyList[i].data = new NodeData;
        adjacencyList[i].data->setData(inFile);
    }
    while(!inFile.eof()) {  //enf if you reach end of file
        int from, to;
        inFile >> from >> to;   // edges in from..to format in txt file
        if(from != 0){
            EdgeNode *temp = new EdgeNode;
            temp->adjGraphNode = to;
            if(adjacencyList[from].edgeHead != nullptr){
                temp->nextEdge = adjacencyList[from].edgeHead;  //store node in front
            }
            adjacencyList[from].edgeHead = temp;
        }else{
            break;  // if from = 0 end of graph data
        }

    }
}

void GraphL::displayGraph() {
    cout << "Graph: " << endl;
    for(int i = 1; i <= size; i++){
        cout << "Node " << i << "       " << *adjacencyList[i].data << endl;    //print description
        EdgeNode *current = adjacencyList[i].edgeHead;
        while(current != nullptr){
            cout << " edge " << i << " " << current->adjGraphNode << endl;  //print each edge from source
            current = current->nextEdge;
        }
    }
}

void GraphL::depthFirstSearch() {
    cout << "Depth first ordering: ";
    for(int i = 1; i <= size; i++){ //check each vertex
        if(!adjacencyList[i].visited){  //if unvisited perform DFS from this vertex
            depthFirstSearch(i);
        }
    }
    cout << endl;
}

void GraphL::depthFirstSearch(int node) {
    cout << node << " ";    // display this visited node
    adjacencyList[node].visited = true;
    EdgeNode *current = adjacencyList[node].edgeHead;
    while(current != nullptr){
        if(!adjacencyList[current->adjGraphNode].visited){
            depthFirstSearch(current->adjGraphNode);    //if unvisited visit this vertex
        }
        current = current->nextEdge;
    }
}
