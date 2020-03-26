/*
 *  Created by Jordan Quigtar on 9/30/19.
 *  HW Assignment #1
 */

#include <iostream>
#include <cassert>
#include "library.h"
using namespace std;

/*
 * Test1
 *
 * this is a method with all of the code to
 * test the methods in the library class
 */
void Test1(){
    Library libs ("UWB");
    libs.addBook("Don Quixote");
    libs.addBook("In Search of Lost Time");
    libs.addBook("Ulysses");
    libs.addBook("The Odyssey");
    libs.listAllBooks();
    //should generate already in library message and return true
    bool result = libs.isInLibrary("The Odyssey");
    assert(result);

    //cannot add book twice, result should be false
    result = libs.addBook("The Odyssey");
    assert(!result);

    //test remove, result should be true
    result = libs.removeBook("The Odyssey");
    assert(result);

    //not in library, result should be false
    result = libs.isInLibrary("The Odyssey");
    assert(!result);

    //cannot remove twice, result should be false
    result = libs.removeBook("The Odyssey");
    assert(!result);

    //should generate true book was removed
    result = libs.removeBook("Ulysses");
    assert(result);

    //should generate true book was removed
    result = libs.removeBook("In Search of Lost Time");
    assert(result);

    //should generate true book was removed
    result = libs.removeBook("Don Quixote");
    assert(result);

    //should generate true book was removed
    result = libs.removeBook("UWB");
    assert(result);

    //should generate false noo books to remove
    result = libs.removeBook("Ulysses");
    assert(!result);

    //should generate true book was removed
    result = libs.addBook("Ulysses");
    assert(result);

    //should generate false book already exists
    result = libs.addBook("Ulysses");
    assert(!result);
}

/*
 * Test All
 *
 * this method runs the Test1 method and
 * prints to the console if all test were completed
 *
 */
void TestAll() {
    Test1();
    cout << "Successfully completed all test." << endl;
}

/*
 * main
 *
 * this is the main method where TestAll method will be run and
 * as well as the exit code.
 */
int main() {
    TestAll();
    return 0;
}