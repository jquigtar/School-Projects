//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_CLASSICMOVIE_H
#define PROGRAM4_CLASSICMOVIE_H


#include <iostream>
#include "movie.h"

using namespace std;

class ClassicMovie : public Movie{
public:
    ClassicMovie();
    ClassicMovie(int stock, string director, string title, string majorActor, int releaseMonth, int releaseYear);
    int getStock();
    void setStock(int);

    string getDirector();

    string getTitle();

    string getActor();
    int getMonth();

    int getYear();


    bool operator<(const Movie& rhs) const;


    bool operator==(const Movie& rhs) const;


    bool operator>(const Movie& rhs) const;

private:
    string majorActor;
    int releaseMonth;
};


#endif //PROGRAM4_CLASSICMOVIE_H
