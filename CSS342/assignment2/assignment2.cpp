//
// Created by Jordan Quigtar on 10/7/19.
//

#include <iostream>
#include <sstream>
#include <cassert>

#include "timespan.h"

using namespace std;

/*
 * test1
 *
 * testing constructor to test the constructors, and overloaded <<
 * operator
 */
void test1(){
    TimeSpan ts(1,20,30);
    stringstream ss;

    ss << ts;
    cout << ts << endl;
    assert(ss.str() == "1:20:30");

    TimeSpan ts2(4, -20, -90);
    ss.str("");
    ss << ts2;
    cout <<ts2 << endl;
    assert(ss.str() ==  "3:38:30");


    TimeSpan ts3(1.5, 30.5, -90);
    ss.str("");
    ss << ts3;
    cout << ts3 << endl;
    assert(ss.str() == "1:59:00");

    TimeSpan ts4(0, 0.07, 0);
    ss.str("");
    ss << ts4;
    cout << ts4 << endl;
    assert(ss.str() == "0:00:04");

    TimeSpan ts5;
    ss.str("");
    ss << ts5;
    cout << ts5 << endl;
    assert(ss.str() == "0:00:00");

    TimeSpan ts6(1);
    ss.str("");
    ss << ts6;
    cout << ts6 << endl;
    assert(ss.str() == "1:00:00");

    TimeSpan ts7(1, 1);
    ss.str("");
    ss << ts7;
    cout << ts7 << endl;
    assert(ss.str() == "1:01:00");

    TimeSpan ts8(0, 0, -1);
    ss.str("");
    ss << ts8;
    cout << ts8 << endl;
    assert(ss.str() == "-0:00:01");

    TimeSpan ts9(0, -1, 0);
    ss.str("");
    ss << ts9;
    cout << ts9 << endl;
    assert(ss.str() == "-0:01:00");

    TimeSpan ts10(-1, 0, 0);
    ss.str("");
    ss << ts10;
    cout << ts10 << endl;
    assert(ss.str() == "-1:00:00");

}

/*
 * test2
 *
 * testing equality statements, addition, subtraction, and multiplication
 * of TimeSpan objects
 */
void test2(){
    TimeSpan ts(1, 20, 30);
    TimeSpan ts2(1, 20, 30);
    TimeSpan ts3(0, 0, 0);
    TimeSpan ts4(-1, -20, -30);

    cout << ts << endl;
    cout << ts2 << endl;
    cout << ts3 << endl;
    cout << ts4 << endl;

    cout << (ts == ts2) << endl;
    assert(ts == ts2);

    cout << !(ts < ts2) << endl;
    assert(!(ts < ts2));

    cout << !(ts > ts2) << endl;
    assert(!(ts > ts2));

    cout << (ts <= ts2) << endl;
    assert(ts <= ts2);

    cout << (ts >= ts2) << endl;
    assert(ts >= ts2);

    cout << !(ts < ts3) << endl;
    assert(!(ts < ts2));

    cout << (ts > ts3) << endl;
    assert(ts > ts3);

    cout << (ts != ts4) << endl;
    assert(ts != ts4);

    cout << (ts > ts4) << endl;
    assert(ts > ts4);

    cout << !(ts < ts4) << endl;
    assert(!(ts < ts4));

    cout << (!(ts != ts2)) << endl;
    assert(!(ts != ts2));

    cout << (ts != ts3) << endl;
    assert(ts != ts3);

    cout << ((ts + ts +ts) == (ts2 * 3)) << endl;
    assert((ts + ts +ts) == (ts2 * 3));

    cout << ((ts * 5) == (ts2 * 4) + ts2) << endl;
    assert((ts * 5) == (ts2 * 4) + ts2);

    cout << ((ts * 5) == ((ts2 * 6) - ts2)) << endl;
    assert((ts * 5) == (ts2 * 6) - ts2);

    cout << ((ts + ts - ts) == ((ts2 * 2) - ts)) << endl;
    assert((ts + ts - ts) == ((ts2 * 2) - ts));

    cout << ((ts - ts2) == ts3) << endl;
    assert((ts - ts2) == ts3);

    cout << ((ts3 * 5) == ts3) << endl;
    assert((ts3 * 5) == ts3);

    stringstream ss;


    ts += ts2;
    ss.str("");
    ss << ts;
    cout << ts << endl;
    assert(ss.str() == "2:41:00");

    ts2 += ts4;
    ss.str("");
    ss << ts2;
    cout << ts2 << endl;
    assert(ss.str() == "0:00:00");

}

/*
 * testAll
 *
 * this function runs both test1() and test2() functions.
 */
void testAll(){
    test1();
    test2();
}

/*
 * main
 *
 * this is the main function for the timespan class. it will run tests on
 * equality statements, addition, subtraction, and multiplication
 * of TimeSpan objects, as well as constructors and the overloaded <<
 * operator for the TimeSpan class
 */
int main(){
    testAll();
    cout << "Done." << endl;
    return 0;
}