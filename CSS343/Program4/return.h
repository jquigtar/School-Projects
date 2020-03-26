//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_RETURN_H
#define PROGRAM4_RETURN_H


#include <iostream>
#include "transaction.h"
#include "movie.h"

using namespace std;

class Return : public Transaction {
public:
    Return();
    ~Return();
    Return(Movie* movie);
    bool doTransaction(Movie* movie);

private:
    Movie* movie;
};




#endif //PROGRAM4_RETURN_H
