//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_FUNNY_H
#define PROGRAM4_FUNNY_H


#include <iostream>
#include "movie.h"

using namespace std;

class Funny : public Movie{

public:
    Funny();
    Funny(int stock, string director, string title, int releaseYear);
    int getStock();
    void setStock(int);
    string getDirector();
    string getTitle();
    int getYear();

    bool operator<(const Movie& rhs) const;

    bool operator==(const Movie& rhs) const;

    bool operator>(const Movie& rhs) const;


};


#endif //PROGRAM4_FUNNY_H
