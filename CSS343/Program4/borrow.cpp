//
// Created by Jordan Quigtar on 3/11/20.
//

#include "borrow.h"

Borrow::Borrow(){

}

Borrow::~Borrow() {

}

Borrow::Borrow(Movie* movie) {
    this->movie = movie;
}

bool Borrow::doTransaction(Movie* movie) {
    movie->setStock(movie->getStock() - 1);
    return true;
}