//
// Created by Jordan Quigtar on 3/11/20.
//

#include "drama.h"
using namespace std;

Drama::Drama(int stock, string director, string title, int releaseYear) {
    this->stock = stock;
    this->director = director;
    this->title = title;
    this->releaseYear = releaseYear;
}

int Drama::getStock() {
    return stock;
}

void Drama::setStock(int stock) {
    this->stock = stock;
}

string Drama::getDirector() {
    return director;
}

string Drama::getTitle() {
    return title;
}

int Drama::getYear() {
    return releaseYear;
}

bool Drama::operator<(const Movie &movie) const {
    const Drama& dramaCast = static_cast<const Drama&>(movie);

    if (this->director < dramaCast.director){
        return true;
    }
    else if (this->director == dramaCast.director)
    {
        return (this->title < dramaCast.title);
    }
    else
    {
        return false;
    }
}

bool Drama::operator==(const Movie &movie) const {
    const Drama& dramaCast = static_cast<const Drama&>(movie);
    return (this->title == dramaCast.title && this->director == dramaCast.director);}

bool Drama::operator>(const Movie &movie) const {
    return !(*this < movie);
}

//director, title