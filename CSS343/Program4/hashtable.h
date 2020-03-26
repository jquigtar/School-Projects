//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_HASHTABLE_H
#define PROGRAM4_HASHTABLE_H

#include <iostream>
#include "customer.h"

using namespace std;


class HashTable {
public:
    HashTable();
    ~HashTable();
    bool insert(Customer* customer);
    bool remove(const int &key);
    bool retrieve(const int &key, Customer *&toReturn) const;
private:
    Customer* table[100][100];
    int hashFunction(const int &key) const;
};


#endif //PROGRAM4_HASHTABLE_H
