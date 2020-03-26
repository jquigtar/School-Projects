//
// Created by Jordan Quigtar on 10/7/19.
//

#include <iostream>
#include "timespan.h"
#include <cmath>
using namespace std;

void TimeSpan::simplify() {
    double changeMinutes;
    double changeHours;
    double trackSeconds;

    totalSeconds = (hours * 3600) + (minutes * 60) + seconds;
    //change hours minutes seconds to total seconds to see if
    //time is - or positive

    trackSeconds = abs(totalSeconds);
    //use absolute value to convert hours, minutes seconds to correct
    //number and keep track of how much hours, and minutes taken out of
    //total seconds

    if (trackSeconds / 3600 > 0) {
        //1hr = 3600 seconds
        changeHours = trackSeconds /3600;
        hours = int(changeHours);
        trackSeconds = trackSeconds - (hours * 3600);
        //take converted hours out of total seconds

    }
    if (trackSeconds / 60 > 0) {
        //1min = 60 seconds
        changeMinutes = trackSeconds / 60;
        minutes = int(changeMinutes);
        trackSeconds = trackSeconds - (minutes * 60);
        //take coverted minutes out of total seconds
    }

    seconds = trackSeconds;
    //seconds equals leftover seconds

}

TimeSpan::TimeSpan() {
    hours = 0;
    minutes = 0;
    seconds = 0;
    simplify();
}

TimeSpan::TimeSpan(double hours) {
    this->hours = hours;
    this->minutes = 0;
    this->seconds = 0;
    simplify();
}

TimeSpan::TimeSpan(double hours, double minutes) {
    this->hours = hours;
    this->minutes = minutes;
    this->seconds = 0;
    simplify();
}

TimeSpan::TimeSpan(double hours, double minutes, double seconds) {
    this->hours = hours;
    this->minutes = minutes;
    this->seconds = seconds;
    this->simplify();
}

TimeSpan::TimeSpan(const TimeSpan &t2) {
    double hours = t2.hours;
    double minutes = t2.minutes;
    double seconds = t2.seconds;
    double totalSeconds = t2.totalSeconds;
    this->hours = hours;
    this->minutes = minutes;
    this->seconds = seconds;
    this->totalSeconds = totalSeconds;
    //deep copy constructor
}

ostream &operator<<(ostream &outStream, const TimeSpan &time) {
    if(time.totalSeconds >=0){
        //time is positive no (-) sign
        if (time.minutes < 10 && time.minutes > -1) {
            if (time.seconds < 10 && time.seconds > -1) {
                outStream << (int) time.hours << ":0" << (int) time.minutes
                          << ":0" << (int) time.seconds;
            } else {
                outStream << (int) time.hours << ":0" << (int) time.minutes
                          << ":" << (int) time.seconds;
            }

        } else {
            if (time.seconds < 10 && time.seconds > -1) {
                outStream << (int) time.hours << ":" << (int) time.minutes
                          << ":0" << (int) time.seconds;
            } else {
                outStream << (int) time.hours << ":" << (int) time.minutes
                          << ":" << (int) time.seconds;
            }
        }
    }else{ // if time is negative add (-) sign
        if (time.minutes < 10 && time.minutes > -1) {
            if (time.seconds < 10 && time.seconds > -1) {
                outStream << "-" << (int) time.hours << ":0" << (int) time.minutes
                          << ":0" << (int) time.seconds;
            } else {
                outStream << "-" << (int) time.hours << ":0" << (int) time.minutes
                          << ":" << (int) time.seconds;
            }

        } else {
            if (time.seconds < 10 && time.seconds > -1) {
                outStream << "-" << (int) time.hours << ":" << (int) time.minutes
                          << ":0" << (int) time.seconds;
            } else {
                outStream << "-" << (int) time.hours << ":" << (int) time.minutes
                          << ":" << (int) time.seconds;
            }
        }
    }
    return outStream;
}

bool TimeSpan::operator==(const TimeSpan &t2) const{
    if(totalSeconds == t2.totalSeconds){
        return true;
    }
    return false;
}

bool TimeSpan::operator!=(const TimeSpan &t2) const{
    if(totalSeconds != t2.totalSeconds){
        return true;
    }
    return false;
}

bool TimeSpan::operator<(const TimeSpan &t2) const{
    if(totalSeconds < t2.totalSeconds){
        return true;
    } else {
        return false;
    }
}

bool TimeSpan::operator>(const TimeSpan &t2) const{
    if(totalSeconds > t2.totalSeconds){
        return true;
    }else {
        return false;
    }
}

bool TimeSpan::operator<=(const TimeSpan &t2) const{
    if(totalSeconds <= t2.totalSeconds){
        return true;
    } else {
        return false;
    }
}

bool TimeSpan::operator>=(const TimeSpan &t2) const{
    if(totalSeconds >= t2.totalSeconds){
        return true;
    } else {
        return false;
    }
}

