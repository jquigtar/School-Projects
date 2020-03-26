// ------------------------------------------- polynomialDriver.cpp ---------------------------------------------------

// Jordan Quigtar CSS 343 C

// January 15, 2020

// January 18, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - this file is used to test the polynomial class and all of its functions

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

#include <iostream>
#include <cassert>
using namespace std;

#include "polynomial.h"

/**
 * result
 *
 * this is function that returns a boolean for testing and prints what test
 * is being run to the console.
 * @pre The test string holds a description of the test, and the boolean is set to the
 *      correct value
 * @post The description of the test will be printed to the console as well as whether
 *       it was true or false.
 */
bool result(string test, bool boolean){
    if(boolean == true){
        cout << test + " => true\n";
    }else{
        cout << test + " => false\n";
    }
    return boolean;
}

/**
 * test1
 *
 * This is a test function to test the getSize, constructor, copy constructor,
 * assignment operator, << operator of the polynomial class
 *
 */
void test1(){
    cout << " ------------- test1  ------------- \n\n";

    Polynomial p1;
    cout << "p1 = " << p1;
    assert(result("p1.getSize() == 0", p1.getSize() == 0));

    p1.changeCoefficient(2,3);
    cout << "p1 = " << p1;
    assert(result("p1.getSize() == 1", p1.getSize() == 1));

    p1.changeCoefficient(-3,1);
    cout << "p1 = " << p1;
    assert(result("p1.getSize() == 2", p1.getSize() == 2));

    p1.changeCoefficient(1,5);
    cout << "p1 = " << p1;
    assert(result("p1.getSize() == 3", p1.getSize() == 3));

    p1.changeCoefficient(0,3);
    cout << "p1 = " << p1;
    assert(result("p1.getSize() == 2", p1.getSize() == 2));

    Polynomial p2(p1);
    assert(&p1 != &p2);
    assert(p1.getSize() == p2.getSize());
    cout << "p1 = " << p1;
    cout << "p2 = " << p2;

    Polynomial p3;
    p3.changeCoefficient(10,5);
    p3.changeCoefficient(-3,7);
    cout << "p3 = " << p3;

    p3 = p2;
    assert(&p3 != &p2);
    assert(&p3 != &p1);
    cout << "p1 = " << p1;
    cout << "p2 = " << p2;
    cout << "p3 = " << p3;

}

/**
 * test2
 *
 * This is a test function to test the degree, coefficient, changeCoefficient
 * functions of the polynomial class
 */
void test2(){
    cout << " ------------- test2  ------------- \n\n";
    Polynomial p1;
    assert(p1.degree() == 0);
    assert(p1.coefficient(1) == 0);
    assert(p1.coefficient(2) == 0);

    p1.changeCoefficient(2,3);
    assert(p1.degree() == 3);
    assert(p1.coefficient(3) == 2);

    p1.changeCoefficient(-1,1);
    assert(p1.degree() == 3);
    assert(p1.coefficient(1) == -1);

    p1.changeCoefficient(1,5);
    assert(p1.degree() == 5);
    assert(p1.coefficient(5) == 1);

    p1.changeCoefficient(-10,0);
    assert(p1.degree() == 5);
    assert(p1.coefficient(0) == -10);
    cout << "p1 = " << p1 << endl;

    p1.changeCoefficient(10,0);
    assert(p1.coefficient(0) == 10);
    cout << "p1 = " << p1 << endl;

    p1.changeCoefficient(0,0);
    assert(p1.coefficient(0) == 0);

    cout << "p1 = " << p1 << endl;
}

/**
 * test3
 *
 * This is a test function to test the +, -, +=, -= operators of the polynomial class
 */
void test3(){
    cout << " ------------- test3  ------------- \n\n";
    Polynomial p1;
    p1.changeCoefficient(2,3);
    p1.changeCoefficient(-3,1);
    p1.changeCoefficient(1,5);
    cout << "p1 = " << p1 << endl;

    Polynomial p2;
    p2.changeCoefficient(-3,7);
    p2.changeCoefficient(4,3);
    p2.changeCoefficient(9,2);
    cout << "p2 = " << p2 << endl;

    Polynomial p3 = p1 + p2;
    cout << "p3 = p1 + p2 = " << p3 << endl;

    Polynomial p4 = p1 - p2;
    cout << "p4 = p1 - p2 = " << p4 << endl;

    Polynomial p5 = p2 - p1;
    cout << "p5 =  p2 - p1 = " << p5 << endl;

    p5 -= p1;
    cout << "p5 -= p1 = " << p5 << endl;

    Polynomial p6;
    p6 += p2;
    cout << "p6 += p2 = " << p6 << endl;
    p6 += p1;
    cout << "p6 += p1 = " << p6 << endl;


}

/**
 * test4
 *
 * this is a test function to test the ==, != operators of the polynomial class
 */
void test4(){
    cout << " ------------- test4  ------------- \n\n";
    Polynomial p1;
    Polynomial p2;
    assert(result("p1 == p2", p1 == p2));
    assert(!result("p1 != p2", p1 != p2));


    p1.changeCoefficient(5,5);
    assert(!result("p1 == p2", p1 == p2));
    assert(result("p1 != p2", p1 != p2));

    p2.changeCoefficient(5,4);
    assert(!result("p1 == p2", p1 == p2));
    assert(result("p1 != p2", p1 != p2));

    Polynomial p3;
    Polynomial p4;

    p3.changeCoefficient(4,5);
    p4.changeCoefficient(3,5);
    assert(!result("p3 == p4", p3 == p4));
    assert(result("p3 != p4", p3 != p4));

}

/**
 * runAllTests
 *
 * This is a function to run each test function of the polynomial class
 */
void runAllTests(){
    test1();
    test2();
    test3();
    test4();
}
/**
 * main
 *
 * This is the main function of the polynomialDriver that will
 * run all tests for the polynomial class
 */
int main(){
    runAllTests();
    return 0;
}

