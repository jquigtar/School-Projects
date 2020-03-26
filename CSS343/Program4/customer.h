//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_CUSTOMER_H
#define PROGRAM4_CUSTOMER_H


#include <iostream>
#include "transaction.h"
#include <queue>

using namespace std;

class Customer{
public:
    Customer(int id, string first, string last);
    int getID() const;
    void setID(int);
    void addTransaction(string transaction);
    void displayHistory();
private:
    int ID;
    string lastName;
    string firstName;
    int transactionsCount = 0;
    queue<string> transactions;
};


#endif //PROGRAM4_CUSTOMER_H
