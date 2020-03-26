//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_TRANSACTION_H
#define PROGRAM4_TRANSACTION_H

#include <iostream>
#include "movie.h"

using namespace std;

class Transaction {
public:
    Transaction();
    virtual ~Transaction();
    virtual bool doTransaction(Movie* movie) = 0;

};



#endif //PROGRAM4_TRANSACTION_H
