//
// Created by Jordan Quigtar on 3/11/20.
//

#include "customer.h"

Customer::Customer(int id, string first, string last) {
    ID = id;
    firstName = first;
    lastName = last;
}

int Customer::getID() const{
    return ID;
}

void Customer::setID(int id) {
    ID = id;
}

void Customer::addTransaction(string transaction) {
    transactions.push(transaction);
    transactionsCount++;
}

void Customer::displayHistory() {
    queue<string> toDisplay(transactions);
    for(int i = 0; i < transactionsCount; i++){
        cout << toDisplay.front();
        toDisplay.pop();
    }
}

