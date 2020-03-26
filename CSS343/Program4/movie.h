//
// Created by Jordan Quigtar on 3/11/20.
//

#ifndef PROGRAM4_MOVIE_H
#define PROGRAM4_MOVIE_H


#include <iostream>

using namespace std;

class Movie{
public:
    Movie();
    virtual ~Movie();

    virtual string getTitle() = 0;

    virtual string getDirector()= 0;

    virtual int getYear() = 0;

    virtual int getStock() = 0;

    virtual void setStock(int stock) = 0;

    virtual bool operator<(const Movie& rhs) const = 0;
    virtual bool operator==(const Movie& rhs) const = 0;
    virtual bool operator>(const Movie& rhs) const = 0;

    friend ostream &operator<<(ostream& os, const Movie &movie);

protected:
    int releaseYear;
    string director;
    string title;
    int stock;
};


#endif //PROGRAM4_MOVIE_H
