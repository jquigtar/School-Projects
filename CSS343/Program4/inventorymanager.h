//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_INVENTORYMANAGER_H
#define PROGRAM4_INVENTORYMANAGER_H


#include <iostream>
#include <fstream>
#include <sstream>
#include "movie.h"
#include "drama.h"
#include "funny.h"
#include "classicmovie.h"
#include "transaction.h"
#include "borrow.h"
#include "return.h"
#include "hashtable.h"
#include "BSTree.h"

using namespace std;

class InventoryManager{
public:
    void buildMovies(ifstream &inFile);
    void buildCustomers(ifstream &inFile);
    void processTransactions(ifstream &inFile);
private:
    HashTable customers;
    BSTree comedyInventory;
    BSTree dramaInventory;
    BSTree classicInventory;

    void parseClassic(string toParse, char &type, int &stock,
                        string &director, string &title, string &ctor, int &month, int &year);

    void parseFD(string toParse, char &type, int &stock,
                 string &director, string &title, int &year);
};



#endif //PROGRAM4_INVENTORYMANAGER_H