TimeSpan TimeSpan::operator+(const TimeSpan &t2) const{
    if(totalSeconds >= 0 && t2.totalSeconds >= 0) {
        //positive time for both TimeSpans
        int newHours = hours + t2.hours;
        int newMinutes = minutes + t2.minutes;
        int newSeconds = seconds + t2.seconds;
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    }else if(totalSeconds < 0 && t2.totalSeconds >=0){
        //negative time for this
        int newHours = (-1 * hours) + t2.hours;
        int newMinutes = (-1 * minutes) + t2.minutes;
        int newSeconds = (-1 * seconds) + t2.seconds;
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    } else if (totalSeconds >= 0 && t2.totalSeconds < 0){
        //negative time for t2
        int newHours = hours + (-1 * t2.hours);
        int newMinutes = minutes + (-1 * t2.minutes);
        int newSeconds = seconds + (-1 * t2.seconds);
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    }else {
        //negative time for both this and t2
        int newHours = (-1 * hours) + (-1 * t2.hours);
        int newMinutes = (-1 * minutes) + (-1 * t2.minutes);
        int newSeconds = (-1 * seconds) + (-1 * t2.seconds);
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    }
}

TimeSpan TimeSpan::operator-(const TimeSpan &t2) const {
    if(totalSeconds >= 0 && t2.totalSeconds >= 0) {
        int newHours = hours - t2.hours;
        int newMinutes = minutes - t2.minutes;
        int newSeconds = seconds - t2.seconds;
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    }else if(totalSeconds < 0 && t2.totalSeconds >=0){
        int newHours = (-1 * hours) - t2.hours;
        int newMinutes = (-1 * minutes) - t2.minutes;
        int newSeconds = (-1 * seconds) - t2.seconds;
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    } else if (totalSeconds >= 0 && t2.totalSeconds < 0){
        int newHours = hours - (-1 * t2.hours);
        int newMinutes = minutes - (-1 * t2.minutes);
        int newSeconds = seconds - (-1 * t2.seconds);
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    }else {
        int newHours = (-1 * hours) - (-1 * t2.hours);
        int newMinutes = (-1 * minutes) - (-1 * t2.minutes);
        int newSeconds = (-1 * seconds) - (-1 * t2.seconds);
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    }
}

TimeSpan &TimeSpan::operator+=(const TimeSpan &t2) {
    if(totalSeconds >= 0 && t2.totalSeconds >= 0) {
        this->hours = this->hours + t2.hours;
        this->minutes = this->minutes + t2.minutes;
        this->seconds = this->seconds + t2.seconds;
    }else if(totalSeconds < 0 && t2.totalSeconds >=0){
        this->hours = (-1 * this->hours) + t2.hours;
        this->minutes = (-1 * this->minutes) + t2.minutes;
        this->seconds = (-1 * this->seconds) + t2.seconds;
    } else if (totalSeconds >= 0 && t2.totalSeconds < 0){
        this->hours = this->hours + (-1 * t2.hours);
        this->minutes = this->minutes + (-1 * t2.minutes);
        this->seconds = this->seconds + (-1 * t2.seconds);
    }else {
        this->hours = (-1 * this->hours) + (-1 * t2.hours);
        this->minutes = (-1 * this->minutes) + (-1 * t2.minutes);
        this->seconds = (-1 * this->seconds) + (-1 * t2.seconds);
    }
    this->simplify();
    return *this;
}

TimeSpan &TimeSpan::operator-=(const TimeSpan &t2) {
    if(totalSeconds >= 0 && t2.totalSeconds >= 0) {
        this->hours = this->hours - t2.hours;
        this->minutes = this->minutes - t2.minutes;
        this->seconds = this->seconds - t2.seconds;
    }else if(totalSeconds < 0 && t2.totalSeconds >=0){
        this->hours = (-1 * this->hours) - t2.hours;
        this->minutes = (-1 * this->minutes) - t2.minutes;
        this->seconds = (-1 * this->seconds) - t2.seconds;
    } else if (totalSeconds >= 0 && t2.totalSeconds < 0){
        this->hours = this->hours - (-1 * t2.hours);
        this->minutes = this->minutes - (-1 * t2.minutes);
        this->seconds = this->seconds - (-1 * t2.seconds);
    }else {
        this->hours = (-1 * this->totalSeconds) - (-1 * t2.hours);
        this->minutes = (-1 * this->minutes) - (-1 * t2.minutes);
        this->seconds = (-1 * this->seconds) - (-1 * t2.seconds);
    }
    this->simplify();
    return *this;
}

TimeSpan TimeSpan::operator*(const int &num) const{
    if(this->totalSeconds >= 0) {
        //time is positive
        int newHours = hours * num;
        int newMinutes = minutes * num;
        int newSeconds = seconds * num;
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    } else{
        //time is negative
        int newHours = hours * num * -1;
        int newMinutes = minutes * num * -1;
        int newSeconds = seconds * num * -1;
        TimeSpan toReturn(newHours, newMinutes, newSeconds);

        return toReturn;
    }
}