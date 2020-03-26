//
// Created by Jordan Quigtar on 10/7/19.
//

#ifndef HWASSIGNMENT2_TIMESPAN_H
#define HWASSIGNMENT2_TIMESPAN_H
#include<iostream>
using namespace std;

/*
 * TimeSpan
 *
 * this is a class TimeSpan that holds doubles for hours, minutes, seconds, and
 * totalSeconds to keep track of a time in the format 0:00:00. it has a private
 * method simplify to change format the hours, minutes, and seconds. it also has
 * public methods to overload the operators for TimeSpan for; displaying,
 * operator<<; equality, operator==, operator!=; comparison, operator>, operator<,
 * operator>=, operator<=; addition and subtraction, operator+, operator-,
 * operator+=, operator-=; and integer multiplication, operator*
 */
class TimeSpan {
private:
    double hours;
    double minutes;
    double seconds;
    double totalSeconds;

    /*
     * simplify
     *
     * this is a helper method simplify that takes the hours, minutes, and seconds
     * for an instance of Timespan and converts it to overall amount of seconds
     * and stores this in totalSeconds. it then uses the total amount of seconds
     * to convert it back to the correct hours, minutes, and seconds as a their
     * respective whole numbers. with minutes, and seconds being between 0-59
     */
    void simplify();

public:

    /*
     * TimeSpan
     *
     * this is an empty constructor for the TimeSpan class that
     * initializes hours, minutes, and seconds to 0. it also uses
     * a helper method simplify to convert the minutes and seconds to
     * numbers from 0-59, and then changes hours respectively
     */
    TimeSpan ();

    /*
     * TimeSpan
     *
     * this constructor for the TimeSpan class that takes in one parameter
     * for hours and also sets minutes, and seconds to 0. it also uses
     * a helper method simplify to convert the minutes and seconds to
     * numbers from 0-59, and then changes hours respectively
     */
    TimeSpan(double hours);

    /*
     * TimeSpan
     *
     * this is a constructor for the class TimeSpan that takes two parameters
     * for hours and minutes while also setting seconds to 0. it also uses
     * a helper method simplify to convert the minutes and seconds to
     * numbers from 0-59, and then changes hours respectively
     */
    TimeSpan(double hours, double minutes);

    /*
     * TimeSpan
     *
     * this is a constructor for the TimeSpan class and takes 3 parameters
     * for hours, minutes, and seconds and initializes their respective
     * private data members for the TimeSpan class. it also uses
     * a helper method simplify to convert the minutes and seconds to
     * numbers from 0-59, and then changes hours respectively
     */
    TimeSpan(double hours, double minutes, double seconds);

    /*
     * TimeSpan
     *
     * this is a copy constructor that uses a deep copy to make a new
     * instance of TimeSpan with the same values for minutes, hours, seconds,
     * and totalSeconds
     */
    TimeSpan(const TimeSpan& t2);

    /*
     * operator<<
     *
     * this is a function to overload the << operator to print the
     * hours, minutes, seconds to the console in the form 0:00:00 with minutes,
     * and seconds being numbers between 0-59. also it handles if the totalseconds
     * is a negative value it will print to the console in the form -0:00:00.
     * this function is a friend function so ostream can see into the TimeSpan class
     * and teh ostream outstream will be returned.
     */
    friend ostream& operator<<(ostream &outstream, const TimeSpan &time);

    /*
     * operator==
     *
     * this is a function to overload the == operator to check that the instance
     * of TimeSpan the function was called on is equal to the instance of TimeSpan
     * t2 passed into the parameter of the function. it does this by checking that
     * the totalSeconds is the same because it will convert to the same hours minutes
     * and seconds as well as let us know if they are both negative or positive
     * if they are equal it will return true, if not it will return false.
     */
    bool operator==(const TimeSpan &t2) const;

    /*
     * operator!=
     *
     * this is a function to overload the != operator to check that the instance
     * of TimeSpan the function was called on, is not equal to the instance of TimeSpan
     * t2 passed into the parameter of the function. it does this by checking that
     * the totalSeconds is not equal between the two.
     * if they are not equal it will return true, if not it will return false.
     */
    bool operator!=(const TimeSpan &t2) const;

    /*
     * operator<
     *
     * this is a function to overload the < operator to check that the instance of
     * TimeSpan the function was called on, is less than the instance of TimeSpan
     * passed into the parameter. it does this check with the total seconds for
     * both TimeSpans
     *  if it is less than, it will return
     * true, if it is not it will return false
     */
    bool operator<(const TimeSpan &t2) const;

    /*
     * operator>
     *
     * this is a function to overload the > operator to check that the instance of
     * TimeSpan the function was called on, is greater than the instance of TimeSpan
     * passed into the parameter. it does this check with the total seconds for
     * both TimeSpans
     * if it is greater than, it will return
     * true, if it is not it will return false.
     */
    bool operator>(const TimeSpan &t2) const;

    /*
     * operator>=
     *
     * this is a function to overload the >= operator to check that the instance of
     * TimeSpan the function was called on, is greater than or equal too
     * the instance of TimeSpan passed into the parameter. it does this check with
     * the total seconds for both TimeSpans
     * if it is greater than or equal too it will return
     * true, if it is not it will return false.
     */
    bool operator>=(const TimeSpan &t2) const;

    /*
     * operator <=
     *
     * this is a function to overload the >= operator to check that the instance of
     * TimeSpan the function was called on, is less than or equal too
     * the instance of TimeSpan passed into the parameter. it does this check with
     * the total seconds for both TimeSpans. if it is less than or equal too it will return
     * true, if it is not it will return false.
     */
    bool operator<=(const TimeSpan &t2) const;

    /*
     * operator+
     *
     * this is a function to overload the + operator to add the TimeSpan the
     * function was called on with the TimeSpan passed into the parameter.
     * it will return a new instance of TimeSpan with the correct amount
     * of hours, minutes, and seconds.
     */
    TimeSpan operator+(const TimeSpan &t2) const;

    /*
     * operator-
     *
     * this is a function to overload the - operator to subtract the TimeSpan the
     * function was called on with the TimeSpan passed into the parameter.
     * it will return a new instance of TimeSpan with the correct amount
     * of hours, minutes, and seconds.
     */
    TimeSpan operator-(const TimeSpan &t2) const;

    /*
     * operator+=
     *
     * this is a function to overload the += operator to add the TimeSpan passed
     * into the parameter to the instance of TimeSpan the function is called on
     * it will return the updated TimeSpan the function was called on.
     */
    TimeSpan &operator+=(const TimeSpan &t2);

    /*
     * operator-=
     *
     * this is a function to overload the -= operator to subtract the TimeSpan passed
     * into the parameter to the instance of TimeSpan the function is called on.
     * it will return the updated TimeSpan the function was called on.
     */
    TimeSpan &operator-=(const TimeSpan &t2);

    /*
     * operator*
     *
     * this is a function to overload the * operator to multiply the TimeSpan
     * the function was called on by the int number passed into the parameter.
     * it will return the updated TimeSpan the function was called on.
     */
    TimeSpan operator*(const int &num)const;
};


#endif //HWASSIGNMENT2_TIMESPAN_H
