// ------------------------------------------------ polynomial.h ------------------------------------------------------

// Jordan Quigtar CSS 343 C

// January 15, 2020

// January 18, 2020

// --------------------------------------------------------------------------------------------------------------------

// Purpose - this is the header file of the polynomial class to declare all methods

// --------------------------------------------------------------------------------------------------------------------

// --------------------------------------------------------------------------------------------------------------------

// A Polynomial class
#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H
#include <iostream>
#include <string>
using namespace std;

/**
 * Polynomial
 *
 * this is a class polynomial that creates a polynomial in the form
 * Cn * x^n + Cn-1 * X^n-1 + ... C1 * X + C0 that can handle elementary functions
 * addition and subtraction of two polynomials
 */
class Polynomial {

    /**
     * operator<<
     *
     * Overloaded << operator that will print the polynomial
     * in the form Cn * x^n + Cn-1 * X^n-1 + ... C1 * X + C0
     * @param output
     * @param p
     * @return output in the form Cn * x^n + Cn-1 * X^n-1 + ... C1 * X + C0
     * @pre p will be well formed with no 0 coefficients, ordered, and no duplicate powers
     * @post p will be printed in the form Cn * x^n + Cn-1 * X^n-1 + ... C1 * X + C0
     */
    friend ostream& operator<<( ostream &output, const Polynomial& p );

public:

    // Constructor: the default is a 0-degree polynomial with 0.0 coefficient
    /**
     * constructor
     *
     * this is the constuctor for the polynomial class that will initialize the
     * dummy header
     * @pre constructor called correctly
     * @post polynomial will be initialized with dummy header
     */
    Polynomial( );

    /**
     * copy constructor
     *
     * this is a copy constructor to construct a polynomial by deep copying the data
     * from another polynomial
     * @param p
     * @pre p polynomial is well formed
     * @post a new polynomial is intitialized with same data as p polynomial
     */
    Polynomial( const Polynomial& p );

    /**
     * destructor
     *
     * this will deallocate memory of the polynomial upon termination of a program
     * @pre polynomial is well formed
     * @post memory will be deallocated
     */
    ~Polynomial( );

    /**
     * degree
     *
     * this function will return the highest degree of the polynomial
     * @return highest power in the polynomial
     * @pre polynomial is ordered and well formed
     * @post power of term after header is returned as an int
     */
    int degree( ) const; // returns the degree of a polynomial

    /**
     * coefficient
     *
     * this function will return the coefficient of the term with the the same power
     * passed into the parameter
     * @param power
     * @return coefficient of term with corresponding power
     * @pre polynomial is well formed and ordered
     * @post coefficient is returned as a double
     */
    double coefficient( const int power ) const; // returns the coefficient of the x^power term.

    /**
     * changeCoefficient
     *
     * this is a function that will change the coefficient of the corresponding term
     * with the same power passed into the parameter, if the term doesnt exist in the
     * polynomial it will be created and added
     * @param newCoefficient
     * @param power
     * @return return true if coefficient is changed
     * @pre polynomial is well formed and oredered
     * @post polynomial will have a term with new coefficient or will have a new
     *       term added
     */
    bool changeCoefficient( const double newCoefficient, const int power );
    // replaces the coefficient of the x^power term

    // Arithmetic operators

    /**
     * operator+
     *
     * this is the overloaded + operator to add two polynomials and their terms
     * togther
     * @param p polynomial passed in
     * @return a new polynomial with correct terms
     * @pre both polynomials are well formed and ordered
     * @post a new polynomial is created and returned with correct terms
     */
    Polynomial operator+( const Polynomial& p ) const;

    /**
     * operator-
     *
     * this is the overloaded - operator to subtract two the polynomial p and its terms
     * from the polynomial this function is called on
     * @param p polynomial passed in
     * @return a new polynomial with correct terms
     * @pre both polynomials are well formed and ordered
     * @post a new polynomial is created and returned with correct terms
     */
    Polynomial operator-( const Polynomial& p ) const;

    // Boolean comparison operators
    /**
     * operator==
     *
     * this is the overloaded == operator that will return a boolean for whether the polynomial
     * the function is called on is equal to the polynomial the p passed into the paramter
     * @param p
     * @return true if the polynomials are equal, false if they are not equal
     * @pre both polynomials are well formed and ordered
     * @post a true or false will be returned for whether the polynomials are equal
     */
    bool operator==( const Polynomial& p ) const;

    /**
     * operator!=
     *
     * this is the overloaded != operator that will return a boolean for whether the polynomial
     * the function is called on is not equal to the polynomial the p passed into the paramter
     * @param p
     * @return true if the polynomials are not equal, false if they are
     * @pre both polynomials are well formed and ordered
     * @post a true or false will be returned for whether the polynomials are not equal
     */
    bool operator!=( const Polynomial& p ) const;

    // Assignment operators
    /**
     * operator=
     *
     * this is the assignment operator that will assign the values of the polynomial p
     * to the polynomial this function is called on
     * @param p
     * @return the polynomial this function was called on (this polynomial)
     * @pre both polynomials are well formed and ordered
     * @post this polynomial will have the same data values as the polynomial p
     */
    Polynomial& operator=( const Polynomial& p );

    /**
     * operator+=
     *
     * this is the overloaded += operator that will add the terms of p polynomial to
     * this polynomial and return this polynomial
     * @param p
     * @return this polynomial
     * @pre polynomials are well formed and ordered
     * @post
     */
    Polynomial& operator+=( const Polynomial& p );

    /**
     * operator-=
     *
     * this is the overloaded -= operator that will subtract the terms of p polynomial
     * from this polynomial and return this polynomial
     * @param p
     * @return this polynomial
     * @pre the polynomials are well formed and ordered
     * @post this polynomial will have new terms
     */
    Polynomial& operator-=( const Polynomial& p );

    int getSize() const;
private:
    /**
     * Term
     *
     * this is a struct to hold the data for each term in a polynomial
     */
    struct Term {     // a term on the sparce polynomial
        double coeff;   // the coefficient of each term
        int power;      // the degree of each term
        Term *prev;     // a pointer to the previous higher term
        Term *next;     // a pointer to the next lower term
    };
    int size = 0;         // # terms in the sparce polynomial
    Term *head;       // a pointer to the doubly-linked circular list of
    // sparce polynomial
    /**
     * insert
     *
     * this is a private method to insert a new term into the polynomial
     * this function is called on, before the term pos passed into the parameter
     * @param pos
     * @param newCoefficient
     * @param power
     * @return true or false whether or not the term was inserted
     * @pre the term pos is the term you want to insert the new term before in
     *      the polynomial
     * @post the polynomial this funciton is called on will have a new term and size
     *       with the new term being inserted just before the term pos
     */
    bool insert( Term* pos, const double newCoefficient, const int power );

    /**
     * remove
     *
     * this is a function to remove a term from the polynomial and deallocate its memory
     * @param pos
     * @return true or false whether or not the term was removed
     * @pre pos is the correct term to remove and is not the header term
     * @post the term will be removed and memory deallocated
     */
    bool remove( Term* pos );

    /**
     * simplify
     *
     * this is a function to simplify the polynomial and remove any term
     * with a coefficient equal to 0
     * @param pos
     * @pre the polynomial passed into the funciton is well formed, ordered, and contains
     *      terms with a 0 coefficient
     * @post all terms with 0 coefficients will have been removed from the polynomial
     */
    void simplify(Polynomial *pos);
};

#endif

