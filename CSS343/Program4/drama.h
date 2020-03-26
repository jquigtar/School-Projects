//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_DRAMA_H
#define PROGRAM4_DRAMA_H


#include <iostream>
#include "movie.h"

using namespace std;

class Drama : public Movie{

public:
    Drama();
    Drama(int stock, string director, string title, int releaseYear);
    int getStock();
    void setStock(int);
    string getDirector();
    string getTitle();
    int getYear();

    bool operator<(const Movie& rhs) const;

    bool operator==(const Movie& rhs) const;

    bool operator>(const Movie& rhs) const;
};



#endif //PROGRAM4_DRAMA_H
