//
// Created by Jordan Quigtar on 3/11/20.
//

#include "return.h"


Return::Return(){

}

Return::~Return() {

}

Return::Return(Movie* movie) {
    this->movie = movie;
}

bool Return::doTransaction(Movie* movie) {
    movie->setStock(movie->getStock() + 1);
    return true;
}
