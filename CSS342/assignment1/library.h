/*
 *  Created by Jordan Quigtar on 9/30/19.
 *  HW Assignment #1
 */


#ifndef HWASSIGNMENT1_LIBRARY_H
#define HWASSIGNMENT1_LIBRARY_H
#include <iostream>
using namespace std;

/*
 *library
 *
 * this is a class library that holds an array of books
 * that can be added to, removed from, listed and checked if a book is
 * in the library array. it also holds the number of books that is in
 * the array as a private instance variable.
 */
class Library {
private:
    static const int MAX = 100;
    string books[MAX];
    int numberOfBooks = 0;

    /*
     *findBook
     *
     * this is a private method that when ran will search through
     * the String array books and check to see if the book passed into
     * method is in the array.
     * will return the index of the book if it is in there, and -1 if it
     * is not.
     * this method is a helper method to the methods removeBook, addBook,
     * and isInLibrary
     */
    int findBook (const string &nameOfBook) const;

public:

    /*
     * library
     *
     * this is a constructor that creates a library object with
     * the first book being added from the parameter
     */
    Library (const string &nameOfBook);

    /*
     * addBook
     *
     * this is a method that returns true for if the book was
     * successfully added, and false if the book is already in library.
     */
    //
    bool addBook(const string &nameOfBook);

    /*
     * removeBook
     *
     * return true for if a book was in the library and successfully
     * removed, and false if the book to be removed if it is not in the library
     */
    bool removeBook(const string &nameOfBook);

    /*
     * listAllBooks
     *
     * this is a method that takes each string and
     * prints it to the console in the form
     * "book, book, book"
     */
    void listAllBooks() const;

    /*
     * isInLibrary
     *
     * this method returns true if the book is in the library,
     * and false otherwise.
     */
    bool isInLibrary (const string &nameOfBook) const;

    /*
     * friend function
     *
     * this function overides the << operator to stream the
     * object to the console.
     */
    friend ostream &operator<< (ostream &out, const Library &lib);
};


#endif //HWASSIGNMENT1_LIBRARY_H
