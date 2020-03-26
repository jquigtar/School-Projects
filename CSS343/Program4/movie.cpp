//
// Created by Jordan Quigtar on 3/11/20.
//

#include "movie.h"

Movie::Movie() {

}

Movie::~Movie() {

}

ostream &operator<<(ostream &os, const Movie &movie) {
    os << movie.title << " (Stock = " << movie.stock << ")" << endl;
    return os;
}
