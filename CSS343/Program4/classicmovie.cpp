//
// Created by Jordan Quigtar on 3/11/20.
//

#include <iostream>
#include "movie.h"
#include "classicmovie.h"

using namespace std;

ClassicMovie::ClassicMovie() {

}

ClassicMovie::ClassicMovie(int stock,string director, string title, string majorActor, int releaseMonth,
                           int releaseYear) {
    this->stock = stock;
    this->director = director;
    this->title = title;
    this->majorActor = majorActor;
    this->releaseMonth = releaseMonth;
    this->releaseYear = releaseYear;
}

int ClassicMovie::getStock() {
    return stock;
}

void ClassicMovie::setStock(int stock) {
    this->stock = stock;
}

string ClassicMovie::getDirector() {
    return director;
}

string ClassicMovie::getTitle() {
    return title;
}

string ClassicMovie::getActor() {
    return majorActor;
}

int ClassicMovie::getMonth() {
    return releaseMonth;
}

int ClassicMovie::getYear() {
    return releaseYear;
}

bool ClassicMovie::operator<(const Movie &movie) const {
    const ClassicMovie& classicCast = static_cast<const ClassicMovie&>(movie);

    //year has priority
    if (this->releaseYear < classicCast.releaseYear)
    {
        return true;
    }
    else if (this->releaseYear == classicCast.releaseYear)
    {
        //years are equal, compare months
        if (this->releaseMonth < classicCast.releaseMonth)
        {
            return true;
        }
        else if (this->releaseMonth == classicCast.releaseMonth)
        {
            //year and months are equal, so compare actors
            if (this->majorActor < classicCast.majorActor)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    else
    {
        return false;
    }
}

bool ClassicMovie::operator==(const Movie &movie) const {
    const ClassicMovie& classicCast = static_cast<const ClassicMovie&>(movie);

    return (this->releaseYear == classicCast.releaseYear && this->releaseMonth == classicCast.releaseMonth
            && this->majorActor == classicCast.majorActor);}

bool ClassicMovie::operator>(const Movie &movie) const {
    return !(*this < movie);
}

//release date, major actor

