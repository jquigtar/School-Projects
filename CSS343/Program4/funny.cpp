//
// Created by Jordan Quigtar on 3/11/20.
//

#include <iostream>
#include "funny.h"

using namespace std;

Funny::Funny(int stock, string director, string title, int releaseYear){
    this->stock = stock;
    this->director = director;
    this->title = title;
    this->releaseYear = releaseYear;
}

int Funny::getStock() {
    return stock;
}

void Funny::setStock(int stock) {
    this->stock = stock;
}

string Funny::getDirector() {
    return director;
}

string Funny::getTitle() {
    return title;
}

int Funny::getYear() {
    return releaseYear;
}

bool Funny::operator<(const Movie &movie) const {
    const Funny& comedyCast = static_cast<const Funny&>(movie);

    if (this->title < comedyCast.title)
    {
        return true;
    }
    else if (this->title == comedyCast.title)
    {
        return (this->releaseYear < comedyCast.releaseYear);
    }
    else
    {
        return false;
    }
}

bool Funny::operator==(const Movie &movie) const {
    const Funny& funnyCast = static_cast<const Funny&>(movie);
    return (title == funnyCast.title && this->releaseYear == funnyCast.releaseYear);
}

bool Funny::operator>(const Movie &movie) const {
    return !(*this < movie);
}

//title, year
