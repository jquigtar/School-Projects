//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_BORROW_H
#define PROGRAM4_BORROW_H


#include <iostream>
#include "transaction.h"
#include "movie.h"

using namespace std;

class Borrow : public Transaction{

public:
    Borrow();
    ~Borrow();
    Borrow(Movie* movie);
    bool doTransaction(Movie* movie);

private:
    Movie* movie;
};



#endif //PROGRAM4_BORROW_H
